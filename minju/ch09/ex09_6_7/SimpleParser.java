package ex09_6_7;

import java.util.Scanner;

public class SimpleParser {

    private String[] values;
    private int count;
    private ExpNode expression;

    public void startParse(int init) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n\n다항식을 입력해주세요. 구분자는 공백문자 입니다. : ");
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            values = line.split(" ");
            count = -1;
            try {
                expression = expressionTree();
                printExpression(init);
            } catch (Exception e) {
                System.out.println("exception " + e.getMessage());
            }
        }
        System.out.println("종료합니다.");
        scanner.close();
    }

    private void printExpression(int init) {
        switch (init) {
            case 0:
                printStack();
                break;
            case 1:
                printDerivative();
                break;
            default:
        }
    }

    private void printStack() {
        expression.printStackCommands();
        System.out.println("x = 1 : " + expression.value(1));
        System.out.println("x = 2 : " + expression.value(2));
        System.out.println("x = 3 : " + expression.value(3));
        System.out.println("x = 4 : " + expression.value(4));
    }

    private void printDerivative() {
        expression.derivative().printInfix();
    }

    private ExpNode expressionTree() throws ParseException {
        ExpNode expNode = termTree();
        String operator;
        try {
            while (values[count + 1].matches("[+-]")) {
                operator = values[++count];
                if (operator.length() != 1) {
                    throw new ParseException("expressionTree() : " + operator + "는 잘못된 연산자입니다.");
                }
                ExpNode nextTerm = termTree();
                expNode = new BinOpNode(operator.charAt(0), expNode, nextTerm);
            }
            return expNode;
        } catch (Exception e) {
            return expNode;
        }
    }

    private ExpNode termTree() throws ParseException {
        ExpNode term = factorTree();
        String operator;
        try {
            while (values[count + 1].matches("[/*]")) {
                operator = values[++count];
                if (operator.length() != 1) {
                    throw new ParseException("expressionTree() : " + operator + "는 잘못된 연산자입니다.");
                }
                ExpNode nextTerm = factorTree();
                term = new BinOpNode(operator.charAt(0), term, nextTerm);
            }
            return term;
        } catch (Exception e) {
            return term;
        }
    }

    private ExpNode factorTree() throws ParseException {
        String term = values[++count];
        if (term.matches("\\(?-?\\d+\\.?\\d?+\\)?")) {
            term = term.replace("(", "");
            term = term.replace(")", "");
            return new ConstNode(Double.parseDouble(term));
        } else if (term.equalsIgnoreCase("x")) {
            return new VariableNode();
        } else if (term.equals("(")) {
            ExpNode nextTerm = expressionTree();
            if (!values[++count].equals(")"))
                throw new ParseException("factorTree() : 오른쪽 괄호가 입력되지 않았습니다.");
            return nextTerm;
        }
        throw new ParseException("factorTree() : " + term + "은(는) 사용될 수 없습니다.");
    }
}
