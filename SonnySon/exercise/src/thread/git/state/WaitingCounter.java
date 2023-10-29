package thread.git.state;

public class WaitingCounter implements Runnable{
    RunnableCounter counter;
    Thread thread;
    public WaitingCounter(RunnableCounter counter) {
        this.counter = counter;
        this.thread = new Thread(this);
    }
    @Override
    public void run() {
        counter.join();
    }
    public void start() {
        thread.start();
    }
    public Thread getThread() {
        return thread;
    }

    public boolean isAlive() {
        return thread.isAlive();
    }
}
