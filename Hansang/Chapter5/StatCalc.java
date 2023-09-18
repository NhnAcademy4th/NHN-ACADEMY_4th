package com.nhnacademy.Chapter5;

import java.util.ArrayList;
import java.util.Collections;

public class StatCalc {
    private int count;
    private double sum;
    private double squareSum;
    private ArrayList<Double> dataset = new ArrayList<>();

    public void enter(double num) {
        dataset.add(num);
        this.count++;
        boolean isComputable = ((sum == Double.MAX_VALUE && num + sum == Double.MAX_VALUE) ||
                (sum == Double.MIN_VALUE && num + sum == Double.MIN_VALUE));
        if (isComputable) {
            throw new ArithmeticException("Calculate Error!");
        }
        this.sum += num;
        this.squareSum += num * num;
    }

    public int getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getMax() {
        double maxNumber;

        sortDataset();
        maxNumber = dataset.get(dataset.size() - 1);

        return maxNumber;
    }

    public double getMin() {
        double minNumber;

        sortDataset();
        minNumber = dataset.get(0);

        return minNumber;
    }

    private void sortDataset() {
        Collections.sort(dataset);
    }

    public double getMean() {
        double Mean = sum / count;
        return (Math.round(Mean * 1000) / 1000.0);
    }

    public double getStandardDeviation() {
        double mean = getMean();
        double standardDeviation = Math.sqrt(squareSum / count - mean * mean);
        return (Math.round(standardDeviation * 1000) / 1000.0);
    }

    @Override
    public String toString() {
        return "StatCalc{" +
                "count=" + getCount() +
                ", sum=" + getSum() +
                ", mean=" + getMean() +
                ", max=" + getMax() +
                ", min=" + getMin() +
                ", standardDeviation=" + getStandardDeviation() +
                '}';
    }
}
