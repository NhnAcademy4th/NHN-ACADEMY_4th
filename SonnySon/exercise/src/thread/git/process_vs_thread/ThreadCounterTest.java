package thread.git.process_vs_thread;

public class ThreadCounterTest {
    public static void main(String[] args) {
        ThreadCounter threadCounter1 = new ThreadCounter("ThreadCounter1",10);
        ThreadCounter threadCounter2 = new ThreadCounter("ThreadCounter2",10);
        threadCounter1.start();
        threadCounter2.start();
    }
}
