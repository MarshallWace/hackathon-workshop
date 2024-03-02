package com.mwam.hackathon.operators;

import java.util.ArrayList;

/**
 * Emit the first `n` events in a stream and no others.
 *
 * @param <I>
 */
public class Take<I> extends Operator<I, I> {
    private final int limit;
    private int count;

    public Take(int limit) {
        super(new ArrayList<>());
        this.limit = limit;
        this.count = 0;
    }

    @Override
    public void consume(I input) {
        if (count < limit) {
            count++;
            emit(input);
        }
    }
}
