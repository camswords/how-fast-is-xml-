package com.client.report;

import com.client.time.PointInTime;

public class ReportEntry {
    private final PointInTime startTime;
    private final PointInTime endTime;
    private final boolean wasSuccessful;

    public ReportEntry(PointInTime startTime, PointInTime endTime, boolean wasSuccessful) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.wasSuccessful = wasSuccessful;
    }

    public String describe() {
        String success = wasSuccessful ? "successful" : "UNSUCCESSFUL";
        return success + " in time taken: " + endTime.minus(startTime);
    }

    public void addTo(Statistics statistics) {
        statistics.add(endTime.minus(startTime));
    }
}
