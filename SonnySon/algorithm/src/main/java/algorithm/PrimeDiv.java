//package algorithm;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PrimeDiv {
//
//        private static final int[] TEST_CASES = {
//                1,
//                60,
//                256,
//                325,
//                20_160,
//                3_456_789,
//                10_000_001,
//                1_234_567_890
//        };
//
//        private static final String[] TEST_CASES_RESULT = {
//                "1 = 1",
//                "2 * 2 * 3 * 5 = 60",
//                "2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 = 256",
//                "5 * 5 * 13 = 325",
//                "2 * 2 * 2 * 2 * 2 * 2 * 3 * 3 * 5 * 7 = 20160",
//                "3 * 7 * 97 * 1697 = 3456789",
//                "11 * 909091 = 10000001",
//                "2 * 3 * 3 * 5 * 3607 * 3803 = 1234567890"
//        };
//
//        public static void main(String[] args) {
//            for (int i = 0; i < TEST_CASES.length; i++) {
//                System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASES[i], TEST_CASES_RESULT[i]));
//            }
//
//            System.out.printf("정답률 = %.3f%%", (correct / TEST_CASES.length * 100));
//        }
//
//        private static double correct = 0;
//
//        private static boolean test(int input, String result) {
//            if (solution(input).equals(result)) {
//                correct++;
//                return true;
//            }
//
//            return false;
//        }
//
//        public static void solution(int num,int prime) {
//
//            if(num == 1){
//                System.out.println(1);
//            }else if(num%prime == 0){
//                System.out.println(prime);
//                solution(num/prime,prime);
//            }else{
//                solution(num,++prime);
//            }
//        }
//
//    private static boolean isPrime(int num) {
//        if (num <= 1) {
//            return false;
//        }
//        for (int i = 2; i * i <= num; i++) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//}
