package com.nhnacademy;

public class ex4_1 {

    public static String printCapitalized(String str){
        StringBuilder sb = new StringBuilder();
        boolean isNextchar = true;

        for(char c : str.toCharArray()){
            if (isNextchar){
                sb.append(Character.toUpperCase(c));
            }else
                sb.append(c);

            if(Character.isLetter(c)){
                isNextchar = false;
            }else{
                isNextchar = true;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Now is the time to act!";

        str = printCapitalized(str);

        System.out.println(str);
    }
}
