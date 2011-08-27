package com.client;

import com.client.http.GetRequest;
import com.client.http.Response;
import com.client.http.WebServer;

public class SendWebRequestAction implements Action<Boolean> {

    private final WebServer webServer;

    public SendWebRequestAction(WebServer webServer) {
        this.webServer = webServer;
    }

    public Boolean execute() {
        Response response = webServer.send(new GetRequest("/"));
        return response.isOk();
    }
}
