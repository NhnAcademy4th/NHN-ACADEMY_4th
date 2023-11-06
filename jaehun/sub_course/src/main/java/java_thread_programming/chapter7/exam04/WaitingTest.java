package java_thread_programming.chapter7.exam04;

import java_thread_programming.common.RunnableCounter;
import java_thread_programming.common.WaitingCounter;

public class WaitingTest {
    public static void main(String[] args) {
        RunnableCounter counter = new RunnableCounter("counter", 10);
        WaitingCounter waitingCounter = new WaitingCounter(counter);

        counter.start();
        waitingCounter.start();

        Thread.State state = waitingCounter.getThread().getState();
        System.out.println(state);

        while (waitingCounter.isAlive()) {
            if (state != waitingCounter.getThread().getState()) {
                state = waitingCounter.getThread().getState();
                System.out.println(state);
            }
        }
    }
}
