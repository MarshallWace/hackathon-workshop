package com.mwam.hackathon.operators;

import java.util.HashSet;
import java.util.Set;

/**
 * Select distinct elements from a stream.
 *
 * @param <I> Event type.
 */
public class Distinct<I> extends Operator<I, I> {
    private final Set<I> seen = new HashSet<>();

    public Distinct() {
        super();
    }

    @Override
    public void consume(I input) {
        // add returns false if the item was already in the set
        if (seen.add(input)) {
            emit(input);
        }
    }
}