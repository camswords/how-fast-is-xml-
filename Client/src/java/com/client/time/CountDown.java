package com.client.time;

public class CountDown {
    
    private final AmountOfTime duration;
    private final SystemClock systemClock;

    private PointInTime endTime = null;

    public CountDown(AmountOfTime duration) {
        this.duration = duration;
        this.systemClock = new SystemClock();
    }

    public CountDown start() {
        this.endTime = systemClock.now().plus(duration);
        return this;
    }

    public boolean isTickingAway() {
        if (endTime == null) {
            throw new CountDownNotStartedException("the count down must be started for the timer to start ticking.");
        }

        return systemClock.now().isBefore(endTime);
    }
}
