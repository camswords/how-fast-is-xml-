package com.client;

import com.client.report.ReportEntries;
import com.client.report.Statistics;
import com.client.time.AmountOfTime;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ReportCard {

    private final AmountOfTime duration;
    private final ReportEntries reportEntries;

    public ReportCard(AmountOfTime duration, ReportEntries reportEntries) {
        this.reportEntries = reportEntries;
        this.duration = duration;
    }

    public String describe() {
        StringWriter description = new StringWriter();
        PrintWriter writer = new PrintWriter(description);

        writer.println(reportEntries.describe());

        Statistics statistics = reportEntries.calculateStatistics();

        writer.println(statistics.numberOfResults() + " recorded runs over " + duration);
        writer.println("maximum: " + statistics.maximum() + "ms");
        writer.println("minimum: " + statistics.minimum() + "ms");
        writer.println("average: " + statistics.average() + "ms");
        writer.println("deviation: " + statistics.standardDeviation() + "ms");

        return description.toString();
    }
}
