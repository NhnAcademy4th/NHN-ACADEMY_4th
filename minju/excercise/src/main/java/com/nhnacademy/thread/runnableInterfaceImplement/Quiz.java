package com.nhnacademy.thread.runnableInterfaceImplement;

/**
 * Runnable interface를 이용한 구현 - Runnable interface를 구현해 thread로 동작하는 클래스를 만든다. - Runnable interface 구현을 통해 여러 작업을 동시에
 * 실행해 확인한다.
 */
public class Quiz {

    public static void main(String[] args) {
        quiz1();
    }

    public static void quiz1() {
        RunnableCounter counter = new RunnableCounter("counter", 5);
        Thread thread = new Thread(counter);
    }

}
