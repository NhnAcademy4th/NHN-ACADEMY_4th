package thread.git.stop;

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

    public void stop(){thread.stop();}
    @Override
    public void run() {
        for (int i = 0; i < maxCount; i++) {
            System.out.println(name + " : " + (i+1));
            try{
                sleep(1000);
            }catch(InterruptedException ignore){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableCounter runnableCounter = new RunnableCounter("counter1",5);
        runnableCounter.start();
        runnableCounter.thread.interrupt();

    }
}
