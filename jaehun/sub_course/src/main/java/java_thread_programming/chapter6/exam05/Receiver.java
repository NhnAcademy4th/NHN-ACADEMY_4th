package java_thread_programming.chapter6.exam05;

public class Receiver implements Runnable {

    private Data data;

    public Receiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = data.requestReceiving();
                if (message == null) {
                    continue;
                }
                System.out.println("receiver : " + message + " 받음");
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("보낼 데이터가 없어서 종료");
        }
    }
}
