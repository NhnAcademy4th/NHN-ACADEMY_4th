package thread.git.state;

import static java.lang.Thread.sleep;

public class Exam1 {
    public static void main(String[] args) {
        Thread runner = new Thread(new RunnableCounter("counter",10),"runner");
        System.out.println(runner.getState());
        runner.start();
        System.out.println(runner.getState());
        try{
            sleep(5500);
        }catch(InterruptedException e){
            throw new RuntimeException();
        }
        System.out.println(runner.getState());
    }
}
