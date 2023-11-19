package thread.git.synchronization;

public class Sender implements Runnable{
    Data data;
    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        int i = 0;
        while(!Thread.interrupted()){
            System.out.println("sender send " + i);
            data.receive(++i);
        }
    }
}
