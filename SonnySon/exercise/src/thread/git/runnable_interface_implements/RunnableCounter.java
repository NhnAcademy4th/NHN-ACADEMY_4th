package thread.git.runnable_interface_implements;

import static java.lang.Thread.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableCounter implements Runnable{
    String name;
    int maxCount;
    Thread thread;

    public RunnableCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.thread = new Thread(this,name);
    }
    public void start(){
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < maxCount; i++) {
            System.out.println(name + " : " + (i+1));
            System.out.println(thread.getState());
            try{
                sleep(1000);
            }catch(InterruptedException ignore){
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.execute(new RunnableCounter("counter1",5));
        pool.execute(new RunnableCounter("counter2",5));
        pool.shutdown();
        System.out.println("shutdown called");
        while(!pool.awaitTermination(2, TimeUnit.SECONDS)){
            System.out.println("not yet finished");
        }
        System.out.println("finished");
    }
}
