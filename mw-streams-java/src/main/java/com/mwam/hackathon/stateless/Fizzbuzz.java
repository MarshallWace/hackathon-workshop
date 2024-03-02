package com.mwam.hackathon.stateless;

import com.mwam.hackathon.operators.Map;
import com.mwam.hackathon.pipeline.Pipeline;
import com.mwam.hackathon.sinks.Sink;
import com.mwam.hackathon.sources.Source;

public class Fizzbuzz {
    public static Pipeline<Integer, String> getPipeline(Source<Integer> source, Sink<String> sink) {
        return Pipeline.from(source)
            .then(new Map<>(x -> {
                if ((x % 5 == 0) && (x % 3 == 0))
                    return "fizzbuzz";
                else if (x % 3 == 0)
                    return "fizz";
                else if (x % 5 == 0)
                    return "buzz";

                return x.toString();
            }))
            .to(sink);
    }
}
