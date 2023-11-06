package ch10.ex10_1;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MainTest {

    @Test
    static void inputTest(){
        PhoneDirectory directory = new PhoneDirectory();
        directory.putNumber("손병민", "010-1234-5678");
        Assertions.assertEquals("010-1234-5678",directory.getNumber("손병민"));
        System.out.println("inputTest passed");
    }

    @Test
    static void errorTest(){
        PhoneDirectory directory = new PhoneDirectory();
        directory.putNumber("손병민", "010-1234-5678");
        Assertions.assertThrows(NoSuchElementException.class,() -> directory.getNumber("이한상"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> directory.putNumber("", ""));
        Assertions.assertThrows(NullPointerException.class, () -> directory.putNumber(null, null));
        System.out.println("error Test passed");
    }
    public static void main(String[] args) {
        inputTest();
        errorTest();

        Scanner sc = new Scanner(System.in);
        PhoneDirectory directory = new PhoneDirectory();
        directory.putNumber(null,null);

    }
}
