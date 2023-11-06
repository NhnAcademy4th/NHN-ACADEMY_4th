package java_thread_programming.chapter6.exam05;

public class Sender implements Runnable {

    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        int index = 1;

        while (index < 5) {
            String message = String.format(index++ + "번 데이터");
            data.requestSending(message);
            System.out.println("sender : " + message + " 보냄");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted");
            }
        }
    }
}
