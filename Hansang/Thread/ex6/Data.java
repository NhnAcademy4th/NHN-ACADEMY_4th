package com.nhnacademy.ex6;

public class Data {
    private String[] stringData;

    public Data() {
    }

    public void setStringData(String[] stringData) {
        this.stringData = stringData;
    }

    public String getStringData(int index) {
        return stringData[index];
    }

    public void send(String[] stringData) {
        setStringData(stringData);
    }

    public void receive() {
        for (int i = 0; i < stringData.length; i++) {
            System.out.println(getStringData(i));
        }
    }

}
