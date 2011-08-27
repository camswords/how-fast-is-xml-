package com.client.report;

import com.client.ReportEntry;

import java.util.List;

public class ReportEntryStatisticsCalculator {

    public Statistics calculate(List<ReportEntry> reportEntries) {
        Statistics statistics = new Statistics();

        for (ReportEntry reportEntry : reportEntries) {
            reportEntry.addTo(statistics);
        }

        return statistics;
    }
}
