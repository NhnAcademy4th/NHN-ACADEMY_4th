package thread.git.synchronization;

public class Receiver implements Runnable{
    Data data;
    public Receiver(Data data) {
        this.data = data;
    }
    @Override
    public void run() {
        while(!Thread.interrupted()){
            int packet = data.send();
            System.out.println("receiver received "+packet);
            if (packet == 5) break;
        }
    }
}
