import textio.TextIO;

public class ex3_3 {

    public static void main(String[] args) {

        startOperation();

    }

    private static void startOperation() {
        while (true) {
            System.out.print("첫번째 숫자를 입력해주세요 : ");
            double firstNum = TextIO.getDouble();

            if (firstNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.print("연산자를 입력해주세요 : ");
            char operator = TextIO.getChar();

            System.out.print("두번째 숫자를 입력해주세요 : ");
            double secondNum = TextIO.getDouble();

            if (operator == '+') {
                System.out.println(add(firstNum, secondNum));
            } else if (operator == '-') {
                System.out.println(subtract(firstNum, secondNum));
            } else if (operator == '*') {
                System.out.println(multiply(firstNum, secondNum));
            } else if (operator == '/') {
                try {
                    System.out.println(divide(firstNum, secondNum));
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                try {
                    throw new IllegalArgumentException("연산자가 잘못 입력되었습니다.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }

    private static double add(double x, double y) {
        return x + y;
    }

    private static double subtract(double x, double y) {
        return x - y;
    }

    private static double multiply(double x, double y) {
        return x * y;
    }

    private static double divide(double x, double y) {
        if (y == 0)
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return x / y;
    }

}
