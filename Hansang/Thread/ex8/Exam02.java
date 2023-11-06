package com.nhnacademy.ex8;

import com.nhnacademy.Inputshell;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam02 {
    public static void main(String[] args) {
        Inputshell inputshell = new Inputshell();
        List<String> urls = new ArrayList<>();
        String inputString;

        while (true) {
            inputString = inputshell.inputFromShell("Please input Url : ");
            if (inputString == "\n") {
                break;
            }
            urls.add(inputString);
        }

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String url : urls) {
            Runnable worker = new DownloadWorker(url);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("Shut down.");
    }
}