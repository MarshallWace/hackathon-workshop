package com.mwam.hackathon.pipeline;

import com.mwam.hackathon.sinks.Sink;
import com.mwam.hackathon.sources.Source;

/**
 * @param <I>
 * @param <O>
 */
public class Pipeline<I, O> {
    private final Source<I> source;
    private final Sink<O> sink;


    public Pipeline(Source<I> source, Sink<O> sink) {
        this.source = source;
        this.sink = sink;
    }

    public static <I> SourcePipeline<I> from(Source<I> source) {
        return new SourcePipeline<>(source);
    }

    public void start() {
        this.source.start();
    }
}


