package thread.git.process_vs_thread;

import static java.lang.Thread.sleep;

public class Counter {
    String name;
    int limit;
    public Counter(String name, int limit){
        this.name = name;
        this.limit = limit;
    }
    void run(){
        for (int i = 0; i < limit; i++) {
            try{
                sleep(1000);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.println(name + " : " + (i + 1));
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter("counter",10);
        counter.run();
    }
}
