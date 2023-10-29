package thread.git.state;

public class SharedCounter implements Runnable{
    String name;
    Thread thread;
    int maxCount;

    SharedCount sharedCount;

    public SharedCounter(String name, int maxCount,SharedCount sharedCount) {
        this.name = name;
        this.thread = new Thread(this);
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
    }
    @Override
    public synchronized void run() {
        for (int i = 0; i < maxCount; i++) {
            sharedCount.increment();
        }
    }
    public void start(){
        thread.start();
    }
    public Thread getThread(){
        return this.thread;
    }
}
