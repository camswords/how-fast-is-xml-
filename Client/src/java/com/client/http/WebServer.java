package com.client.http;

import com.client.http.io.Socket;

import java.io.PrintWriter;

public class WebServer {

    private final Socket socket;

    public WebServer(Socket socket) {
        this.socket = socket;
    }

    public Response send(GetRequest request) {
        PrintWriter output = socket.writer();

        request.execute(output);

        return new Response(socket.reader());
    }

    public void disconnect() {
        socket.close();
    }
}
