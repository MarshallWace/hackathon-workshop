package com.mwam.hackathon.operators;

public class Average<I extends Number> extends Operator<I, Double> {
    private double sum = 0.0;
    private long count = 0;

    @Override
    public void consume(I input) {
        sum += input.doubleValue();
        count += 1;
        double average = sum / count;

        // the new average to any parent operators
        emit(average);
    }
}
