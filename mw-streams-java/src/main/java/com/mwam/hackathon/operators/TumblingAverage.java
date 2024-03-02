package com.mwam.hackathon.operators;

/**
 * Computes a tumbling average over some number of events.
 *
 * @param <I> Event type. Numeric, so
 */
public class TumblingAverage<I extends Number> extends Operator<I, Double> {
    private final long windowSize;
    private long count = 0;
    private double sum = 0.0;

    public TumblingAverage(long windowSize) {
        this.windowSize = windowSize;
    }

    @Override
    public void consume(I input) {
        sum += input.doubleValue();
        count += 1;

        if (count == windowSize) {
            double average = sum / count;
            count = 0;

            emit(average);
        }
    }

    @Override
    public void flush() {
        emit(this.sum / count);
        super.flush();
    }
}