package thread.git.subClass;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    final Pipe pipe;
    int endData;

    public Receiver(Pipe pipe, int endData) {
        this.pipe = pipe;
        this.endData = endData;
    }

    public void run() {
        while (!Thread.interrupted()) {
            int receivedData = pipe.receive();
            System.out.println("[ "+ LocalDateTime.now() +"] Data :"+receivedData);
            if (receivedData == endData) {
                // 수신된 데이터가 endData이면 종료
                break;
            } else {
                // 수신된 데이터가 endData가 아닌 경우, 임의의 시간 대기
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100, 300));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
