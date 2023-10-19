package ex10_7;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;

public class SimpleInterpreter {

    private static class ParseError extends Exception {
        ParseError(String message) {
            super(message);
        }
    }

    private enum Functions {
        SIN, COS, TAN, ABS, SQRT, LOG
    }

    private static class StandardFunction {
        Functions functionCode;

        StandardFunction(Functions code) {
            functionCode = code;
        }

        double evaluate(double x) {
            switch (functionCode) {
                case SIN:
                    return Math.sin(x);
                case COS:
                    return Math.cos(x);
                case TAN:
                    return Math.tan(x);
                case ABS:
                    return Math.abs(x);
                case SQRT:
                    return Math.sqrt(x);
                default:
                    return Math.log(x);
            }
        }
    }

    private Map<String, Object> symbolTable;
    private String command;
    private char[] terms;
    private int index;

    public SimpleInterpreter() {
        setSymbolTable();
        start();
    }

    private void setSymbolTable() {
        symbolTable = new HashMap<>();
        symbolTable.put("pi", Math.PI);
        symbolTable.put("e", Math.E);
        symbolTable.put("sin", new StandardFunction(Functions.SIN));
        symbolTable.put("cos", new StandardFunction(Functions.COS));
        symbolTable.put("tan", new StandardFunction(Functions.TAN));
        symbolTable.put("abs", new StandardFunction(Functions.ABS));
        symbolTable.put("sqrt", new StandardFunction(Functions.SQRT));
        symbolTable.put("log", new StandardFunction(Functions.LOG));
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nEnter commands; press return to end.");
        System.out.println("Commands must have the form:\n");
        System.out.println(" print <expression>");
        System.out.println(" or");
        System.out.println(" let <variable> = <expression>");

        while (true) {
            System.out.print("enter : ");

            command = scanner.nextLine().toLowerCase().replace(" ", "");

            if (command.isEmpty()) {
                break;
            }
            try {
                index = -1;
                if (command.indexOf("print") == 0) {
                    doPrintCommand();
                } else if (command.indexOf("let") == 0) {
                    doLetCommand();
                } else {
                    throw new ParseError("Command must begin with 'print' or 'let'.");
                }
            } catch (ParseError e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("\n\nDone.");
        scanner.close();
    }

    private void doLetCommand() throws ParseError {
        command = command.replace("let", "");
        int lastIndex = command.indexOf("=");
        if (lastIndex == -1) {
            throw new ParseError("Expected '=' operator for 'let' command.");
        }
        String variableName = of(Character::isLetter);
        System.out.println(variableName);

        if (symbolTable.containsKey(variableName)) {
            throw new ParseError("Variable Name " + variableName + " cannot use");
        }
        command = command.substring(lastIndex + 1, command.length());
        terms = command.toCharArray();
        double value = expressionValue();
        if (index != terms.length - 1) {
            throw new ParseError("Extra data after end of expression");
        }
        symbolTable.put(variableName, value);
        System.out.println("ok");
    }

    private void doPrintCommand() throws ParseError {
        command = command.replace("print", "");
        terms = command.toCharArray();

        double value = expressionValue();
        if (index != terms.length - 1) {
            throw new ParseError("Extra data after end of expression.");
        }
        System.out.println("Value is " + value);
    }

    private double expressionValue() throws ParseError {
        boolean negative = false;
        if (isNext('-')) {
            index++;
            negative = true;
        }
        double value = termValue();
        if (negative)
            value = -value;
        while (isNext('+') || isNext('-')) {
            char operator = terms[++index];
            double nextValue = termValue();
            value = operate(operator, value, nextValue);
        }
        return value;
    }

    private double termValue() throws ParseError {
        double value = factorValue();
        while (isNext('*') || isNext('/')) {
            char operator = terms[++index];
            double nextValue = factorValue();
            value = operate(operator, value, nextValue);
        }
        return value;
    }

    private double factorValue() throws ParseError {
        double value = primaryValue();
        if (isNext('^')) {
            index++;
            double nextValue = factorValue();
            value = Math.pow(value, nextValue);
            if (Double.isNaN(value))
                throw new ParseError("Illegal values for ^ operator.");
        }
        return value;
    }

    private double operate(char operator, double left, double right) {
        switch (operator) {
            case '+':
                return left + right;
            case '-':
                return left + right;
            case '*':
                return left * right;
            case '/':
                return left / right;
            default:
                throw new IllegalArgumentException("Unexpected operator : " + operator);
        }
    }

    private double primaryValue() throws ParseError {
        if (isNext(Character::isDigit)) {
            return Double.parseDouble(of(Character::isDigit));
        } else if (isNext(Character::isLetter)) {
            return readFunction();
        } else if (isNext('(')) {
            return readParenthesis();
        } else if (isNext(')'))
            throw new ParseError("Extra right parenthesis.");
        else if (isNext('+') || isNext('-') || isNext('*') || isNext('/'))
            throw new ParseError("Misplaced operator.");
        else
            throw new ParseError("Unexpected character \"" + terms[index + 1] + "\" encountered.");
    }

    private double readFunction() throws ParseError {
        String name = of(Character::isLetter);
        Object object = symbolTable.get(name);
        if (Objects.isNull(object)) {
            throw new ParseError("Unknown word\"" + name + "\"");
        }
        if (object instanceof Double) {
            Double value = (Double) object;
            return value.doubleValue();
        } else if (object instanceof StandardFunction) {
            StandardFunction function = (StandardFunction) object;
            if (!isNext('('))
                throw new ParseError("Parenthesis missing after standard function");
            return function.evaluate(readParenthesis());
        }
        throw new ParseError("wrong type");
    }

    private double readParenthesis() throws ParseError {
        index++;
        double argument = expressionValue();
        if (!isNext(')'))
            throw new ParseError("Parenthesis missing after standard function");
        index++;
        return argument;
    }

    private String of(Predicate<Character> predicate) {
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < terms.length - 1; i++) {
            if (!predicate.test(terms[index + 1]))
                break;
            sb.append(terms[++index]);
        }
        return sb.toString();
    }

    private boolean isNext(char value) {
        return isNext(x -> x == value);
    }

    private boolean isNext(Predicate<Character> predicate) {
        if (index + 1 == terms.length)
            return false;
        return predicate.test(terms[index + 1]);
    }

    public static void main(String[] args) {
        new SimpleInterpreter();
    }

}
