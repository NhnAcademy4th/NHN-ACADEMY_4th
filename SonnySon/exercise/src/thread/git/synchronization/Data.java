package thread.git.synchronization;

import static java.lang.Thread.sleep;

public class Data {
    boolean transfer = true;
    int packet;
    public Data(){
    }

    public synchronized int send() {

        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrrupted");
            }
        }

        try{
            sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Thread Interrrupted");
        }

        this.transfer = false;
        notify();
        return packet;
    }

    public synchronized void receive(int packet){
        while(transfer){
            try{
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }

        try{
            sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Thread Interrrupted");
        }

        this.packet = packet;
        transfer = true;
        notify();
    }
}