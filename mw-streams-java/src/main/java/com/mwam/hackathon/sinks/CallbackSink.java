package com.mwam.hackathon.sinks;

import java.util.function.Function;

/**
 * A sink that invokes a callback function when called with an event.
 *
 * @param <T> event type
 */
public class CallbackSink<T> extends Sink<T> {
    private final Function<T, ?> callback;

    public CallbackSink(Function<T, ?> callback) {
        this.callback = callback;
    }

    @Override
    public void consume(T input) {
        callback.apply(input);
    }
}
