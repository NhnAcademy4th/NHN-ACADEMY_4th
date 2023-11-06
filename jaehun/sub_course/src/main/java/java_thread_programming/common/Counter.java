package java_thread_programming.common;

public class Counter {
    private String name;
    private int maxCount;

    public Counter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
    }

    public void run() {
        for (int i = 1; i <= maxCount; i++) {
            System.out.println(name + " : " + i);
        }
    }

}
