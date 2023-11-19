package thread.git.process_vs_thread;

public class CounterTest {
    public static void main(String[] args) {
        Counter counter1 = new Counter("counter1",10);
        Counter counter2 = new Counter("counter2",10);
        counter1.run();
        counter2.run();
    }
}
