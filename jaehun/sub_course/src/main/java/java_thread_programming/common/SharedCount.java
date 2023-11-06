package java_thread_programming.common;

public class SharedCount {
    int count = 0;
    Thread thread;

    public int getCount() {
        return count;
    }

    public synchronized void increment() {
        count++;
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " : " + count);
        } catch (InterruptedException ignore) {

        }
    }
}
