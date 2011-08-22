package com.client.http;

import java.io.PrintWriter;

public class GetRequest {

    private String uri;

    public GetRequest(String uri) {
        this.uri = uri;
    }

    public void execute(PrintWriter output) {
        output.print("GET " + uri + " HTTP/1.1\r\n");
        output.print("Host: localhost:8080\r\n");
        output.print("\r\n");
        output.flush();
    }
}
