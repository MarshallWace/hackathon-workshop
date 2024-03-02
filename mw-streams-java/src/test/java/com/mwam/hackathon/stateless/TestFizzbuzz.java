package com.mwam.hackathon.stateless;

import com.mwam.hackathon.sinks.CallbackSink;
import com.mwam.hackathon.sources.Range;
import com.mwam.hackathon.sources.Source;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFizzbuzz {
    final static Source<Integer> source = new Range(1, 20);
    final static List<String> expected = Arrays.asList("1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz", "16", "17", "fizz", "19");

    @Test
    public void test_fizzbuzz() {
        final var output = new ArrayList<String>();
        final var sink = new CallbackSink<String>(output::add);

        // run the pipeline
        Fizzbuzz.getPipeline(source, sink).start();

        Assertions.assertEquals(expected, output);
    }
}
