package thread.git.synchronization;

public class SharedCount {
    int count;

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public synchronized void increment(){
        synchronized (this){
            setCount(getCount() + 1);
        }
    }
    public static synchronized void sun(){


    }

}
