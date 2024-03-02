package com.mwam.hackathon.stateless;

import com.mwam.hackathon.operators.Map;
import com.mwam.hackathon.pipeline.Pipeline;
import com.mwam.hackathon.sinks.Sink;
import com.mwam.hackathon.sources.Source;

public class Fizzbuzz {
    public static Pipeline<Integer, String> getPipeline(Source<Integer> source, Sink<String> sink) {
        return Pipeline.from(source)
            .then(...)
            .to(sink);
    }
}
