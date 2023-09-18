package ch07;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ch7_5 {

    public int[] list;

    private void createArrays(){
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int[] localList = new int[100];

        for(int i = 0; i<100 ;i++){
            // 0 을 입력하거나, 다른 문자열을 입력하면 return false
            String inputData;

            do{
                inputData = sc.next();
            }while(!isEndCondition(inputData));

            if(inputData.equals("0"))
                break;

            localList[i] = (Integer.parseInt(inputData));
            count++;
        }
        this.list = Arrays.copyOf(localList,count);
    }

    private boolean isEndCondition(String inputData){
        String PATTERN = "^\\d*$";

        if(!Pattern.matches(PATTERN,inputData)){
            System.out.println("정수만 입력가능");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ch7_5 test = new ch7_5();
        test.createArrays();
        QuickSort.sort(test.list);

        System.out.println(Arrays.toString(test.list));
    }
}
