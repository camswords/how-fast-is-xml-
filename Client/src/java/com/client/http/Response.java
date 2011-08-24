package com.client.http;

import com.client.http.io.BufferedReader;

import java.io.Reader;
import java.util.List;

public class Response {
    
    private final Reader reader;

    public Response(Reader reader) {
        this.reader = reader;
    }

    public List<String> lines() {
        return new BufferedReader(this.reader).readUntil("\r\n");
    }

    public boolean isOk() {
        List<String> responseContent = lines();

        if (responseContent.isEmpty()) {
            throw new RuntimeException("failed to receive any response from the server");
        }

        return responseContent.get(0).contains("200 OK");
    }
}
