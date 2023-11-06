package java_thread_programming.chapter5.quiz01;

public class BooleanExample {
    private static boolean flag = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                if (!flag) {
                    System.out.println("스레드 1: flag가 false이므로 작업 실행");
                    flag = true;
                } else {
                    System.out.println("스레드 1: flag가 이미 true이므로 작업 스킵");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                if (!flag) {
                    System.out.println("스레드 2: flag가 false이므로 작업 실행");
                    flag = true;
                } else {
                    System.out.println("스레드 2: flag가 이미 true이므로 작업 스킵");
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        // 메인 스레드가 모든 스레드의 실행을 기다림
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 최종 값 출력
        System.out.println("최종 값: " + flag);
    }
}
