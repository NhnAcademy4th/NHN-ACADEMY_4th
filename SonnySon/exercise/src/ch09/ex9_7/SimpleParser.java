package ch09.ex9_7;
import ch09.ex9_6.textio.TextIO;
import java.util.Scanner;

public class SimpleParser {
    static String EXPRESSION;
    static int pos;

    abstract private static class ExpNode {
        abstract double value(double xValue);
        abstract void printStackCommands();
        abstract ExpNode derivative();
    }
    private static class ConstNode extends ExpNode {
        double number;
        ConstNode(double val) {
            number = val;
        }
        double value(double xValue) {
            return number;
        }
        void printStackCommands() {
            System.out.println("  Push " + number);
        }
        ExpNode derivative(){return new ConstNode(0);}
    }
    private static class BinOpNode extends ExpNode {
        char op;        // The operator.
        ExpNode left;   // The expression for its left operand.
        ExpNode right;  // The expression for its right operand.
        BinOpNode(char op, ExpNode left, ExpNode right) {
            // Construct a BinOpNode containing the specified data.
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
                case '+':  return x + y;
                case '-':  return x - y;
                case '*':  return x * y;
                case '/':  return x / y;
                default:   return Double.NaN;  // Bad operator!
            }
        }
        void  printStackCommands() {
            left.printStackCommands();
            right.printStackCommands();
            System.out.println("  Operator " + op);
        }

        @Override
        ExpNode derivative() {
            switch (op) {
                case '+':  return new BinOpNode('+',left.derivative(),right.derivative());
                case '-':  return new BinOpNode('-',left.derivative(),right.derivative());
                case '*':  return new BinOpNode('+',new BinOpNode('*',left,right.derivative()),new BinOpNode('*',left.derivative(),right));
                case '/':  return new BinOpNode('/',new BinOpNode('-',new BinOpNode('*',left,right.derivative()),new BinOpNode('*',left.derivative(),right)),new BinOpNode('*',left,left));
                default:   return null;  // Bad operator!
            }
        }
    }

    private static class UnaryMinusNode extends ExpNode {
        ExpNode operand;  // The operand to which the unary minus applies.
        UnaryMinusNode(ExpNode operand) {
            // Construct a UnaryMinusNode with the specified operand.
            assert operand != null;
            this.operand = operand;
        }
        double value(double xValue) {
            // The value is the negative of the value of the operand.
            double neg = operand.value(xValue);
            return -neg;
        }
        void printStackCommands() {
            operand.printStackCommands();
            System.out.println("  Unary minus");
        }
        @Override
        ExpNode derivative() {
            return new UnaryMinusNode(operand.derivative());
        }
    }

    private static class VariableNode extends ExpNode {
        VariableNode() {
        }

        double value(double xValue) {
            return xValue;
        }

        void printStackCommands() {
            System.out.println("  Push X");
        }

        @Override
        ExpNode derivative() {
            return new ConstNode(1);
        }
    }

    private static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    } // end nested class ParseError
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n\nEnter an expression, or press return to end.");
            EXPRESSION = sc.nextLine().replaceAll(" ","");
            pos = 0;

            if ( EXPRESSION.isEmpty())
                break;
            try {
                ExpNode exp = expressionTree();

                if ( EXPRESSION.isEmpty() )
                    throw new ParseError("Extra data after end of expression.");
                System.out.println("\nValue at x = 0 is " + exp.value(0));
                System.out.println("\nValue at x = 1 is " + exp.value(1));
                System.out.println("\nValue at x = 2 is " + exp.value(2));
                System.out.println("\nValue at x = 3 is " + exp.value(3));
                System.out.println("\nOrder of postfix evaluation is:\n");
                exp.printStackCommands();
            }
            catch (ParseError e) {
                System.out.println("\n*** Error in input:    " + e.getMessage());
                System.out.println("*** Discarding input:  " + EXPRESSION);
            }
        }
        System.out.println("\n\nDone.");
    } // end main()

    /**
     * Reads an expression from the current line of input and builds
     * an expression tree that represents the expression.
     * @return an ExpNode which is a pointer to the root node of the
     *    expression tree
     * @throws ParseError if a syntax error is found in the input
     */
    private static ExpNode expressionTree() throws ParseError {

        boolean negative;  // True if there is a leading minus sign.
        negative = false;
        if (EXPRESSION.charAt(pos) == '-') {
            pos++;
            negative = true;
        }
        ExpNode exp;       // The expression tree for the expression.
        exp = termTree();  // Start with the first term.
        if (negative)
            exp = new UnaryMinusNode(exp);
        if(pos >= EXPRESSION.length()) return exp;

        while ( EXPRESSION.charAt(pos) == '+' || EXPRESSION.charAt(pos) == '-' ) {
            // Read the next term and combine it with the
            // previous terms into a bigger expression tree.
            char op = EXPRESSION.charAt(pos++);
            ExpNode nextTerm = termTree();
            exp = new BinOpNode(op, exp, nextTerm);
            if(pos >= EXPRESSION.length()) break;
        }
        return exp;
    } // end expressionTree()

    private static ExpNode termTree() throws ParseError {

        ExpNode term;  // The expression tree representing the term.
        term = factorTree();
        if(pos >= EXPRESSION.length()) return term;
        while ( EXPRESSION.charAt(pos) == '*' || EXPRESSION.charAt(pos) == '/' ) {
            // Read the next factor, and combine it with the
            // previous factors into a bigger expression tree.
            char op = EXPRESSION.charAt(pos++);
            ExpNode nextFactor = factorTree();

            term = new BinOpNode(op,term,nextFactor);

            if(pos >= EXPRESSION.length()) break;
        }
        return term;
    } // end termValue()

    private static ExpNode factorTree() throws ParseError {

        char ch = EXPRESSION.charAt(pos);

        if ( Character.isDigit(ch) ) {
            StringBuilder sb = new StringBuilder();

            while(Character.isDigit(EXPRESSION.charAt(pos))){
                sb.append(EXPRESSION.charAt(pos++));
                if(pos >= EXPRESSION.length()) break;
            }

            double num = Double.parseDouble(sb.toString());
            return new ConstNode(num);
        } if (ch == 'x' || ch == 'X') {
            pos++;
            return new VariableNode();
        } else if ( ch == '(' ) {
            pos++;  // Read the "("
            ExpNode exp = expressionTree();

            if ( EXPRESSION.charAt(pos) != ')' )
                throw new ParseError("Missing right parenthesis.");
            pos++;  // Read the ")"
            return exp;
        }
        else if ( ch == '\n' )
            throw new ParseError("End-of-line encountered in the middle of an expression.");
        else if ( ch == ')' )
            throw new ParseError("Extra right parenthesis.");
        else if ( ch == '+' || ch == '-' || ch == '*' || ch == '/' )
            throw new ParseError("Misplaced operator.");
        else
            throw new ParseError("Unexpected character \"" + ch + "\" encountered.");
    }
}