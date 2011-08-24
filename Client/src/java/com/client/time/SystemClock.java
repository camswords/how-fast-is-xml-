package com.client.time;

public class SystemClock {

    public PointInTime now() {
        AmountOfTime millisSince1970 = new AmountOfTime(System.currentTimeMillis(), UnitOfTime.MILLISECONDS);
        return new PointInTime(millisSince1970);
    }
}
