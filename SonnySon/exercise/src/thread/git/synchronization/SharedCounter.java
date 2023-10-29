package thread.git.synchronization;

public class SharedCounter extends Thread{
    int count;
    int maxCount;
    SharedCount sharedCount;
    public SharedCounter(String name, int maxCount, SharedCount sharedCount){
        setName(name);
        this.count = 0;
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
    }
    @Override
    public void run() {
        while(count < maxCount){
            count++;
            sharedCount.increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SharedCount sharedCount = new SharedCount();

        SharedCounter count1 = new SharedCounter("counter1",10000,sharedCount);
        SharedCounter count2 = new SharedCounter("counter2",10000,sharedCount);

        count1.start();
        count2.start();

        count1.join();
        count2.join();

        System.out.println("shared Count : "+sharedCount.getCount());
    }
}
