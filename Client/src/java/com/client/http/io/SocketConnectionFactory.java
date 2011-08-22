package com.client.http.io;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class SocketConnectionFactory {

    public Socket connect() {
        java.net.Socket socket = new java.net.Socket();

        try {
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8080));
        } catch (IOException e) {
            throw new FailedToConnectException("failed to connect to localhost:8080", e);
        };

        return new Socket(socket);
    }
}
