package Thread.ex01.common;

public class Counter {
    private String name;
    private int count;

    public Counter(){

    }

    public Counter (String name){
        this.name = name;
    }

    public void run() {
        while (!Thread.interrupted()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name +" : "+ ++count);
        }
    }
}
