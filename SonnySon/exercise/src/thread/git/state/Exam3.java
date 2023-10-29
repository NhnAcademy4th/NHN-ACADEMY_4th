package thread.git.state;

public class Exam3 {
    public static void main(String[] args) throws InterruptedException {
        SharedCount sharedCount = new SharedCount();

        SharedCounter counter1 = new SharedCounter("counter1",5,sharedCount);
        SharedCounter counter2 = new SharedCounter("counter2",5,sharedCount);

        counter1.start();
        counter2.start();

        Thread.State state1 = counter1.getThread().getState();
        Thread.State state2 = counter2.getThread().getState();

        System.out.println("Thread 1 : "+state1+", and Thread 2 : "+state2);

        while(counter1.getThread().isAlive() || counter2.getThread().isAlive()){
            // 상태변화 감지
            if((counter1.getThread().getState() != state1) ||
                    (counter2.getThread().getState() != state2)){
                state1 = counter1.getThread().getState();
                state2 = counter2.getThread().getState();
                System.out.println("Thread 1 : "+state1+", and Thread 2 : "+state2);
            }
            Thread.sleep(10);
        }
    }
}
