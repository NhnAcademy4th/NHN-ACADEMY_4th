package chapter2.example;

import chapter2.textio.TextIO;

public class Ex2_6 {
    public static void main(String[] args) {
        System.out.print("Please enter your first name and last name, separated by a space.\n? ");
        String userInput = TextIO.getln();
        String[] userInputList = userInput.split(" ");
        String firstName = userInputList[0];
        String lastName = userInputList[1];
        String initials = "" + firstName.charAt(0) + lastName.charAt(0);
        System.out.printf("Your first name is %s, which has %d characters\n", firstName, firstName.length());
        System.out.printf("Your last name is %s, which has %d characters\n", lastName, lastName.length());
        System.out.printf("Your initials are %s\n", initials);

    }
}
