package java_thread_programming.chapter5.quiz01;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanExample {

    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        // 스레드 1
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("스레드 1: 현재 값 " + atomicBoolean.get());
                atomicBoolean.set(true);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 스레드 2
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("스레드 2: 현재 값 " + atomicBoolean.get());
                atomicBoolean.set(false);
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
        System.out.println("최종 값: " + atomicBoolean.get());
    }
}
