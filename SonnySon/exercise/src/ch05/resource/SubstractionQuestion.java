package ch05.resource;

public class SubstractionQuestion implements IntQuestion{
    private int a, b;  // The numbers in the problem.

    public SubstractionQuestion() { // constructor
        do{
            a = (int)(Math.random() * 50 + 1);
            b = (int)(Math.random() * 50);
        }while(a-b<0);
    }

    public String getQuestion() {
        return "What is " + a + " - " + b + " ? ";
    }

    public int getCorrectAnswer() {
        return a - b;
    }

}
