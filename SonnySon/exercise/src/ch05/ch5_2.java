package ch05;

import ch05.resource.StatCalc;
import java.sql.Array;
import java.util.*;

public class ch5_2 {
    public static void main(String[] args) {
        StatCalc calc = new StatCalc();

        calc.enter(43.23);
        calc.enter(132);
        calc.enter(0.2324);

        System.out.println(calc.getCount());
        System.out.println(calc.getCount());
        System.out.println(calc.getSum());
        System.out.println(calc.getMean());
        System.out.println(calc.getMax());
        System.out.println(calc.getMin());
    }
}
