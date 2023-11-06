package java_thread_programming.chapter2.quiz03;

import java_thread_programming.common.Counter;

public class CounterTest {
    public static void main(String[] args) {
        Counter counter1 = new Counter("counter1",10);
        Counter counter2 = new Counter("counter2",10);

        counter1.run();
        counter2.run();
    }
}

// 결과로 이름이 counter1인 카운팅 10개가 출력된 후, counter2의 카운팅 10개가 출력된다.
// 쓰레드가 아니기 때문에 순차적인 실행이 되어야 한다.
// 그렇기 때문에 counter1.run()이 끝나야 counter2.run()이 출력된다.