package com.client;

import com.client.http.GetRequest;
import com.client.http.HttpWebServerFactory;
import com.client.http.Response;
import com.client.http.WebServer;

public class SendWebRequestAction implements Action<Boolean> {

    private final HttpWebServerFactory webServerFactory;
    private WebServer webServer;

    public SendWebRequestAction() {
        this.webServerFactory = new HttpWebServerFactory();
        this.webServer = null;
    }

    public Boolean execute() {
        WebServer webServer = new HttpWebServerFactory().connect();

        try {
            Response response = webServer.send(new GetRequest("/"));
            return response.isOk();
        } finally {
            webServer.disconnect();
        }
    }
}
