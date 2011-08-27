package com.client;

import com.client.time.PointInTime;
import com.client.time.SystemClock;

public class PerformanceTestRun {

    private final SystemClock systemClock = new SystemClock();

    public RunReport execute(Action<Boolean> action) {
        PointInTime startedAt = systemClock.now();
        
        Boolean wasSuccessful = action.execute();

        PointInTime endTime = systemClock.now();
        return new RunReport(startedAt, endTime, wasSuccessful);
    }
}
