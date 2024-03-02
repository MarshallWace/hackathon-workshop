package com.mwam.hackathon.sinks;

/**
 * Prints input to the console.
 */
public class ConsoleSink<T> extends Sink<T> {
    private final String prefix;

    public ConsoleSink() {
        super();
        this.prefix = "";
    }

    public ConsoleSink(String prefix) {
        super();
        this.prefix = prefix;
    }

    @Override
    public void consume(T input) {
        System.out.println(prefix + input);
    }
}
