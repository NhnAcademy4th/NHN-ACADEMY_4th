package java_thread_programming.common;

public class ThreadCounter extends Thread {
    private String name;
    private int maxCount;


    public ThreadCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        int count = 1;
        while (count <= maxCount) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException("thread.sleep에서 문제가 생겼습니다.");
            }
            System.out.println(name + " : " + count++);
        }
    }
}
