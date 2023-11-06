package java_thread_programming.chapter7.quiz01;

public class Ticker implements Runnable {


    private long interval;
    private Thread thread;

    private long currentTime;

    private boolean isNano;

    public Ticker(String interval) {
        thread = new Thread(this);
        if (interval.charAt(interval.length() - 1) == 'n') {
            isNano = true;
            this.interval = Long.parseLong(interval.substring(0, interval.length() - 1));
        } else {
            this.interval = Long.parseLong(interval);
        }
    }

    public Long getCurrentTime() {
        if (isNano) {
            return System.nanoTime();
        }
        return System.currentTimeMillis();
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            currentTime = getCurrentTime();
            try {
                Thread.sleep(interval);
                System.out.println(getCurrentTime() - currentTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
