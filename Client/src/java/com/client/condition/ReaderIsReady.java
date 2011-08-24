package com.client.condition;

import java.io.IOException;
import java.io.Reader;


public class ReaderIsReady implements Condition {

    private final Reader reader;

    public ReaderIsReady(Reader reader) {
        this.reader = reader;
    }

    public boolean isSatisfied() {
        try {
            return reader.ready();
        } catch (IOException e) {
            throw new RuntimeException("failed attempting to check for readiness of reader", e);
        }
    }
}
