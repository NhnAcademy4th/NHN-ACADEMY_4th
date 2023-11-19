package thread.git.AssignmentQuiz2;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable{
    String name;
    Store store;
    Thread thread;

    public Consumer(String name, Store store){
        this.name = name;
        this.store = store;
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        store.enter(name);

        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        store.sell();

        store.exit(name);
    }

    public void start(){
        thread.start();
    }
}