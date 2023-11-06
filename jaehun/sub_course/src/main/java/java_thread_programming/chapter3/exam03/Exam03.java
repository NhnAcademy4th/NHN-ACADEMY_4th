package java_thread_programming.chapter3.exam03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java_thread_programming.common.RunnableCounter;

public class Exam03 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(new RunnableCounter("counter1", 5));
        pool.execute(new RunnableCounter("counter2", 5));

        pool.shutdown();
        while (!pool.awaitTermination(2, TimeUnit.SECONDS)) {
        }
        System.out.println("All service finished");
    }
}
