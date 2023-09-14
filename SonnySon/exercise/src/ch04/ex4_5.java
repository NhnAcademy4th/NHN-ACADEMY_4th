package ch04;

//배열에서 최대값 찾기, 배열에서 최소값 찾기, 배열에서 값 의 합계 찾기 , 배열에 있는 값의 평균
public class ex4_5 {
    private static final ArrayProcessor maxValue = arr -> {
        double result = 0;

        for (double value : arr) {
            result = Double.max(result, value);
        }
        return result;
    };

    private static final ArrayProcessor minValue = arr -> {
        double result = Double.MAX_VALUE;

        for (double value : arr) {
            result = Double.min(result, value);
        }
        return result;
    };

    private static final ArrayProcessor sumValue = arr -> {
        double result = 0;

        for (double value : arr) {
            result += value;
        }
        return result;
    };

    private static final ArrayProcessor averValue = arr -> sumValue.apply(arr) / arr.length;

    public static void main(String[] args) {
        double[] arr = {1.0, 43.0, 23.0, 94.12, 3.91};

        System.out.println(maxValue.apply(arr));
        System.out.println(minValue.apply(arr));
        System.out.println(sumValue.apply(arr));
        System.out.println(averValue.apply(arr));
    }

}
