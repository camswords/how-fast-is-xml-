package com.client.run;

import com.client.http.GetRequest;
import com.client.http.HttpWebServerFactory;
import com.client.http.Response;
import com.client.http.WebServer;

public class SendSimpleWebRequestAction implements Action {

    public Boolean execute() {
        WebServer webServer = new HttpWebServerFactory().connect();

        try {
            Response response = webServer.send(new GetRequest("/"));
            return response.isOk();
        } finally {
            webServer.disconnect();
        }
    }

    public String describe() {
        return "web request that always returns a 200 response";
    }
}
