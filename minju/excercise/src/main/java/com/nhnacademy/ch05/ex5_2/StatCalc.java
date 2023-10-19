package com.nhnacademy.ch05.ex5_2;

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

        sb.append("count : " + this.getCount() + "\n");
        sb.append("sum : " + this.getSum() + "\n");

        try {
            sb.append("max : " + this.getMax() + "\n");
        } catch (IllegalArgumentException e) {
            sb.append("max : " + e.getMessage() + "\n");
        }

        try {
            sb.append("min : " + this.getMin() + "\n");
        } catch (IllegalArgumentException e) {
            sb.append("min : " + e.getMessage() + "\n");
        }

        try {
            sb.append("average : " + this.getMean() + "\n");
        } catch (IllegalArgumentException e) {
            sb.append("average : " + e.getMessage() + "\n");
        }
        try {
            sb.append("Standard Deviation : " + this.getStandardDeviation());
        } catch (IllegalArgumentException e) {
            sb.append("Standard Deviation : " + e.getMessage());
        }
        return sb.toString();
    }

}