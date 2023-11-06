package java_thread_programming.chapter6.exam05;

public class Data {

    private boolean transfer;
    private String packet;

    public synchronized void requestSending(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted");
        }

        notifyAll();
        transfer = false;
        this.packet = packet;
    }

    public synchronized String requestReceiving() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted");
        }

        notifyAll();
        transfer = true;
        return packet;
    }
}
