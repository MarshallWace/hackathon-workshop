package com.mwam.hackathon.operators;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * Apply a function to each element of a stream.
 *
 * @param <I> input type
 * @param <O> output type
 */
public class Map<I, O> extends Operator<I, O> {
    private final Function<I, O> fn;

    public Map(Function<I, O> fn) {
        super(new ArrayList<>());
        this.fn = fn;
    }

    /**
     * Consumes some input and passes it to any children.
     *
     * @param input message to process
     */
    @Override
    public void consume(I input) {
        final O output = fn.apply(input);
        emit(output);
    }
}
