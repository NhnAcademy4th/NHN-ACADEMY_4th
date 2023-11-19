package thread.git.thread_pool;
import static java.lang.Thread.sleep;

public class RunnableCounter implements Runnable{

    String name;
    int maxValue;
    Thread thread;
    public RunnableCounter(String name, int maxValue) {
        this.name = name;
        this.maxValue = maxValue;
        this.thread = new Thread(this);
    }

    public RunnableCounter(ThreadGroup group, String name, int maxValue) {
        thread = new Thread(group, this, name);
        this.name = name;
        this.maxValue = maxValue;
    }
    public Thread getThread() {
        return thread;
    }
    public void start(){
        thread.start();
    }
    public void join(){
        try{
            thread.join();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    public void setDaemon(boolean input){
        thread.setDaemon(input);
    }
    public void stop(){
        thread.interrupt();
    }
    @Override
    public void run() {
        int count = 0;
        try{
            while(count < maxValue){
                System.out.println(name + " : "+count++);
                sleep(1000);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println(name + " is stopped");
    }
}