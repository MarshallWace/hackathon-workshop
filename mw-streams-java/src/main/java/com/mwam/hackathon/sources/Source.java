package com.mwam.hackathon.sources;

import com.mwam.hackathon.operators.Operator;

import java.util.List;

public abstract class Source<T> extends Operator<Void, T> {
    protected Source() {
        super();
    }

    protected Source(List<Operator<T, ?>> children) {
        super(children);
    }

    /**
     * Begin emitting values.
     */
    public abstract void start();

    /**
     * Force the operator and all children to emit any unfinished values
     * (e.g. a window waiting to close).
     */
    public void flush() {
        for (final var child : this.children) {
            child.flush();
        }
    }

    @Override
    public void consume(Void input) {
        throw new UnsupportedOperationException("Source cannot consume values");
    }
}
