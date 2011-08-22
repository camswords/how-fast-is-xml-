package com.client.http.io;

public class FailedToConnectException extends RuntimeException {

    public FailedToConnectException(String message, Throwable cause) {
        super(message, cause);
    }
}
