package com.mwam.hackathon.stateful;

import com.mwam.hackathon.operators.Max;
import com.mwam.hackathon.pipeline.Pipeline;
import com.mwam.hackathon.sinks.Sink;
import com.mwam.hackathon.sources.Source;

import java.util.Comparator;

public class MaxTemperature {
    public static Pipeline<Double, Double> getPipeline(Source<Double> source, Sink<Double> sink) {
        return Pipeline.from(source)
            .then(new Max<Double>(Comparator.naturalOrder()))
            .to(sink);
    }
}
