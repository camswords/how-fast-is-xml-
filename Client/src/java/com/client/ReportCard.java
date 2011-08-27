package com.client;

import com.client.time.AmountOfTime;
import com.client.util.Lists;

import java.util.List;

public class ReportCard {

    private List<RunReport> runReports = Lists.create();
    private final AmountOfTime duration;

    public ReportCard(AmountOfTime duration) {
        this.duration = duration;
    }

    public ReportCard(AmountOfTime duration, List<RunReport> runReports) {
        this.runReports = runReports;
        this.duration = duration;
    }

    public String describe() {
        AmountOfTime averageTime = duration.divide(runReports.size());

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
