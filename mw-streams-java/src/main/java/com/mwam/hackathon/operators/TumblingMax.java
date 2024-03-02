package com.mwam.hackathon.operators;

import java.util.ArrayList;
import java.util.Comparator;

public class TumblingMax<I> extends Operator<I, I> {

    private final Comparator<I> comparator;
    private final int windowSize;
    private I currentMax;
    private int countInWindow = 0;


    public TumblingMax(Comparator<I> comparator, int windowSize) {
        super(new ArrayList<>());
        this.comparator = comparator;
        this.windowSize = windowSize;
    }

    public boolean inWindow() {
        return countInWindow < windowSize;
    }

    @Override
    public void consume(I input) {

        if (currentMax != null) {
            currentMax = comparator.compare(currentMax, input) >= 0 ? currentMax : input;
        } else {
            currentMax = input;
        }
        countInWindow++;

        if (!inWindow()) {
            emit(currentMax);
            countInWindow = 0;
            currentMax = null;
        }
    }

    @Override
    public void flush() {
        if (currentMax != null) {
            emit(currentMax);
        }

        super.flush();
    }
}