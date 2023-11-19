package thread.git.state;

import java.time.LocalTime;
import java.util.regex.Pattern;

public class Ticker extends Thread{
    int termByMS;
    boolean tictok = true;
    public Ticker(int termByMilliSecond){
        this.termByMS = termByMilliSecond;
    }
    public Ticker(String termByMilliSecond){
        StringBuilder sec = new StringBuilder(termByMilliSecond);

        if(Pattern.matches("\\d+",termByMilliSecond)){
            new Ticker(Integer.parseInt(sec.toString()) * 1000);
        }
        else if(!Pattern.matches("\\d+[nN]",termByMilliSecond)){
            throw new IllegalArgumentException("input must be Interger or \"\\d+[nN]\"");
        }else{
            sec = new StringBuilder(termByMilliSecond).deleteCharAt(termByMilliSecond.length()-1);
            new Ticker(Integer.parseInt(sec.toString()) * 1000);
        }
    }
    @Override
    public void run(){
        long now = System.currentTimeMillis();
        while(!Thread.interrupted()){
            System.out.print(tictok ? "\"Tick\"  " : "\"Tok\"  ");
            System.out.println(System.currentTimeMillis() - now);
            now = System.currentTimeMillis();
            tictok = !tictok;
            try{
                sleep(termByMS);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Ticker ticker = new Ticker(100);
        ticker.start();
        Thread.sleep(1000);
    }
}