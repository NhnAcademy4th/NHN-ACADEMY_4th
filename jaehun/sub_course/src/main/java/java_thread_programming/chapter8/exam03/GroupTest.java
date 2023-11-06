package java_thread_programming.chapter8.exam03;

import java_thread_programming.common.RunnableCounter;

public class GroupTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("group");

        RunnableCounter thread1 = new RunnableCounter(group, "worker1", 100);
        RunnableCounter thread2 = new RunnableCounter(group, "worker2", 100);

        thread1.start();
        thread2.start();

        Thread.sleep(5000);
        group.interrupt();

    }
}
