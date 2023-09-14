package Chapter3;

public class Quiz3_14 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 42, 42};
        int count = 0;

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 42){
                count++;
            }
        }
        System.out.println("배열 numbers는 정수 42를 "  + count + "개 포함하고있습니다.");
    }
}
