package com.mwam.hackathon.sinks;

import com.mwam.hackathon.operators.Operator;

import java.util.ArrayList;

public abstract class Sink<T> extends Operator<T, Void> {
    protected Sink() {
        super(new ArrayList<>());
    }

    @Override
    public <O> void addChild(Operator<Void, O> child) {
        throw new UnsupportedOperationException("Sink operator cannot have children.");
    }
}
