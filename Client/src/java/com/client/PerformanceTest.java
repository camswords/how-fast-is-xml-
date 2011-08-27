package com.client;

import com.client.report.ReportCard;
import com.client.report.ReportEntries;
import com.client.report.ReportEntry;
import com.client.run.Action;
import com.client.run.PerformanceTestRun;
import com.client.run.SendWebRequestAction;
import com.client.time.AmountOfTime;
import com.client.time.CountDown;
import com.client.time.Timer;
import com.client.time.UnitOfTime;
import com.client.util.Lists;

import java.io.IOException;
import java.util.List;

public class PerformanceTest {

    private final AmountOfTime duration;
    private Action action;

    public PerformanceTest(AmountOfTime duration, Action action) {
        this.duration = duration;
        this.action = action;
    }

    private ReportCard run() {
        List<ReportEntry> reportEntries = Lists.create();

        CountDown countdown = new Timer(duration).countDown();

        while (countdown.isTickingAway()) {
            reportEntries.add(new PerformanceTestRun().execute(action));
        }

        return new ReportCard(duration, new ReportEntries(reportEntries));
    }


    public static void main(String[] args) throws IOException {
        PerformanceTest test = new PerformanceTestBuilder()
                                    .perform(new SendWebRequestAction())
                                    .forTime(60L, UnitOfTime.SECONDS)
                                    .build();

        ReportCard reportCard = test.run();

        System.out.println(reportCard.describe());
    }


}
