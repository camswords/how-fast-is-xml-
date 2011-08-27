package com.client;

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
        return "ReportEntry success: " + wasSuccessful + " in time taken: " + endTime.minus(startTime);
    }
}
