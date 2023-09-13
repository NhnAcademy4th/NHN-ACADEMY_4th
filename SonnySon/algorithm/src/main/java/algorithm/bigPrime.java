package algorithm;

public class bigPrime {
    private static double correctCount = 0;

    private static final int[][] TESTCASES = new int[][] {
            {10,20,30,40,30,30},
            {5,10,20,30,50,5}
    };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++)
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i][0], TESTCASES[i][1], TESTCASES[i][2],TESTCASES[i][3],TESTCASES[i][4]));

        System.out.println("정답률 = " + (int) (correctCount / TESTCASES.length * 100) + "%");
    }

    private static boolean test(int a,int b, int c,int d,int answer) {
        int[] arr= {a,b,c,d};
        boolean res = String.valueOf(solution(arr)).equals(answer);
        if (res)
            correctCount++;
        return res;
    }
    public static int solution(int[] input){
        int max = 0;
        for(int i = 0; i<input.length-1;i++){
            for (int j = 1; j < input.length; j++) {
                int result = max(input[i],input[j]);
                max = result > max ? result : max;
            }
        }
        return max;
    }
    public static int max(int x, int y){
        int number = x<y? x : y;
        while(x%number != 0 && y %number != 0){
            number--;
        }
        return number;
    }
}
