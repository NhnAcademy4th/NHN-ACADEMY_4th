package thread.git.state;
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
    @Override
    public void run() {
        int count = 0;
        while(count < maxValue){
            System.out.println(name + " : "+count++);
            try{
                sleep(1000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(name + " is stopped");
    }
}