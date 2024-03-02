package com.mwam.hackathon.sources;

import java.util.ArrayList;

public class Range extends Source<Integer> {
    final int start;
    final int end;

    public Range(int start, int end) {
        super(new ArrayList<>());
        this.start = start;
        this.end = end;
    }

    /**
     * Begin emitting values.
     */
    @Override
    public void start() {
        for (int i = start; i < end; i++) {
            emit(i);
        }

        flush();
    }
}
