package com.example.ch03;

public class ex3_1 {
    public static void main(String[] args) {

        int count = 0;

        int random1;
        int random2;

        do {
            random1 = (int) (Math.random() * 6);
            random2 = (int) (Math.random() * 6);
            count++;
        } while (random1 != random2);

        System.out.println(count);
    }
}