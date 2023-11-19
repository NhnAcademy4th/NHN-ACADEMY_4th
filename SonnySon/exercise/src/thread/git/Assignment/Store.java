package thread.git.Assignment;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Store {
    private int productCount;
    private int userCount;

    private Product productName;

    HashMap<Product,Integer> productList = new HashMap<>();
    private final int MAX_USER = 5;
    private final int MAX_PRODUCT = 10;
    public Store(Product productName){
        this.userCount = 0;
        this.productCount = 0;
        this.productName = productName;
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
        while(productCount >= MAX_PRODUCT){
            try {
                System.out.println("[ "+ LocalDateTime.now() + "] Data : Product already Maximum /wait userCount : "  + userCount);
                wait();
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        }
        productCount++;
        System.out.println("[ "+ LocalDateTime.now() + "] Data : Producer sell completed. Left "+ productName +" product :" + productCount);
        notifyAll();
    }
    public synchronized void sell(){
        while(productCount < 1){
            try {
                System.out.println("[ "+ LocalDateTime.now() + "] Data : Product not enough to buy /wait userCount : "  + userCount);
                wait();
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        }

        productCount--;

        System.out.println("[ "+ LocalDateTime.now() + "] Data : Consumer buy completed. Left "+ productName +" product :"  + productCount);
        notifyAll();
    }
    public static void main(String[] args) {
        int PRODUCT_VARIABLE = 5;

        Map<ExecutorService,Store> executerList = new HashMap<>();

        Iterator products = Arrays.stream(Product.values()).iterator();

        for (int i = 0; i < PRODUCT_VARIABLE; i++) {

            Store store = new Store((Product) products.next());

            Thread producer = new Thread(new Producer("Producer", store));
            ExecutorService executor = Executors.newFixedThreadPool(5);
            executor.submit(producer);

            executerList.put(executor,store);
        }

        Thread consumer;

        while(true) {
            for (ExecutorService executor :
                    executerList.keySet()) {

                if(executerList.get(executor).userCount < 5){
                    consumer = new Thread(new Consumer("Consumer",executerList.get(executor)));
                    executor.submit(consumer);
                }
            }
        }
    }
}