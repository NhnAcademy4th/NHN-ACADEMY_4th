package com.nhnacademy.ex6;

public class Exam05 {
    public static void main(String[] args) throws InterruptedException {

        Data data = new Data();

        Sender sender = new Sender("sender1", data, new String[] {"Hello world!", "new world", "nowhere"});
        Receiver receiver = new Receiver("receiver1", data);

        sender.start();
        receiver.start();
    }
}
