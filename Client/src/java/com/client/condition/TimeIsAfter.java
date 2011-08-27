package com.client.condition;

import com.client.time.PointInTime;
import com.client.time.SystemClock;

public class TimeIsAfter implements Condition {

    private final PointInTime pointInTime;

    public TimeIsAfter(PointInTime pointInTime) {
        this.pointInTime = pointInTime;
    }

    public boolean isSatisfied() {
        return new SystemClock().now().isAfter(pointInTime);
    }

    public String describe() {
        return "time is after " + pointInTime;
    }
}
