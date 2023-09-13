package ch03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ex3_5 {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("src/ch03/sales.dat");
        Scanner sc = new Scanner(reader);

        int sum = 0;
        int noReportCount = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            try {
                sum += Double.parseDouble(line.substring(line.indexOf(":") + 1));
            } catch (NumberFormatException e) {
                noReportCount++;
            }
        }
        System.out.println("Cities sale : " + sum);
        System.out.println("no Report Cities Count : " + noReportCount);
    }
}
