package ch05.resource;

public class NullTest{
    private int count = 0;
    public void increment() {
        count++;
    }
    public int getCount() {
        NullTest c;

        return count;

    }

    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = new Integer(3);

        System.out.println(a.equals(b));
    }
}