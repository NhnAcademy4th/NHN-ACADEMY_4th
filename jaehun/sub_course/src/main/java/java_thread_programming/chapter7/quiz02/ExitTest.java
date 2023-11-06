package java_thread_programming.chapter7.quiz02;

import java_thread_programming.common.RunnableCounter;

public class ExitTest {
    public static void main(String[] args) throws InterruptedException {
        RunnableCounter counter1 = new RunnableCounter("counter1", 3);
        RunnableCounter counter2 = new RunnableCounter("counter2", 3);
        counter1.start();
        counter2.start();
        counter1.getThread().join();
        System.out.println(counter1.getThread().getName() + " " + "stopped");
        counter2.getThread().join();
        System.out.println(counter2.getThread().getName() + " " + "stopped");
        System.out.println("All threads stopped");

    }
}
