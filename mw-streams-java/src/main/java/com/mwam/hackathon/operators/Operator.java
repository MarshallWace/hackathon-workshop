package com.mwam.hackathon.operators;

import java.util.ArrayList;
import java.util.List;

/**
 * A node in a dataflow pipeline.
 *
 * @param <I>
 * @param <O>
 */
public abstract class Operator<I, O> {
    protected final List<Operator<O, ?>> children;

    protected Operator() {
        this.children = new ArrayList<>();
    }

    protected Operator(List<Operator<O, ?>> children) {
        this.children = children;
    }

    /**
     * Consumes some input and passes it to any children.
     *
     * @param input message to process
     */
    public abstract void consume(I input);

    /**
     * Register a child (downstream node) to the operator.
     *
     * @param child operator to pipe outputs to
     * @param <T>   output type of the child operator
     */
    public <T> void addChild(Operator<O, T> child) {
        this.children.add(child);
    }

    public void emit(O event) {
        for (var child : this.children) {
            child.consume(event);
        }
    }

    public void flush() {
        for (final var child : this.children) {
            child.flush();
        }
    }
}
