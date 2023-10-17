package ch10.ex10_4;

import static ch10.ex10_4.Stream.*;

import java.util.ArrayList;
public class MainTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        remove(list,(a)->a%2==0);
        System.out.println(list);
        retain(list,(a) -> a%2 == 1);

        System.out.println(list);
        System.out.println(collect(list,(a)-> a%3==0));
        System.out.println(find(list, (a)-> a%5 == 0));
    }
}
