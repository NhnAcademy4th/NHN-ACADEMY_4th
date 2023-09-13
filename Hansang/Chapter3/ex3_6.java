package Chapter3;

import java.util.ArrayList;

public class ex3_6 {
    public static ArrayList<Integer> findSame(ArrayList<Integer> saveList, ArrayList<Integer> numList){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = saveList.size() - 1; i >= 0; i--){
            if(saveList.get(saveList.size() - 1) == saveList.get(i)){
                result.add(numList.get(i));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int maxNum = 10000;
        int count = 0;
        int saveCount = 0;
        ArrayList<Integer> saveList = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> result;

        for(int i = 1; i <= maxNum; i++){
            count = 0;
            for(int j = 1; j <= Math.sqrt(i); j++)
            {
                if(i % j == 0){
                    count+=2;
                    }
            }
            if(saveCount <= count){
                saveCount = count;

                saveList.add(saveCount);
                numList.add(i);
            }
        }

        result = findSame(saveList, numList);


        System.out.println("가장 많은 약수의 수는 "+ saveCount +"개로 가장 많습니다.");
        System.out.println("해당 수만큼 약수를 가진 숫자는..");
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
