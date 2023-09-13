public class ex3_7 {
    public static void main(String[] args) {

        System.out.println("세 명 생일 중복 시도 횟수 : " + threeBirthdayOverlab());
        System.out.println("365번 생일을 확인 했을 때 생일 개수 : " + count365Birthday());
        System.out.println("365일 모두 생일인 사람 찾는 횟수 : " + allBirthdayfind());

    }

    private static int threeBirthdayOverlab() {
        int[] used = new int[365];
        int count = 0;

        while (true) {
            int birthday = (int) (Math.random() * 365);

            if (used[birthday] == 3) {
                break;
            }

            used[birthday] += 1;
            count++;
        }

        return count;

    }

    private static int count365Birthday() {

        boolean[] used = new boolean[365];
        int count = 0;

        for (int i = 0; i < 365; i++) {
            int birthday = (int) (Math.random() * 365);
            used[birthday] = true;
        }

        for (int i = 0; i < 365; i++) {
            if (used[i]) {
                count++;
            }
        }

        return count;
    }

    private static int allBirthdayfind() {

        boolean[] used = new boolean[365];
        int count = 0;

        while (true) {

            int birthday = (int) (Math.random() * 365);
            if (!(used[birthday])) {
                used[birthday] = true;
            } else {
                if (searchBirthday(used))
                    break;
            }
            count++;
        }

        return count;

    }

    private static boolean searchBirthday(boolean[] used) {
        for (boolean birthday : used) {
            if (!birthday) {
                return false;
            }
        }
        return true;
    }
}