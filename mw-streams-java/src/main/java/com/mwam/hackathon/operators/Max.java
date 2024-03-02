package com.mwam.hackathon.operators;

import java.util.Comparator;

/**
 * Apply a function to each element of a stream.
 *
 * @param <T> event type
 */
public class Max<T> extends Operator<T, T> {
    private final Comparator<T> comparator;
    private T currentMax = null;

    public Max(Comparator<T> comparator) {
        super();
        this.comparator = comparator;
    }

    /**
     * Emits the largest event seen so far.
     */
    @Override
    public void consume(T input) {
        if (currentMax != null) {
            currentMax = comparator.compare(currentMax, input) >= 0 ? currentMax : input;
        } else {
            currentMax = input;
        }

        emit(currentMax);
    }
}
