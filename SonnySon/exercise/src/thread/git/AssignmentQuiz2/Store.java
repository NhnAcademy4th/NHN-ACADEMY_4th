package thread.git.AssignmentQuiz2;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Store {
    private int productCount;
    private int userCount;
    private int MAX_USER = 5;

    private Semaphore s;
    private final int MAX_PRODUCT = 10;
    public Store(Semaphore s){
        this.s = s;
        userCount = 0;
        productCount = 0;
    }
    public boolean isFull(){
        return userCount > MAX_USER;
    }
    public void enter(String name){
        System.out.println("[ "+ LocalDateTime.now() +"] Data :" + name + " 유저 입장");
        userCount++;
    }

    public void exit(String name){
        System.out.println("[ "+ LocalDateTime.now() +"] Data :" + name + " 유저 퇴장");
        userCount--;
    }
    public synchronized void buy(){
        try{
            s.acquire();
            while(productCount >= MAX_PRODUCT){
                try {
                    System.out.println("[ "+ LocalDateTime.now() + "] Data : Product already Maximum /wait userCount : "  + userCount);
                    wait();
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
            }
            productCount++;
            System.out.println("[ "+ LocalDateTime.now() + "] Data : Producer sell completed. Left product :" + productCount);
            notifyAll();
            s.release();
        }catch (InterruptedException e){}
    }
    public synchronized void sell(){
        try{
            s.acquire();

            while(productCount < 1){
                try {
                    System.out.println("[ "+ LocalDateTime.now() + "] Data : Product not enough to buy /wait userCount : "  + userCount);
                    wait();
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
            }
            productCount--;
            System.out.println("[ "+ LocalDateTime.now() + "] Data : Consumer buy completed. Left product :"  + productCount);
            notifyAll();
            s.release();
        }catch (InterruptedException e){}
    }
    public static void main(String[] args) {
        Semaphore s = new Semaphore(5,true);

        Store store = new Store(s);

        int consumerCount = 0;
        int producerCount = 0;

        ExecutorService executor = Executors.newFixedThreadPool(5);

        while(true) {
            Thread visitor;
            if(!store.isFull()){
                // 입장 랜덤
                if(ThreadLocalRandom.current().nextBoolean())
                    visitor = new Thread(new Consumer("Consumer" + (consumerCount++),store));
                else
                    visitor = new Thread(new Producer("Producer" + (producerCount++),store));
                executor.submit(visitor);
            }
        }
    }
}