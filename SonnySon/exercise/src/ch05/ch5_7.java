package ch05;

import ch05.resource.AdditionQuestion;
import ch05.resource.IntQuestion;
import ch05.resource.SubstractionQuestion;

public class ch5_7 {

    public static void main(String[] args) {

        IntQuestion[] iq = new IntQuestion[3];
        iq[0] = new IntQuestion() {
            public String getQuestion() {
                return "What is the answer to the ultimate question " +
                        " of life, the universe, and everything?";
            }

            public int getCorrectAnswer() {
                return 42;
            }
        };
        iq[1] = new AdditionQuestion();
        iq[2] = new SubstractionQuestion();

        for (int i = 0; i < 3; i++) {
            System.out.println(iq[i].getQuestion()+","+iq[i].getCorrectAnswer());
        }
    }
}
