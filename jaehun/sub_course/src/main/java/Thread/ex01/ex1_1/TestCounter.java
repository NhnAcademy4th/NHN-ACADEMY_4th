package Thread.ex01.ex1_1;

import Thread.ex01.common.Counter;

public class TestCounter {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.run();
    }
}
