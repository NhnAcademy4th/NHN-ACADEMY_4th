package java_thread_programming.mart;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Mart mart = new Mart(5);
        Producer producer = new Producer(mart);
        producer.start();
        int i = 1;
        while (true) {
            Consumer consumer = new Consumer(i + " 소비자", mart);
            consumer.start();
            i++;
            Thread.sleep(2000);
        }
    }
}
