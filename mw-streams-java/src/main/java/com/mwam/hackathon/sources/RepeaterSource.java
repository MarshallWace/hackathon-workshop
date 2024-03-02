package com.mwam.hackathon.sources;

import java.util.ArrayList;

public class RepeaterSource<T> extends Source<T> {
    final int repetitions;
    final T value;

    public RepeaterSource(int repetitions, T value) {
        super(new ArrayList<>());
        this.repetitions = repetitions;
        this.value = value;
    }

    /**
     * Begin emitting values.
     */
    @Override
    public void start() {
        for (int i = 0; i < repetitions; i++) {
            emit(value);
        }
    }
}
