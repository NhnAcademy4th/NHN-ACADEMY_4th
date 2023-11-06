package ch10.ex10_2;

import java.util.TreeSet;
import java.util.regex.Pattern;

public class SetCalculator <T extends Comparable>{
    TreeSet<T> set;
    private void routin(){
        setInput();
        set = registSet();
        operator();
    }
    private void setInput(){
        while(true){
            TextIO.getln();
            TextIO.trim();
            if(Pattern.matches("^(\\[\\d+(,\\d+)*\\])[\\+\\-\\*](\\[\\d+(,\\d+)*\\])$",TextIO.buffer)) break;
            System.out.println("형식에 맞지 않습니다.");
        }
    }

    private void operator() {
        char operator = TextIO.next();
        switch (operator){
            case '+':
                set.addAll(registSet());
                System.out.print(set);
                break;
            case '-':
                set.removeAll(registSet());
                System.out.print(set);
                break;
            case '*':
                set.retainAll(registSet());
                System.out.print(set);
                break;
            default:
                throw new IllegalArgumentException("잘못된 operator");
        }
    }

    private TreeSet<T> registSet(){
        TreeSet<T> resultList = new TreeSet<>();
        if(TextIO.next() == '['){
            while(true){
                resultList.add(createInteger());
                if(TextIO.next() == ']') break;
            }
        }
        return resultList;
    }
    private T createInteger(){
        StringBuilder sb = new StringBuilder();
        while(Character.isDigit(TextIO.peek())){
            sb.append(TextIO.next());
        }
        return (T) sb.toString();
    }

    public static void main(String[] args) {
        SetCalculator calculator = new SetCalculator();
        calculator.routin();
        TextIO.close();
    }
}
