package ex09_6_7;

public abstract class ExpNode {
    abstract double value(double xValue);

    abstract void printStackCommands();

    abstract ExpNode derivative();

    abstract void printInfix();
}
