package com.mwam.hackathon.stateless;

import com.mwam.hackathon.operators.Filter;
import com.mwam.hackathon.operators.FlatMap;
import com.mwam.hackathon.operators.Map;
import com.mwam.hackathon.pipeline.Pipeline;
import com.mwam.hackathon.sinks.Sink;
import com.mwam.hackathon.sources.Source;
import utils.Sentence;

import java.util.List;

public class WordCleaning {

    public static Pipeline<Sentence, String> getPipeline(Source<Sentence> source, Sink<String> sink) {
        return Pipeline
            .from(source)
            .then(new Map<>(Sentence::getSentence))
            .then(new FlatMap<>(input -> List.of(input.split(" "))))
            .then(new Map<>(String::toLowerCase))
            .then(new Map<>(input -> input.replaceAll("\\p{Punct}", "")))
            .then(new Filter<>(input -> input.length() > 3))
            .to(sink);
    }

}
