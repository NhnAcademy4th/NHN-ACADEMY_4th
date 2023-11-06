package java_thread_programming.common;

public class SharedCounter implements Runnable {

    private Thread thread;
    private SharedCount sharedCount;
    private int count;
    private int maxCount;
    long interval = 1000;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        thread = new Thread(this, name);
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
    }

    public void increment() {
        count++;
        sharedCount.increment();
    }

    public int getCount() {
        return count;
    }

    public Thread getThread() {
        return thread;
    }

    public void stop() {
        thread.interrupt();
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (getCount() < maxCount) {
                increment();
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
