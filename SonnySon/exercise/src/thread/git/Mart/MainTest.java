package thread.git.Mart;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTest {
    public static void main(String[] args) {
        Store store = new Store();

        Thread consumer = new Thread(new Consumer("consumer",store));
        Producer producer = new Producer("producer",store);

        consumer.start();
        producer.start();
    }
}
