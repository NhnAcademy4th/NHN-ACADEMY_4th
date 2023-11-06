package Thread.ex01.ex1_2;

import Thread.ex01.common.Counter;

public class TestCounter {
    public static void main(String[] args) {
        Counter counter1 = new Counter("Counter1");
        Counter counter2 = new Counter("Counter2");

        counter1.run();
        counter2.run();
    }
}

// 결과로 Counter1만 나오는 이유 : 코드는 메서드 안에서 위에서부터 차레대로 실행되기 때문에
// counter1.run()의 실행이 끝나야 counter2.run()으로 넘어갈 수 있다.
// 그런데 여기서는 counter1.run()의 interrupt 되기 전에 끝나지 않으므로 counter1만 출력된다.
