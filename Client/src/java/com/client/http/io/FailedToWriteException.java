package com.client.http.io;

public class FailedToWriteException extends RuntimeException {
    
    public FailedToWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
