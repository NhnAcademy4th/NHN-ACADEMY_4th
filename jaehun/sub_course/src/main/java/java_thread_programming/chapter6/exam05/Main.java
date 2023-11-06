package java_thread_programming.chapter6.exam05;

import java.lang.Thread.State;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();

        while (true) {
            if (sender.getState() == State.TERMINATED) {
                receiver.interrupt();
                break;
            }
        }
    }
}
