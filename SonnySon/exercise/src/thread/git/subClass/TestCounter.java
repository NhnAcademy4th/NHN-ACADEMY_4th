package thread.git.subClass;

public class TestCounter {
    public static void main(String[] args){
        CounterRunnable counterRunnable = new CounterRunnable("CounterRunnable");
        CounterRunnable counterRunnable1 = new CounterRunnable("CounterRunnable1");
        counterRunnable.start();
        counterRunnable1.start();
    }
}
