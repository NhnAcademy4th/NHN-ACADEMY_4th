package ch03;

// 생일이 같은 세 사람 을 찾으려면 무작위로 몇 명을 선택해야 합니까 ? (즉, 세 사람 모두 같은 달 같은 날에 태어났지만 반드시 같은 해에 태어난 것은 아닙니다.)
// 무작위로 365명을 선택한다고 가정해 보겠습니다. 그들의 생일은 몇 개나 될까요? (이론적으로 숫자는 1에서 365 사이일 수 있습니다.)
// 1년 365일 생일이 있는 사람을 최소한 한 명씩 찾으려면 얼마나 많은 사람을 확인해야 합니까?

public class ex3_7 {

    private static int solution1() {
        int[] birthDay = new int[365];
        int count = 0;
        while (true) {
            count++;
            if (++birthDay[(int) (Math.random() * 365)] == 3) {
                return count;
            }
        }
    }

    private static int solution2() {
        boolean[] birthDay = new boolean[365];

        int count = 0;
        for (int i = 0; i < birthDay.length; i++) {
            int randomDay = (int) (Math.random() * 365);
            if (!birthDay[randomDay]) {
                count++;
                birthDay[randomDay] = true;
            }
        }
        return count;
    }

    private static int solution3() {

        boolean[] birthDay = new boolean[365];

        int count = 0;
        int random;
        int tries = 0;

        // 종료 조건 컨닝함
        while (count < 365) {
            random = (int) (Math.random() * 365);
            if (birthDay[random] == false) {
                count++;
                birthDay[random] = true;
            }
            tries++;
        }
        return tries;
    }

    public static void main(String[] args) {
        System.out.println(solution1());
        System.out.println(solution2());
        System.out.println(solution3());
    }

}
