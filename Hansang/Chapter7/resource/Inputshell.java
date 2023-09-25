package com.nhnacademy.Chapter7.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inputshell {
    public static String inputFromshell() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String value = reader.readLine();
        return value;
    }

    public static int setIntValue(String str){
        int sizeValue;
        try{
            System.out.print(str);
            sizeValue = Integer.parseInt(inputFromshell());
        } catch (Exception e) {
            throw new IllegalArgumentException("Not boundary of Integer!");
        }
        return sizeValue;
    }

    public static Double setFloatValue(String str){
        Double sizeValue;
        try{
            System.out.print(str);
            sizeValue = Double.parseDouble(inputFromshell());
        } catch (Exception e) {
            throw new IllegalArgumentException("Not boundary of Integer!");
        }
        return sizeValue;
    }
}
