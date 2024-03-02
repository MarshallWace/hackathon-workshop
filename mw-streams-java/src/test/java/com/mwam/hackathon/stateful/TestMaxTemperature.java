package com.mwam.hackathon.stateful;


import com.mwam.hackathon.sinks.CallbackSink;
import com.mwam.hackathon.sources.IterSource;
import com.mwam.hackathon.sources.Source;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMaxTemperature {
    final static Source<Double> source = new IterSource<>(Arrays.asList(
        15.0, 22.5, 20.3, 18.7, 25.2, 30.1, 35.6, 40.4, 45.0, 10.8, 5.5, 0.0, -5.2, -10.3, 28.9, 32.5, 38.7, 42.1, 37.3, 29.4, 23.8, 17.6, 13.2, 8.8, 3.3, -2.4, -7.1, -12.5, 33.0, 39.2, 41.5, 36.6, 31.7, 26.4, 21.9, 16.5, 11.0, 6.3, 1.2, -3.8, -8.6, -11.9, 34.7, 27.5, 19.3, 14.4, 9.6, 4.2, -1.5, -4.9, -6.7, -9.4
    ));

    final static List<Double> expected = Arrays.asList(
        15.0, 22.5, 22.5, 22.5, 25.2, 30.1, 35.6, 40.4, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0, 45.0
    );

    @Test
    public void test_maxTemperature() {
        final var output = new ArrayList<Double>();
        final var sink = new CallbackSink<Double>(output::add);

        // run the pipeline
        MaxTemperature.getPipeline(source, sink).start();

        Assertions.assertEquals(expected, output);
    }
}
