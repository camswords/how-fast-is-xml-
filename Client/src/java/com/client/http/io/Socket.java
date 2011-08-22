package com.client.http.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public class Socket {

    private final java.net.Socket socket;

    public Socket(java.net.Socket socket) {
        this.socket = socket;
    }

    public PrintWriter writer() {
        try {
            return new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            throw new FailedToWriteException("failed to write to localhost:8080", e);
        }
    }

    public Reader reader() {
        try {
            return new InputStreamReader(socket.getInputStream());
        } catch (IOException e) {
            throw new FailedToReadException("failed to read from localhost:8080", e);
        }
    }

    public void close() {
        try {
            socket.close();
        } catch(Exception e) {
            // intentionally blank
        }
    }
}
