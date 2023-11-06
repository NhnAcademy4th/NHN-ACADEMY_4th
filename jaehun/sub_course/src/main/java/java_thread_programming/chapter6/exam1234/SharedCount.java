package java_thread_programming.chapter6.exam1234;

public class SharedCount {
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        synchronized (this) {
            setCount(getCount() + 1);
        }
    }
}
