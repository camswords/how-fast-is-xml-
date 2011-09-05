package com.client.report;

import com.client.time.AmountOfTime;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ReportCard {

    private final AmountOfTime duration;
    private final String description;
    private final ReportEntries reportEntries;

    public ReportCard(AmountOfTime duration, String description, ReportEntries reportEntries) {
        this.description = description;
        this.reportEntries = reportEntries;
        this.duration = duration;
    }

    public String describeEntries() {
        StringWriter entriesDescription = new StringWriter();
        PrintWriter writer = new PrintWriter(entriesDescription);

        writer.println(reportEntries.describe());
        return entriesDescription.toString();
    }

    public String summarise() {
        StringWriter summary = new StringWriter();
        PrintWriter writer = new PrintWriter(summary);

        Statistics statistics = reportEntries.calculateStatistics();

        writer.print("Tested " + statistics.numberOfResults() + " recorded runs (" + duration + ")");
        writer.println(" for \"" + this.description + "\"");
        writer.print("   average time per request: " + statistics.average() + "ms");
        writer.print(" (" + statistics.minimum() + "ms - " + statistics.maximum() + "ms");
        writer.print(", +/- " + statistics.standardDeviation() + "ms)");

        return summary.toString();
    }
}
