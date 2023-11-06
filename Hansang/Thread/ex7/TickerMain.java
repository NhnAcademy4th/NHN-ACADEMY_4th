package com.nhnacademy.ex7;

import com.nhnacademy.Inputshell;

public class TickerMain {

    public static Ticker inputData() {
        Inputshell inputshell = new Inputshell();
        String inputNumber;
        String regEx = "^([0-9])+[n,N]*$";
        while (true) {
            inputNumber = inputshell.inputFromShell("Please input number(default unit is milliseconds) :");
            if (inputNumber.matches(regEx)) {
                break;
            }
        }

        long parsedNum = 0;
        int parsedIntNum = 0;
        Ticker ticker;
        if (Character.isLetter(inputNumber.charAt((inputNumber.length() - 1)))) {
            parsedIntNum = Integer.parseInt(inputNumber.substring(0, (inputNumber.length() - 1)));
            if (parsedIntNum < 0 || parsedIntNum > 999999) {
                System.out.println("nanos input range must more than 0 and less than 999999");
                inputData();
            }
        } else {
            parsedNum = Long.parseLong(inputNumber);
        }
        ticker = new Ticker(parsedNum, parsedIntNum);

        return ticker;
    }

    public static void main(String[] args) {
        Ticker ticker = inputData();

        ticker.start();

    }
}
