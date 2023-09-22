package ch07;

import java.util.ArrayList;
public class ch7_1 {
    private static ArrayList<Integer> CreateArraylist(int maximumValue){
        ArrayList<Integer> result = new ArrayList<>();

        result.add((int)(Math.random()*maximumValue));
        result.add((int)(Math.random()*maximumValue));


        return result;
    }

    public static void main(String[] args) {
        System.out.println(ch7_1.CreateArraylist(12));
    }
}
