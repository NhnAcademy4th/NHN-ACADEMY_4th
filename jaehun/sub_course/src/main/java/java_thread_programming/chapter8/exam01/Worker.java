package java_thread_programming.chapter8.exam01;

public class Worker implements Runnable {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(getName() + " started ");
        try {
            Thread.sleep(1999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " finished");
    }
}
