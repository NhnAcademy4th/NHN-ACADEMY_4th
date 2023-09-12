import java.util.Scanner;

public class Ex_2_6 {
    public static void main(String[] args) {
        String firstName;
        String lastName;
        String input;
        int space;

        Scanner name = new Scanner(System.in);
        System.out.print("이름과 성을 공백으로 구분하여 입력: ");
        firstName = name.next();
        lastName = name.next();

        System.out.println("당신의 이름은 " + firstName + "이며, " + firstName.length() + " 문자 ");
        System.out.println("귀하의 성은 " + lastName + "이며, " + lastName.length() + " 문자 ");
        System.out.println("귀하의 이니셜은 " + firstName.charAt(0) + lastName.charAt(0));

        input = name.next();
        space = input.indexOf(' '); // 공백 문자 위치 찾기
        firstName = input.substring(0, space); // 0부터 공백 이전까지
        lastName = input.substring(space + 1); // 공백 다음부터 끝까지

        name.close();
    }
}
