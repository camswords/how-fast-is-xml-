package com.client;

import com.client.time.PointInTime;

public class Run {
    private final PointInTime startTime;
    private final PointInTime endTime;
    private final boolean wasSuccessful;

    public Run(PointInTime startTime, PointInTime endTime, boolean wasSuccessful) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.wasSuccessful = wasSuccessful;
    }

    public String describe() {
        return "Run success: " + wasSuccessful + " in time taken: " + endTime.minus(startTime);
    }
}
