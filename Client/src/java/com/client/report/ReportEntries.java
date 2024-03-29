package com.client.report;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

public class ReportEntries {
    
    private final List<ReportEntry> reportEntries;

    public ReportEntries(List<ReportEntry> reportEntries) {
        this.reportEntries = reportEntries;
    }

    public Statistics calculateStatistics() {
        Statistics statistics = new Statistics();

        for (ReportEntry reportEntry : reportEntries) {
            reportEntry.addTo(statistics);
        }

        return statistics;
    }

    public String describe() {
        StringWriter description = new StringWriter();
        PrintWriter writer = new PrintWriter(description);

        for (int i = 0; i < reportEntries.size(); i++) {
            writer.println((i + 1) + ". " + reportEntries.get(i).describe());
        }

        return description.toString();
    }
}
