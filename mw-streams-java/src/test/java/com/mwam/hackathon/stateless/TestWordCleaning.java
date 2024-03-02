package com.mwam.hackathon.stateless;

import com.mwam.hackathon.sinks.CallbackSink;
import com.mwam.hackathon.sources.CSVSource;
import com.mwam.hackathon.sources.Source;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Sentence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestWordCleaning {

    final static Source<Sentence> source = new CSVSource<>(Sentence.class, "src/test/resources/csv_data.csv");
    final static List<String> expected = Arrays.asList("what", "date", "marshall", "wace", "what", "company", "this", "amandas", "idea");


    @Test
    public void test_word_cleaning() {
        final var output = new ArrayList<String>();
        final var sink = new CallbackSink<String>(output::add);

        // run the pipeline
        WordCleaning.getPipeline(source, sink).start();

        Assertions.assertEquals(expected, output);
    }


}
