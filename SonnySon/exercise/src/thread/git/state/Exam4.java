package thread.git.state;

public class Exam4 {
    public static void main(String[] args) {
        RunnableCounter counter = new RunnableCounter("counter",10);
        WaitingCounter waitingCounter = new WaitingCounter(counter);

        counter.start();
        waitingCounter.start();

        Thread.State state = waitingCounter.getThread().getState();

        while(waitingCounter.isAlive()){
            if(state != waitingCounter.getThread().getState()){
                state = waitingCounter.getThread().getState();
                System.out.println(state);
            }
        }
    }
}