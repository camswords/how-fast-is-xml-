package com.client;

import com.client.time.AmountOfTime;
import com.client.util.Lists;

import java.util.List;

public class ReportCard {

    private final List<RunReport> runReports = Lists.create();
    private final AmountOfTime testDuration;

    public ReportCard(AmountOfTime testDuration) {
        this.testDuration = testDuration;
    }

    public String describe() {
        AmountOfTime averageTime = testDuration.divide(runReports.size());

        StringBuilder description = new StringBuilder();
        description.append("Runs (" + runReports.size() + " in total, " + averageTime + " average time per request)\n");
        description.append("--------------------\n");
        for (RunReport runReport : runReports) {
            description.append(runReport.describe() + "\n");
        }
        description.append("--------------------\n");
        return description.toString();
    }

    public void add(RunReport runReport) {
        runReports.add(runReport);
    }
}
