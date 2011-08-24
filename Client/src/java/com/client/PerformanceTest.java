package com.client;

import com.client.http.GetRequest;
import com.client.http.HttpWebServerFactory;
import com.client.http.Response;
import com.client.http.WebServer;
import com.client.time.AmountOfTime;
import com.client.time.PointInTime;
import com.client.time.SystemClock;
import com.client.time.UnitOfTime;

import java.io.IOException;

public class PerformanceTest {
    
    private final WebServer webServer;
    private final ReportCard reportCard;
    private final AmountOfTime duration;
    private final SystemClock systemClock;

    public PerformanceTest(WebServer webServer, ReportCard reportCard, AmountOfTime duration) {
        this.webServer = webServer;
        this.reportCard = reportCard;
        this.duration = duration;
        this.systemClock = new SystemClock();
    }

    private void run() {
        PointInTime endTime = systemClock.now().plus(duration);

        while(systemClock.now().isBefore(endTime)) {
            PointInTime startTime = systemClock.now();

            Response response = webServer.send(new GetRequest("/"));

            reportCard.add(new Run(startTime, systemClock.now(), response.isOk()));
        }
    }


    public static void main(String[] args) throws IOException {

        AmountOfTime duration = new AmountOfTime(20L, UnitOfTime.SECONDS);
        ReportCard reportCard = new ReportCard(duration);
        WebServer webServer = new HttpWebServerFactory().connect();

        try {
            new PerformanceTest(webServer, reportCard, duration).run();
        } finally {
            webServer.disconnect();
        }
        System.out.println(reportCard.describe());
    }


}
