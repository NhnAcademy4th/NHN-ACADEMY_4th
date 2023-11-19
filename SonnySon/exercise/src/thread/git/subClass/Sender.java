package thread.git.subClass;
public class Sender implements Runnable {
    final Pipe pipe;

    public Sender(Pipe pipe) {
        this.pipe = pipe;
    }

    public void run() {
        int count = 0;
        while (!Thread.interrupted()) {
            pipe.send(++count);
            // 전송에 성공하면 일정 시간 대기
            if(count == 10){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
