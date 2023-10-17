package com.nhnacademy.Chapter9.ex7;

import com.nhnacademy.Chapter9.Inputshell;

public class Parser2 {
    abstract private static class ExpNode {
        abstract double value(double xValue);

        abstract void printStackCommands();

        abstract void printInfix();

        abstract ExpNode derivative();
    }

    private static class ConstNode extends ExpNode {
        double number;

        ConstNode(double number) {
            this.number = number;
        }

        double value(double xValue) {
            return number;
        }

        void printStackCommands() {
            System.out.println(" Push " + number);
        }

        void printInfix() {
            System.out.println(" derivate " + number);
        }

        ExpNode derivative() {
            return new ConstNode(0);
        }
    }

    private static class BinOpNode extends ExpNode {
        char op;
        ExpNode left;
        ExpNode right;

        BinOpNode(char op, ExpNode left, ExpNode right) {
            assert op == '+' || op == '-' || op == '*' || op == '/';
            assert left != null && right != null;

            this.op = op;
            this.left = left;
            this.right = right;
        }

        double value(double xValue) {
            double x = left.value(xValue);
            double y = right.value(xValue);
            switch (op) {
                case '+':
                    return x + y;
                case '-':
                    return x - y;
                case '*':
                    return x * y;
                case '/':
                    return x / y;
                default:
                    return Double.NaN;
            }
        }

        void printStackCommands() {
            left.printStackCommands();
            right.printStackCommands();
            System.out.println("Operator" + op);
        }

        void printInfix() {
            left.printInfix();
            right.printInfix();
            System.out.println("Operator" + op);
        }

        ExpNode derivative() {
            switch (this.op) {
                case '+':
                case '-':
                    return new BinOpNode(this.op, left.derivative(), right.derivative());
                case '*':
                    return new BinOpNode('+', new BinOpNode(this.op, left, right.derivative()),
                            new BinOpNode(this.op, right, left.derivative()));
                case '/':
                    return new BinOpNode('/', (new BinOpNode('-', new BinOpNode('*', left.derivative(), right),
                            new BinOpNode('*', right.derivative(), left))), new BinOpNode('*', right, right));
                default:
                    throw new IllegalArgumentException("can't derivative data!");
            }
        }
    }

    private static class UnaryMinusNode extends ExpNode {
        ExpNode operand;

        public UnaryMinusNode(ExpNode operand) {
            assert operand != null;
            this.operand = operand;
        }

        double value(double xValue) {
            double neg = operand.value(xValue);
            return -neg;
        }

        void printStackCommands() {
            operand.printStackCommands();
            System.out.println("Unary minus");
        }

        void printInfix() {
            System.out.println(" derivate Unary minus");
        }

        ExpNode derivative() {
            return new UnaryMinusNode(operand.derivative());
        }
    }

    private static class VariableNode extends ExpNode {
        public VariableNode() {

        }

        double value(double xValue) {
            return xValue;
        }

        void printStackCommands() {
            System.out.println(" Push X");
        }

        void printInfix() {
            System.out.println(" derivate X");
        }

        ExpNode derivative() {
            return new ConstNode(1);
        }
    }

    private static class parseError extends Exception {
        parseError(String message) {
            super(message);
        }
    }

    private static int index = 0;

    public static void main(String[] args) {
        String inputString;
        while (true) {
            inputString = Inputshell.inputFromShell("\nEnter an expression, or press return to end.\n >>");
            if (inputString == "\n") {
                break;
            }
            try {
                index = 0;
                ExpNode exp = expressionTree(inputString);
                if (lookChar(inputString, index) != '\n') {
                    throw new parseError("Extra data after end of expression.");
                }
                System.out.println("Value at x = 0 is" + exp.derivative().value(0));
                System.out.println("Value at x = 1 is" + exp.derivative().value(1));
                System.out.println("Value at x = 2 is" + exp.derivative().value(2));
                System.out.println("Value at x = 3 is" + exp.derivative().value(3));
                System.out.println("Order of postfix evaluation is:  ");
                exp.printStackCommands();
                exp.printInfix();
            } catch (parseError e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("shut down");
        Inputshell.scannerClose();
    }

    private static char lookChar(String buffer, int bufferIndex) {
        if (buffer == null || bufferIndex > buffer.length()) {
            throw new IllegalArgumentException("Data not exist!");
        } else if (bufferIndex == buffer.length()) {
            return '\n';
        } else if ((buffer.charAt(bufferIndex) == ' ')) {
            index++;
            return lookChar(buffer, index);
        } else {
            return buffer.charAt(bufferIndex);
        }
    }

    private static ExpNode expressionTree(String inputString) throws parseError {
        boolean negative = false;
        if (lookChar(inputString, index) == '-') {
            index++;
            negative = true;
        }
        ExpNode exp;
        exp = termTree(inputString);
        if (negative) {
            exp = new UnaryMinusNode(exp);
        }
        while (lookChar(inputString, index) == '-' || lookChar(inputString, index) == '+') {
            char op = lookChar(inputString, index);
            index++;
            ExpNode nextTerm = termTree(inputString);
            exp = new BinOpNode(op, exp, nextTerm);
        }
        return exp;
    }

    private static ExpNode termTree(String inputString) throws parseError {
        ExpNode term;
        term = factorTree(inputString);
        while (lookChar(inputString, index) == '*' || lookChar(inputString, index) == '/') {
            char op = lookChar(inputString, index);
            index++;
            ExpNode nextFactor = factorTree(inputString);
            term = new BinOpNode(op, term, nextFactor);
        }
        return term;
    }

    private static final String OPER_REGULAR = "[-+*/]";

    private static ExpNode factorTree(String inputString) throws parseError {
        char ch = lookChar(inputString, index);
        if (Character.isDigit(ch)) {
            StringBuilder sb = new StringBuilder();
            while (Character.isDigit(ch)) {
                sb.append(ch);
                index++;
                ch = lookChar(inputString, index);
            }
            return new ConstNode(Double.parseDouble(sb.toString()));
        } else if (Character.toUpperCase(ch) == 'X') {
            index++;
            return new VariableNode();
        } else if (ch == '(') {
            index++;
            ExpNode exp = expressionTree(inputString);
            if (lookChar(inputString, index) != ')') {
                throw new parseError("Missing right parenthesis");
            }
            index++;
            return exp;
        } else if (ch == '\n') {
            throw new parseError("End-of-Line encounterd in the middle of an expression.");
        } else if (ch == ')') {
            throw new parseError("Extra right parenthesis.");
        } else if (String.valueOf(ch).matches(OPER_REGULAR)) {
            throw new parseError("Misplaced operator.");
        } else {
            throw new parseError("Unexpected charactor \"" + ch + "\" encounterd.");
        }
    }

}
