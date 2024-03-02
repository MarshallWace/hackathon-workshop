package com.mwam.hackathon.operators;

import java.util.function.Function;

/**
 * Filters out elements of a stream that don't satisfy a predicate.
 */
public class Filter<T> extends Operator<T, T> {
    /**
     * Predicate to test events with.
     */
    private final Function<T, Boolean> testFn;

    public Filter(Function<T, Boolean> testFn) {
        super();
        this.testFn = testFn;
    }

    /**
     * Consumes some input and passes it to any children.
     *
     * @param input message to process
     */
    @Override
    public void consume(T input) {
        if (testFn.apply(input)) {
            emit(input);
        }
    }
}
