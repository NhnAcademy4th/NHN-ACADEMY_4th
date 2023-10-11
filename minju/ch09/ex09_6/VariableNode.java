package ex09_6;

public class VariableNode extends ExpNode {

    @Override
    public double value(double xValue) {
        return xValue;
    }

    @Override
    public void printStackCommands() {
        System.out.println("Push X");
    }

}
