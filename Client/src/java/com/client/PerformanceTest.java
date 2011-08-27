package com.client;

import com.client.time.AmountOfTime;
import com.client.time.CountDown;
import com.client.time.Timer;
import com.client.time.UnitOfTime;
import com.client.util.Lists;

import java.io.IOException;
import java.util.List;

public class PerformanceTest {

    private final AmountOfTime duration;
    private Action<Boolean> action;

    public PerformanceTest(AmountOfTime duration, Action<Boolean> action) {
        this.duration = duration;
        this.action = action;
    }

    private ReportCard run() {
        action.setUp();
        List<RunReport> runReports = Lists.create();

        try {
            CountDown countdown = new Timer(duration).countDown();
    
            while (countdown.isTickingAway()) {
                RunReport runReport = new PerformanceTestRun().execute(action);
                runReports.add(runReport);
            }
        } finally {
            action.cleanUp();
        }

        return new ReportCard(duration, runReports);

    }


    public static void main(String[] args) throws IOException {
        PerformanceTest test = new PerformanceTestBuilder().perform(new SendWebRequestAction()).forTime(2L, UnitOfTime.SECONDS).build();

        ReportCard reportCard = test.run();

        System.out.println(reportCard.describe());
    }


}
