package ch10.ex10_7;

import java.util.HashMap;

public class SimpleInterpreter {
    private static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    }
    private static HashMap<String, Object> symbolTable;


    public static void main(String[] args) {

        symbolTable = new HashMap<>();

        symbolTable.put("pi", Math.PI);
        symbolTable.put("e", Math.E);
        symbolTable.put("sin",new StandardFunction(Functions.SIN));
        symbolTable.put("cos",new StandardFunction(Functions.COS));
        symbolTable.put("tan",new StandardFunction(Functions.TAN));
        symbolTable.put("abs",new StandardFunction(Functions.ABS));
        symbolTable.put("SQRT",new StandardFunction(Functions.SQRT));
        symbolTable.put("LOG",new StandardFunction(Functions.LOG));

        System.out.println("\n\nEnter commands; press return to end.");
        System.out.println("Commands must have the form:\n");
        System.out.println("      print <expression>");
        System.out.println("  or");
        System.out.println("      let <variable> = <expression>");

        while (true) {
            TextIO.getln();
            if ( TextIO.peek() == '\n' ) {
                break;  // A blank input line ends the while loop and the program.
            }
            try {
                String command = TextIO.getWord();
                if (command.equalsIgnoreCase("print"))
                    doPrintCommand();
                else if (command.equalsIgnoreCase("let"))
                    doLetCommand();
                else
                    throw new ParseError("Command must begin with 'print' or 'let'.");
            }
            catch (ParseError e) {
                System.out.println("\n*** Error in input:    " + e.getMessage());
                System.out.println("*** Discarding input:  " + TextIO.getln());
            }
        }

        System.out.println("\n\nDone.");

    }
    private static void doLetCommand() throws ParseError {
        TextIO.skipBlanks();
        if ( ! Character.isLetter(TextIO.peek()) )
            throw new ParseError("Expected variable name after 'let'.");
        String varName = readWord();  // The name of the variable.
        TextIO.skipBlanks();
        if ( TextIO.peek() != '=' )
            throw new ParseError("Expected '=' operator for 'let' command.");
        TextIO.next();
        double val = expressionValue();  // The value of the variable.
        TextIO.skipBlanks();
        if ( TextIO.peek() != '\n' )
            throw new ParseError("Extra data after end of expression.");
        symbolTable.put( varName, val );  // Add to symbol table.
        System.out.println("ok");
    }
    private static void doPrintCommand() throws ParseError {
        double val = expressionValue();
        TextIO.skipBlanks();
        if ( TextIO.peek() != '\n' )
            throw new ParseError("Extra data after end of expression.");
        System.out.println("Value is " + val);
    }
    private static double expressionValue() throws ParseError {
        TextIO.skipBlanks();
        boolean negative;  // True if there is a leading minus sign.
        negative = false;
        if (TextIO.peek() == '-') {
            TextIO.next();
            negative = true;
        }
        double val;  // Value of the expression.
        val = termValue();  // An expression must start with a term.
        if (negative)
            val = -val; // Apply the leading minus sign
        TextIO.skipBlanks();
        while ( TextIO.peek() == '+' || TextIO.peek() == '-' ) {
            // Read the next term and add it to or subtract it from
            // the value of previous terms in the expression.
            char op = TextIO.next();
            double nextVal = termValue();
            if (op == '+') {
                System.out.println(val+","+nextVal);
                val += nextVal;
            }
            else
                val -= nextVal;
            TextIO.skipBlanks();
        }
        return val;
    }
    private static double termValue() throws ParseError {
        TextIO.skipBlanks();
        double val;  // The value of the term.
        val = factorValue();  // A term must start with a factor.
        TextIO.skipBlanks();
        while ( TextIO.peek() == '*' || TextIO.peek() == '/' ) {
            // Read the next factor, and multiply or divide
            // the value-so-far by the value of this factor.
            char op = TextIO.next();
            double nextVal = factorValue();
            if (op == '*')
                val *= nextVal;
            else
                val /= nextVal;
            TextIO.skipBlanks();
        }
        return val;
    }
    private static double factorValue() throws ParseError {
        TextIO.skipBlanks();
        double val;  // Value of the factor.
        val = primaryValue();  // A factor must start with a primary.
        TextIO.skipBlanks();
        if ( TextIO.peek() == '^' ) {
            // Read the next factor, and exponentiate
            // the value by the value of that factor.
            TextIO.next();
            double nextVal = factorValue();
            val = Math.pow(val,nextVal);
            if (Double.isNaN(val))
                throw new ParseError("Illegal values for ^ operator.");
            TextIO.skipBlanks();
        }
        return val;
    }
    private static double primaryValue() throws ParseError {
        TextIO.skipBlanks();
        char ch = TextIO.peek();
        if ( Character.isDigit(ch) ) {
            return TextIO.getDouble();
        }
        else if ( Character.isLetter(ch) ) {
            String name = readWord();
            Double val;
            if(symbolTable.get(name) instanceof Double) {
                val = (Double) symbolTable.get(name);
                if(val == null) throw new ParseError("Unknown variable \"" + name + "\"");
            }
            else if(symbolTable.get(name) instanceof StandardFunction){
                val = termValue();
                if(val == null) throw new ParseError("Unknown variable \"" + name + "\"");
                val = ((StandardFunction) symbolTable.get(name)).evaluate(val);
            }else throw new ParseError("Unknown variable \"" + name + "\"");

            return val;
        }
        else if ( ch == '(' ) {
            // The factor is an expression in parentheses.
            // Return the value of the expression.
            TextIO.next();  // Read the "("
            double val = expressionValue();
            TextIO.skipBlanks();
            if ( TextIO.peek() != ')' )
                throw new ParseError("Missing right parenthesis.");
            TextIO.next();  // Read the ")"
            return val;
        }
        else if ( ch == '\n' )
            throw new ParseError("End-of-line encountered in the middle of an expression.");
        else if ( ch == ')' )
            throw new ParseError("Extra right parenthesis.");
        else if ( ch == '+' || ch == '-' || ch == '*' || ch == '/')
            throw new ParseError("Misplaced operator.");
        else
            throw new ParseError("Unexpected character \"" + ch + "\" encountered.");
    }

    private static String readWord() {
        String word = "";  // The word.
        char ch = TextIO.peek();
        while (Character.isLetter(ch) || Character.isDigit(ch)) {
            word += TextIO.next();
            ch = TextIO.peek();
        }
        return word;
    }

}