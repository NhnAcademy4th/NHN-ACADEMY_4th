package thread.git.subClass;

public class Counter {
    String name;
    int count;

    public Counter(String name){
        this.name = name;
        this.count = 1;
    }

    public void run(){
        while(!Thread.interrupted()){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                throw new RuntimeException();
            }
            System.out.println(name + " : " + count++);
        }
    }
}
