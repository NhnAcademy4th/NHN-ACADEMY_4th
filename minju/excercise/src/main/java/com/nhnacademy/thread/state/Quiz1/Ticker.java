package com.nhnacademy.thread.state.Quiz1;

import java.util.Objects;

public class Ticker extends Thread {

    long timeCount;
    boolean isNano = false;

    public Ticker(String seconds) {
        Objects.requireNonNull(seconds, "Seconds");
        String regex = "\\d+[nN]?";
        if (!seconds.matches(regex)) {
            throw new IllegalArgumentException();
        }
        seconds = seconds.toLowerCase();
        if (seconds.endsWith("n")) {
            isNano = true;
            seconds = seconds.replace("n", "");
        }
        timeCount = Long.parseLong(seconds);
    }

    @Override
    public void run() {
        while (true) {
            long startTime = System.currentTimeMillis();
            try {
                if (isNano) {
                    sleep(0, (int) timeCount);
                } else {
                    sleep(timeCount);
                }
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime);
        }
    }


}
