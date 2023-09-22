package com.Chapter2;

public class ex2_1 {
    public static void djeMaker(){
        starPrinter(5);
        spacePrinter(11);
        starPrinter(13);
        spacePrinter(9);
        starPrinter(10);
        System.out.println();
        starPrinter(2);
        spacePrinter(4);
        starPrinter(2);
        spacePrinter(16);
        starPrinter(2);
        spacePrinter(12);
        starPrinter(2);
        System.out.println();
        starPrinter(2);
        spacePrinter(5);
        starPrinter(2);
        spacePrinter(15);
        starPrinter(2);
        spacePrinter(12);
        starPrinter(2);
        System.out.println();
        starPrinter(2);
        spacePrinter(6);
        starPrinter(2);
        spacePrinter(14);
        starPrinter(2);
        spacePrinter(12);
        starPrinter(2);
        System.out.println();
        starPrinter(2);
        spacePrinter(6);
        starPrinter(2);
        spacePrinter(14);
        starPrinter(2);
        spacePrinter(12);
        starPrinter(8);
        System.out.println();
        starPrinter(2);
        spacePrinter(6);
        starPrinter(2);
        spacePrinter(7);
        starPrinter(2);
        spacePrinter(5);
        starPrinter(2);
        spacePrinter(12);
        starPrinter(2);
        System.out.println();
        starPrinter(2);
        spacePrinter(5);
        starPrinter(2);
        spacePrinter(9);
        starPrinter(2);
        spacePrinter(4);
        starPrinter(2);
        spacePrinter(12);
        starPrinter(2);
        System.out.println();
        starPrinter(2);
        spacePrinter(4);
        starPrinter(2);
        spacePrinter(11);
        starPrinter(2);
        spacePrinter(2);
        starPrinter(2);
        spacePrinter(13);
        starPrinter(2);
        System.out.println();
        starPrinter(4);
        spacePrinter(16);
        starPrinter(4);
        spacePrinter(14);
        starPrinter(10);
    }

    public static void starPrinter(int num){
        for(int i= 0; i < num; i++){
        System.out.print("*");}
    }

    public static void spacePrinter(int num){
        for(int i= 0; i < num; i++){
        System.out.print(" ");}
    }

    public static void main(String[] args) {
        djeMaker();
    }
}
