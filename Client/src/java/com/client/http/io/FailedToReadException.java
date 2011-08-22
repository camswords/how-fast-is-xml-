package com.client.http.io;

public class FailedToReadException extends RuntimeException {

    public FailedToReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
