package ex5_7;

public class AdditionQuestion implements IntQuestion {

    private int a, b;

    public AdditionQuestion() {
        a = (int) (Math.random() * 50 + 1);
        b = (int) (Math.random() * 50);
    }

    @Override
    public String getQuestion() {
        return "What is " + a + " + " + b + " ?";
    }

    @Override
    public int getCorrectAnswer() {
        return a + b;
    }

}
