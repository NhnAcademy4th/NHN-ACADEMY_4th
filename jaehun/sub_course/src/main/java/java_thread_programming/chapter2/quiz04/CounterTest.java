package java_thread_programming.chapter2.quiz04;

import java_thread_programming.common.ThreadCounter;

public class CounterTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadCounter threadCounter1 = new ThreadCounter("counter1", 10);
        ThreadCounter threadCounter2 = new ThreadCounter("counter2", 10);

        threadCounter1.start();
        threadCounter2.start();
    }
}

// 메인 스레드 내에서 두 개의 스레드가 실행된다.
// 스레드는 동시에 실행될 수 있기 때문에 결과가 동시에 나오게 되고, 순서는 운영체제 내에서 설정하기 때문에 무작위로 출력된다.
