package java_thread_programming.mart;

import java.util.concurrent.Semaphore;

public class Store {

    private static int MAX_CAPACITY = 10;
    private static int MAX_CONSUMER = 5;
    private int currentCapacity;
    private Semaphore consumerSemaphore;
    private String name;

    public Store(String name) {
        this.name = name;
        this.currentCapacity = 0;
        consumerSemaphore = new Semaphore(MAX_CONSUMER);
    }

    public void enter() throws InterruptedException {
        System.out.println(name + " " + Thread.currentThread().getName() + " 입장중");
        consumerSemaphore.acquire();
        System.out.println(name + "에 " + Thread.currentThread().getName() + " 입장 완료");
        System.out.println(name + " 이용 가능 인원 : " + consumerSemaphore.availablePermits());
    }

    public void exit() {
        System.out.println(name + " " + Thread.currentThread().getName() + "퇴장");
        consumerSemaphore.release();
        System.out.println(name + " 이용 가능 인원 : " + consumerSemaphore.availablePermits());
    }

    public synchronized void buy() throws InterruptedException {
        while (currentCapacity == MAX_CAPACITY) {
            System.out.println(name + " 매장에 물건이 가득 차있습니다.");
            wait();
        }
        if (currentCapacity != 0) {
            return;
        }
        currentCapacity = MAX_CAPACITY;
        System.out.println(name + " 물건을 납품하였습니다.");
        System.out.println(name + " 물건 수 : " + currentCapacity);
        notifyAll();
    }

    public synchronized void sell() throws InterruptedException {
        while (currentCapacity == 0) {
            System.out.println(name + " 재고가 부족합니다.");
            wait();
        }
        currentCapacity--;
        System.out.println(name + " 물건 판매 완료되었습니다.");
        System.out.println(name + " 물건 수 : " + currentCapacity);
        notifyAll();
    }
}