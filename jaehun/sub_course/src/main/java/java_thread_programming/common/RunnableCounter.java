package java_thread_programming.common;

import java.util.concurrent.atomic.AtomicBoolean;

public class RunnableCounter implements Runnable {

    private Thread thread;
    private int maxCount;

    private final AtomicBoolean running = new AtomicBoolean(false);

    public RunnableCounter(String name, int maxCount) {
        thread = new Thread(this, name);
        this.maxCount = maxCount;
    }

    public RunnableCounter(ThreadGroup group, String name, int maxCount) {
        thread = new Thread(group, this, name);
        this.maxCount = maxCount;
    }

    public void stop() {
        System.out.println("강제 종료");
        thread.interrupt();
        running.set(false);
    }

    public void setDaemon(boolean on) {
        thread.setDaemon(on);
    }

    public Thread getThread() {
        return thread;
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        running.set(true);
        int count = 1;
        while (count <= maxCount && running.get()) {
            try {
                System.out.println(thread.getName() + " : " + count++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

