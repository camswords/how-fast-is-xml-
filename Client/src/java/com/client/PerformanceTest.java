package com.client;

import com.client.http.HttpWebServerFactory;
import com.client.http.WebServer;
import com.client.time.*;

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
        CountDown countdown = new Timer(duration).countDown();

        while (countdown.isTickingAway()) {
            RunReport runReport = new PerformanceTestRun().execute(new SendWebRequestAction(webServer));
            reportCard.add(runReport);
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
