package java_thread_programming.chapter8.exam01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam01 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executor.submit(new Worker("worker" + i));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("모든 작업이 완료되었습니다.");

    }
}
