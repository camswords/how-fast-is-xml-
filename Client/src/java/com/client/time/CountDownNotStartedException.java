package com.client.time;

public class CountDownNotStartedException extends RuntimeException {

    public CountDownNotStartedException(String message) {
        super(message);
    }
}
