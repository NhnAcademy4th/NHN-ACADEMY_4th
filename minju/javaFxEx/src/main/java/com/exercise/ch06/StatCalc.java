package com.exercise.ch06;

public class StatCalc {

    private int count;
    private double sum;
    private double squareSum;
    private double max = Double.MIN_VALUE;
    private double min = Double.MAX_VALUE;

    public void enter(double num) {

        count++;
        if (count >= Integer.MAX_VALUE) {
            throw new ArithmeticException("더이상 추가할 수 없습니다.");
        }

        sum(num);
        max(num);
        min(num);

    }

    private void sum(double num) {
        sum += num;
        squareSum += num * num;
    }

    private void max(double num) {
        if (max < num) {
            max = num;
        }
    }

    private void min(double num) {
        if (min > num) {
            min = num;
        }
    }

    public double getMax() {
        if (count == 0) {
            throw new IllegalArgumentException("계산 가능한 항목이 없습니다.");
        }

        return max;
    }

    public double getMin() {
        if (count == 0) {
            throw new IllegalArgumentException("계산 가능한 항목이 없습니다.");
        }
        return min;
    }

    public int getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getMean() {
        if (count < 1) {
            throw new IllegalArgumentException("계산 가능한 항목이 없습니다.");
        }
        return sum / count;
    }

    public double getStandardDeviation() {
        double mean = getMean();
        return Math.sqrt(squareSum / count - mean * mean);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("count : ");
        sb.append(this.getCount());
        sb.append("\n");

        sb.append("sum : ");
        sb.append(this.getSum());
        sb.append("\n");

        sb.append("max : ");
        try {
            sb.append(this.getMax());
            sb.append("\n");
        } catch (IllegalArgumentException e) {
            sb.append(e.getMessage());
            sb.append("\n");
        }

        sb.append("min : ");
        try {
            sb.append(this.getMin());
            sb.append("\n");
        } catch (IllegalArgumentException e) {
            sb.append(e.getMessage());
            sb.append("\n");
        }

        sb.append("average : ");
        try {
            sb.append(this.getMean());
            sb.append("\n");
        } catch (IllegalArgumentException e) {
            sb.append(e.getMessage());
            sb.append("\n");
        }

        sb.append("Standard Deviation : ");
        try {
            sb.append(this.getStandardDeviation());
        } catch (IllegalArgumentException e) {
            sb.append(e.getMessage());
        }
        return sb.toString();
    }

}
