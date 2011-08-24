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

}
