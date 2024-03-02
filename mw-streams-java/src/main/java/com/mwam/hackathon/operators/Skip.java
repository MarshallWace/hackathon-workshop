package com.mwam.hackathon.operators;

import java.util.ArrayList;

/**
 * Skips the first n events.
 *
 * @param <I> event type
 */
public class Skip<I> extends Operator<I, I> {
    private final int skip;
    private int skipped = 0;

    public Skip(int skip) {
        super(new ArrayList<>());
        this.skip = skip;
    }

    @Override
    public void consume(I input) {
        if (skipped >= skip) {
            emit(input);
        } else {
            skipped++;
        }
    }
}