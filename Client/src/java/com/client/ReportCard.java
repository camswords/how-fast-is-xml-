package com.client;

import com.client.report.ReportEntryStatisticsCalculator;
import com.client.report.Statistics;
import com.client.time.AmountOfTime;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

public class ReportCard {

    private final AmountOfTime duration;
    private final List<ReportEntry> reportEntries;

    public ReportCard(AmountOfTime duration, List<ReportEntry> reportEntries) {
        this.reportEntries = reportEntries;
        this.duration = duration;
    }

    public String describe() {
        Statistics statistics = new ReportEntryStatisticsCalculator().calculate(reportEntries);

        AmountOfTime averageTime = duration.divide(reportEntries.size());

        StringWriter description = new StringWriter();
        PrintWriter writer = new PrintWriter(description);

        writer.println("Runs (" + reportEntries.size() + " in total, " + averageTime + " average time per request)");

        for (int i = 0; i < reportEntries.size(); i++) {
            writer.println((i + 1) + ". " + reportEntries.get(i).describe());
        }

        writer.println("runs: " + statistics.numberOfResults());
        writer.println("maximum: " + statistics.maximum() + "ms");
        writer.println("minimum: " + statistics.minimum() + "ms");
        writer.println("average: " + statistics.average() + "ms");
        writer.println("deviation: " + statistics.standardDeviation() + "ms");

        return description.toString();
    }
}
