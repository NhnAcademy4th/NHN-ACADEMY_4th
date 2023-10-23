package ch10.ex10_2;

import java.util.TreeSet;
import java.util.regex.Pattern;

public class SetCalculator {
    TreeSet<Integer> set;
    private void setInput(){
        while(true){
            TextIO.getln();
            TextIO.trim();
            if(Pattern.matches("^(\\[\\d+(,\\d+)*\\])[\\+\\-\\*](\\[\\d+(,\\d+)*\\])$",TextIO.buffer)) break;
            else System.out.println("형식에 맞지 않습니다.");
        }

        set = registSet();
        operator();
    }

    private void operator() {
        char oper = TextIO.next();
        switch (oper){
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

    private TreeSet<Integer> registSet(){
        TreeSet<Integer> resultList = new TreeSet<>();
        if(TextIO.next() == '['){
            while(true){
                resultList.add(createInteger());
                if(TextIO.next() == ']') break;
            }
        }
        return resultList;
    }
    private int createInteger(){
        StringBuilder sb = new StringBuilder();
        while(Character.isDigit(TextIO.peek())){
            sb.append(TextIO.next());
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        SetCalculator calculator = new SetCalculator();
        calculator.setInput();
    }
}
