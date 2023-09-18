package com.Chapter2;

import java.util.Scanner;

public class ex2_3 {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String name = sc.nextLine();
    StringBuilder sb = new StringBuilder();

    for(char c : name.toCharArray()){
        if(c >= 'a' && c <= 'z'){
               sb.append((char)(c - 32));
        }else if (c >= 'A' && c <= 'Z'){
               sb.append((char)(c + 32));
        }
    }

    name = sb.toString();

    System.out.println("Hello , " + name + " nice to meet you!");
    }

}
