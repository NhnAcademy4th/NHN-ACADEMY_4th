package java_thread_programming.chapter3.exam02;

public class SelfRunnableCounter implements Runnable {

    private int count;
    private int maxCount;
    Thread thread;

    public SelfRunnableCounter(String name, int maxCount) {
        this.maxCount = maxCount;
        count = 0;
        thread = new Thread(this, name);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        while (count < maxCount) {
            try {
                ++count;
                System.out.println(thread.getName() + " : " + count);
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
