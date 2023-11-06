package Thread.ex01.common;

public class CounterThread extends Thread {
    String name;
    int count;

    public CounterThread (String name){
        this.name = name;
    }

    @Override
    public void run(){
        while(!Thread.interrupted()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " : " + ++count);
        }
    }
}
