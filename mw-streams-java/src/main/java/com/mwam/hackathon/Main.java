package com.mwam.hackathon;

import com.mwam.hackathon.operators.Average;
import com.mwam.hackathon.operators.Filter;
import com.mwam.hackathon.operators.Map;
import com.mwam.hackathon.operators.TumblingMax;
import com.mwam.hackathon.pipeline.Pipeline;
import com.mwam.hackathon.sinks.ConsoleSink;
import com.mwam.hackathon.sources.Range;

import java.util.Comparator;


/**
 *
 */
public class Main {
    public static void main(String[] args) {

        Pipeline
            .from(new Range(0, 15))
            .then(new Map<>(x -> x * x))
            .then(new TumblingMax<>(Comparator.comparingInt(o -> o), 5))
            .to(new ConsoleSink<>())
            .start();
    }
}