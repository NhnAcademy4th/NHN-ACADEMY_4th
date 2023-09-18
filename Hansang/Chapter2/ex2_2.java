package com.Chapter2;

public class ex2_2 {

    public static void main(String[] args) {
        int[] dies = new int[10];
        int result = 0;
        
        for(int i = 0; i < dies.length; i++){
            dies[i] = dice();
            System.out.println("The " + (i+1) + " die comes up " + dies[i]);
            result += dies[i];
        }

        
        System.out.println("Your total roll is " + result);
    }
public static int dice(){
    int dienum = (int) (Math.random()*6)+1;
    return dienum;
    }
}

