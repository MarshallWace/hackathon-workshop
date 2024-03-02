package com.mwam.hackathon.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

public class FlatMap<I, O> extends Operator<I, O> {

    private final Function<I, Collection<O>> fn;

    public FlatMap(Function<I, Collection<O>> fn) {
        super(new ArrayList<>());
        this.fn = fn;
    }

    /**
     * Consumes an input and maps it to a Collection.
     * Emits each value of the collection as a separate event.
     *
     * @param input to be flattened.
     */
    @Override
    public void consume(I input) {
        final Collection<O> outputCollection = fn.apply(input);
        outputCollection.forEach(this::emit);
    }
}
