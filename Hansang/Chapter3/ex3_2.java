package Chapter3;

public class ex3_2 {
    public static void main(String[] args) {
        int maxNum = 10000;
        int count = 0;
        int saveCount = 0;
        int saveNum =0;

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
                saveNum = i;
            }
        }

        System.out.println(saveNum + "이 보유한 약수는 "+ saveCount +"개로 가장 많습니다.");
    }
}
