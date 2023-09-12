package com.Hansang;

public class ex2_2 {

    public static void main(String[] args) {
        int die1 = dice();
        int die2 = dice();

        System.out.println("The first die comes up " + die1);
        System.out.println("The second die comes up " + die2);
        System.out.println("Your total roll is " + (die1 + die2));
    }
public static int dice(){
    int dienum = (int) (Math.random()*6)+1;
    return dienum;
    }
}

