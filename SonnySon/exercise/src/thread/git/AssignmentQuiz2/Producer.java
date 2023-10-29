package thread.git.AssignmentQuiz2;

import static java.lang.Thread.sleep;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable{
    String name;
    Store store;
    Thread thread;
    public Producer(String name, Store store){
        this.store = store;
        this.name = name;
        this.thread = new Thread(this);
    }
    @Override
    public void run() {
        store.enter(name);
        while(!Thread.interrupted()){
            try {
                sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            store.buy();
        }
        store.exit(name);
    }
    public void start(){
        thread.start();
    }

}