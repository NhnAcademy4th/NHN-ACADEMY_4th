package thread.git.process_vs_thread;

public class ThreadCounter extends Thread{
    String name;
    int limit;
    public ThreadCounter(String name,int limit){
        this.name = name;
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 0; i < limit; i++) {
            System.out.println(name + " : " + (i + 1));
            try{
                sleep(1000);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        ThreadCounter threadCounter = new ThreadCounter("ThreadCounter", 10);
        threadCounter.run();
    }
}
