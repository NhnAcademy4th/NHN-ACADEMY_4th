package com.nhnacademy.thread.threadClassExtension;

/**
 * Thread 클래스 확장 Thread 클래스 확장은 Java에서 지원해주는 Thread 클래스를 확장하여 새로운 클래스 구현을 말한다. 단일 스레드 환경에서의 여러 작업을 실행하여 문제점을 확인한다.
 * Thread 클래스를 확장해 스레드로 동작하는 클래스를 만든다. Thread 클래스 확장을 통해 여러 작업을 동시에 실행해 확인한다.
 */
public class Quiz {
    public static void main(String[] args) {
        quiz3();
        quiz4();
    }

    public static void quiz3() {
        Counter counter1 = new Counter("Counter1", 10);
        Counter counter2 = new Counter("Counter2", 10);

        // counter1의 실행이 끝나야 counter2가 끝난다. 단일 스레드이기 때문
        counter1.run();
        counter2.run();
    }

    public static void quiz4() {
        ThreadCounter counter1 = new ThreadCounter("Counter1", 10);
        ThreadCounter counter2 = new ThreadCounter("Counter2", 10);

        counter1.start();
        counter2.start();
    }

}