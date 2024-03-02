package com.mwam.hackathon.operators;

/**
 * Does nothing.
 *
 * @param <I> event type
 */
public class Identity<I> extends Operator<I, I> {

    /**
     * Emits any input events without doing anything.
     *
     * @param input message to process
     */
    @Override
    public void consume(I input) {
        emit(input);
    }
}