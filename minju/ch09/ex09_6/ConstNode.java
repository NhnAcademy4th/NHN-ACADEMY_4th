package ex09_6;

public class ConstNode extends ExpNode {

    private double value;

    public ConstNode(double value) {
        this.value = value;
    }

    @Override
    public double value(double xValue) {
        return value;
    }

    @Override
    public void printStackCommands() {
        System.out.println("Push " + value);
    }
}
