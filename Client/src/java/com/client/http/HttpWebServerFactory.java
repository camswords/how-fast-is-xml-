package com.client.http;

import com.client.http.io.Socket;
import com.client.http.io.SocketConnectionFactory;

public class HttpWebServerFactory {

    public WebServer connect() {
        Socket socket = new SocketConnectionFactory().connect();
        return new WebServer(socket);
    }
}
