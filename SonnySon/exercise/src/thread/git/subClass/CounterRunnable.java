package thread.git.subClass;

public class CounterRunnable implements Runnable{
    String name;
    int count;
    Thread thread;

    public CounterRunnable(String name){
        this.name = name;
        this.count = 1;
    }
    public void start(){
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run(){
        while(!Thread.interrupted()){
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                throw new RuntimeException();
            }
            System.out.println(name + " : " + count++);
        }
    }
}
