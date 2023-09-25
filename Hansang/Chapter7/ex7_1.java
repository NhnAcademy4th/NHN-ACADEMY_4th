package com.nhnacademy.Chapter7;

import static com.nhnacademy.Chapter7.resource.Inputshell.setIntValue;

import java.util.ArrayList;


public class ex7_1 {
    public static int randomInt(int MAX_VALUE){
        int radomNumber = (int)(Math.random() * MAX_VALUE) + 1;
        return radomNumber;
    }

    private static ArrayList<Integer> arrayListAdder(ArrayList<Integer> arr, int MAX){
        arr.add(randomInt(MAX));
        return arr;
    }

    static void loopPerformer(int end, ArrayList<Integer> arr, int MAX){
        for(int i = 0; i < end; i++){
            arrayListAdder(arr, MAX);
        }
    }

    private static void codeActivater() {
        int endNumber = setIntValue("Enter end number >>");
        int MAX = setIntValue("Enter Max number >>");

        ArrayList<Integer> test = new ArrayList<>();
        loopPerformer(endNumber, test, MAX);
        System.out.println(test);
    }

    public static void main(String[] args) {
        codeActivater();
    }
}
