package com.client;

import com.client.report.ReportCard;
import com.client.report.ReportEntries;
import com.client.report.ReportEntry;
import com.client.run.Action;
import com.client.run.PerformanceTestRun;
import com.client.time.AmountOfTime;
import com.client.time.CountDown;
import com.client.time.Timer;
import com.client.util.Lists;

import java.util.List;

public class PerformanceTest {

    private final AmountOfTime duration;
    private Action action;

    public PerformanceTest(AmountOfTime duration, Action action) {
        this.duration = duration;
        this.action = action;
    }

    public ReportCard run() {
        List<ReportEntry> reportEntries = Lists.create();

        CountDown countdown = new Timer(duration).countDown();

        while (countdown.isTickingAway()) {
            reportEntries.add(new PerformanceTestRun().execute(action));
        }

        return new ReportCard(duration, action.describe(), new ReportEntries(reportEntries));
    }
}
