package ch09.ex9_6;
import ch09.ex9_6.textio.TextIO;

public class SimpleParser {
    abstract private static class ExpNode {
        abstract double value(double xValue);
        abstract void printStackCommands();
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
    }

    private static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    } // end nested class ParseError


    public static void main(String[] args) {

        while (true) {
            System.out.println("\n\nEnter an expression, or press return to end.");
            System.out.print("\n?  ");
            TextIO.skipBlanks();
            if ( TextIO.peek() == '\n' )
                break;
            try {
                ExpNode exp = expressionTree();
                TextIO.skipBlanks();
                if ( TextIO.peek() != '\n' )
                    throw new ParseError("Extra data after end of expression.");
                TextIO.getln();
                System.out.println("\nValue at x = 0 is " + exp.value(0));
                System.out.println("\nValue at x = 1 is " + exp.value(1));
                System.out.println("\nValue at x = 2 is " + exp.value(2));
                System.out.println("\nValue at x = 3 is " + exp.value(3));
                System.out.println("\nOrder of postfix evaluation is:\n");
                exp.printStackCommands();
            }
            catch (ParseError e) {
                System.out.println("\n*** Error in input:    " + e.getMessage());
                System.out.println("*** Discarding input:  " + TextIO.getln());
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
        TextIO.skipBlanks();
        boolean negative;  // True if there is a leading minus sign.
        negative = false;
        if (TextIO.peek() == '-') {
            TextIO.getAnyChar();
            negative = true;
        }
        ExpNode exp;       // The expression tree for the expression.
        exp = termTree();  // Start with the first term.
        if (negative)
            exp = new UnaryMinusNode(exp);
        TextIO.skipBlanks();
        while ( TextIO.peek() == '+' || TextIO.peek() == '-' ) {
            // Read the next term and combine it with the
            // previous terms into a bigger expression tree.
            char op = TextIO.getAnyChar();
            ExpNode nextTerm = termTree();
            exp = new BinOpNode(op, exp, nextTerm);
            TextIO.skipBlanks();
        }
        return exp;
    } // end expressionTree()

    private static ExpNode termTree() throws ParseError {
        TextIO.skipBlanks();
        ExpNode term;  // The expression tree representing the term.
        term = factorTree();
        TextIO.skipBlanks();
        while ( TextIO.peek() == '*' || TextIO.peek() == '/' ) {
            // Read the next factor, and combine it with the
            // previous factors into a bigger expression tree.
            char op = TextIO.getAnyChar();
            ExpNode nextFactor = factorTree();

            term = new BinOpNode(op,term,nextFactor);
            TextIO.skipBlanks();
        }
        return term;
    } // end termValue()

    private static ExpNode factorTree() throws ParseError {
        TextIO.skipBlanks();
        char ch = TextIO.peek();
        if ( Character.isDigit(ch) ) {
            // The factor is a number.  Return a ConstNode.
            double num = TextIO.getDouble();
            return new ConstNode(num);
        } else if (ch == 'x' || ch == 'X') {
            TextIO.getAnyChar();
            return new VariableNode();
        } else if ( ch == '(' ) {
            // The factor is an expression in parentheses.
            // Return a tree representing that expression.
            TextIO.getAnyChar();  // Read the "("
            ExpNode exp = expressionTree();
            TextIO.skipBlanks();
            if ( TextIO.peek() != ')' )
                throw new ParseError("Missing right parenthesis.");
            TextIO.getAnyChar();  // Read the ")"
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
    }  // end factorTree()


} // end class SimpleParser3