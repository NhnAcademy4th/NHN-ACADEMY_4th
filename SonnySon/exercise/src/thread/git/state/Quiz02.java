package thread.git.state;

public class Quiz02 {
    public static void main(String[] args) {
        RunnableCounter counter1 = new RunnableCounter("counter1",5);
        RunnableCounter counter2 = new RunnableCounter("counter2",10);

        counter1.start();
        counter2.start();

        while(counter1.getThread().isAlive() || counter2.getThread().isAlive()){}

//        counter1.join();
//        counter2.join();

        System.out.println("All threads stopped");
    }
}
