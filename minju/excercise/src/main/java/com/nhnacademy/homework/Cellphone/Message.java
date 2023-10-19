package com.nhnacademy.homework.Cellphone;

public class Message {
    private final String text;
    private final String phoneNumber;

    public Message(String text, String phoneNumber) {
        this.text = text;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return text;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
