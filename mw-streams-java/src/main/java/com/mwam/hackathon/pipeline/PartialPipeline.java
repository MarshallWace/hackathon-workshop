package com.mwam.hackathon.pipeline;

import com.mwam.hackathon.operators.Operator;
import com.mwam.hackathon.sinks.Sink;
import com.mwam.hackathon.sources.Source;


public class PartialPipeline<I, SI, SO> {

    private final Source<I> source;

    private final Operator<SI, SO> stage;

    public PartialPipeline(Source<I> source, Operator<SI, SO> stage) {
        this.source = source;
        this.stage = stage;
    }

    public <O> Pipeline<I, O> to(Sink<O> sink) {
        if (this.stage != null) {
            this.stage.addChild((Operator<SO, O>) sink);
        } else {
            this.source.addChild((Operator<I, O>) sink);
        }
        return new Pipeline<>(this.source, sink);
    }

    public <FO> PartialPipeline<I, SO, FO> then(Operator<SO, FO> fn) {
        this.stage.addChild(fn);
        return new PartialPipeline<>(this.source, fn);
    }
}
