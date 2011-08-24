package com.client;

import com.client.http.GetRequest;
import com.client.http.WebServer;
import com.client.http.HttpWebServerFactory;
import com.client.http.Response;

import java.io.IOException;

public class PerformanceTest {

    public static void main(String[] args) throws IOException {

        WebServer webServer = new HttpWebServerFactory().connect();

        try {
            Response response = webServer.send(new GetRequest("/"));
            System.out.println("response is ok? " + response.isOk());

        } finally {
            webServer.disconnect();
        }
    }
}
