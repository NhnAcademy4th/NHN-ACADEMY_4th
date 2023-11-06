package java_thread_programming.chapter5.quiz01;

import java_thread_programming.common.RunnableCounter;

// 상태 제어로 클래스를 중지하면 생기는 문제
// - 강제종료이기 때문에 thread 리소스를 정리하지 못하고 종료될 수 있다. 그러면 프로그램이 예기지 못한 동작을 할 수 있음

public class CounterStopTest {
    public static void main(String[] args) throws InterruptedException {
        RunnableCounter runnableCounter = new RunnableCounter("counter", 10);
        Thread thread = new Thread(runnableCounter);
        thread.start();

        Thread.sleep(5000);
        runnableCounter.stop();
    }
}
