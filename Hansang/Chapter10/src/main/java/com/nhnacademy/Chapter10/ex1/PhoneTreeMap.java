package com.nhnacademy.Chapter10.ex1;

import java.util.TreeMap;

public class PhoneTreeMap {
    private TreeMap<String, String> data = new TreeMap<>();  // Array that holds the name/number pairs.

    private String find(String name) {
        return data.get(name);
    }

    public String getNumber(String name) {
        return find(name);
    }

    public void putNumber(String name, String number) {
        if (name == null || number == null) {
            throw new IllegalArgumentException("name and number cannot be null");
        }
        data.put(name, number);
    }
}



