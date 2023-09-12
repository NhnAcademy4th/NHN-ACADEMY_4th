import java.util.Scanner;

public class Ex_2_3 {
    public static void main(String[] args) {
        String userName;
        String upperCaseName;

        Scanner scn = new Scanner(System.in);
        System.out.print("이름: ");
        userName = scn.nextLine();

        upperCaseName = userName.toUpperCase();
        System.out.println("안녕하세요, " + upperCaseName + ", 만나서 반갑습니다. ");

        scn.close();
    }
}