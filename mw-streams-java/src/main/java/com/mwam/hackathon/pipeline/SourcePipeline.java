package com.mwam.hackathon.pipeline;

import com.mwam.hackathon.operators.Operator;
import com.mwam.hackathon.sources.Source;

public class SourcePipeline<I> {
    private final Source<I> source;

    public SourcePipeline(Source<I> source) {
        this.source = source;
    }

    public <FO> PartialPipeline<I, I, FO> then(Operator<I, FO> fn) {
        this.source.addChild(fn);
        return new PartialPipeline<>(this.source, fn);
    }
}
