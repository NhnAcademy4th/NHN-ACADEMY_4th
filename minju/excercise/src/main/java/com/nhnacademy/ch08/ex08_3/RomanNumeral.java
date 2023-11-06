package com.nhnacademy.ch08.ex08_3;

public class RomanNumeral {

    private final int arabicNumber;
    private final String romanNumber;

    private static int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public RomanNumeral(int arabic) {
        if (arabic < 1)
            throw new NumberFormatException("Value of RomanNumeral must be positive.");
        if (arabic > 3999)
            throw new NumberFormatException("Value of RomanNumeral must be 3999 or less.");
        this.arabicNumber = arabic;
        this.romanNumber = arabicToRoman(arabic);
    }

    public RomanNumeral(String roman) {
        if (roman.isEmpty())
            throw new NumberFormatException("An empty string does not define a Roman numeral.");

        roman = roman.toUpperCase();
        this.romanNumber = roman;
        this.arabicNumber = romanToArabic(roman);
    }

    public int romanToArabic(String roman) {
        int index = 0;
        int arabic = 0;
        while (index < roman.length()) {
            int currentNumber = letterToNumber(roman.charAt(index));
            index++;
            if (index == roman.length()) {
                arabic += currentNumber;
                continue;
            }
            int nextNumber = letterToNumber(roman.charAt(index));
            if (nextNumber > currentNumber) {
                arabic += (nextNumber - currentNumber);
                index++;
            } else {
                arabic += currentNumber;
            }

        }
        if (arabic > 3999)
            throw new NumberFormatException("Roman numeral must have value 3999 or less.");
        return arabic;
    }

    private int letterToNumber(char letter) {
        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new NumberFormatException("Illegal character \"" + letter + "\" inRoman numeral");
        }
    }

    private String arabicToRoman(int arabic) {
        StringBuilder sb = new StringBuilder();
        int currentNumber = arabic;

        for (int i = 0; i < numbers.length; i++) {
            while (currentNumber >= numbers[i]) {
                sb.append(letters[i]);
                currentNumber -= numbers[i];
            }
        }

        return sb.toString();
    }

    public int getArabicNumber() {
        return arabicNumber;
    }

    public String getRomanNumber() {
        return romanNumber;
    }
}
