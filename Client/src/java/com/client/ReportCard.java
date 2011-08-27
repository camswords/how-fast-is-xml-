package com.client;

import com.client.time.AmountOfTime;
import com.client.util.Lists;

import java.util.List;

public class ReportCard {

    private List<ReportEntry> reportEntries = Lists.create();
    private final AmountOfTime duration;

    public ReportCard(AmountOfTime duration) {
        this.duration = duration;
    }

    public ReportCard(AmountOfTime duration, List<ReportEntry> reportEntries) {
        this.reportEntries = reportEntries;
        this.duration = duration;
    }

    public String describe() {
        AmountOfTime averageTime = duration.divide(reportEntries.size());

        StringBuilder description = new StringBuilder();
        description.append("Runs (" + reportEntries.size() + " in total, " + averageTime + " average time per request)\n");
        description.append("--------------------\n");
        for (ReportEntry reportEntry : reportEntries) {
            description.append(reportEntry.describe() + "\n");
        }
        description.append("--------------------\n");
        return description.toString();
    }

    public void add(ReportEntry reportEntry) {
        reportEntries.add(reportEntry);
    }
}
