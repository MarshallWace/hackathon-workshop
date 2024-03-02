package com.mwam.hackathon.sources;

import java.util.ArrayList;

public class IterSource<T> extends Source<T> {
    private final Iterable<T> items;

    public IterSource(Iterable<T> items) {
        super(new ArrayList<>());
        this.items = items;
    }

    @Override
    public void start() {
        for (final var item : items) {
            emit(item);
        }

        flush();
    }
}
