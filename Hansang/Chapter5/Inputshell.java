package com.nhnacademy.Chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inputshell {
    public static String inputFromshell() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String value = reader.readLine();
        return value;
    }
}
