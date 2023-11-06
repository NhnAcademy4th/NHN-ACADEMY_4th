package com.nhnacademy.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam2 {

    private static final String[] urls = {
            "https://drive.google.com/file/d/1RZAdhdjjdNlNE9jUVMtrPdytgoFYOjym/view?usp=drive_link",
            "https://drive.google.com/file/d/1RZAdhdjjdNlNE9jUVMtrPdytgoFYOjym/view?usp=drive_link",
            "https://drive.google.com/file/d/1RZAdhdjjdNlNE9jUVMtrPdytgoFYOjym/view?usp=drive_link",
            "https://drive.google.com/file/d/1RZAdhdjjdNlNE9jUVMtrPdytgoFYOjym/view?usp=drive_link",
            "https://drive.google.com/file/d/1RZAdhdjjdNlNE9jUVMtrPdytgoFYOjym/view?usp=drive_link",
            "https://drive.google.com/file/d/1RZAdhdjjdNlNE9jUVMtrPdytgoFYOjym/view?usp=drive_link"
    };

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String url : urls) {
            Runnable worker = new DownloadWorker(url);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

    }
}
