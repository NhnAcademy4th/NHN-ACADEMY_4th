package thread.git.subClass;

public class CounterThread extends Thread{
    String name;
    int count;

    public CounterThread(String name){
        this.name = name;
        this.count = 1;
    }
    public void run(){
        while(!Thread.interrupted()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " : " + count++);
        }
    }
}
