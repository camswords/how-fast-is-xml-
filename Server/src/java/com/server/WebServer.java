package com.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        server.setHandler(new WebAppContext("Server/src/webapp", "/"));
        server.start();
    }
}
