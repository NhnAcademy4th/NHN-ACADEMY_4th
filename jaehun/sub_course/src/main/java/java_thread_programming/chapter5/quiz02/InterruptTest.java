package java_thread_programming.chapter5.quiz02;

import java_thread_programming.common.RunnableCounter;


// 플래그를 이용해서 멈추면 문제가 생긴다는 것을 알았다.
// 이를 어떻게 해결할까?
// interrupt를 사용하면 해결할 수 있다. inturrpt만으로는 인터럽트되었다는 상태를 알려주는 것 뿐이고 어떻게 해결할지는 프로그래머에게 달려있다.
// 하지만 무작정 인터럽트 처리가 되는 것이 아니라 처리가 될 수 있는 상태가 될때까지 기다리기 때문에 안전성이 높다고 볼 수 있다.
public class InterruptTest {
    public static void main(String[] args) {
        RunnableCounter runnableCounter = new RunnableCounter("counter", 10);
        Thread thread = new Thread(runnableCounter);
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread.interrupt();
    }

}
