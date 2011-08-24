package com.client.time;

import com.client.condition.Condition;
import com.client.util.ExecutingThread;

public class Timer {

    private final AmountOfTime maximumWaitTime;
    private final SystemClock systemClock;

    public Timer(Integer amount, UnitOfTime unitOfTime) {
        this.maximumWaitTime = new AmountOfTime(amount.longValue(), unitOfTime);
        this.systemClock = new SystemClock();
    }

    public void waitFor(Condition condition) {
        PointInTime endTime = systemClock.now().plus(maximumWaitTime);

        while(systemClock.now().isBefore(endTime)) {
            if (condition.isSatisfied()) {
                return;
            }

            ExecutingThread.waitATinyBit();
        }

        String message = "Condition [" + condition.describe() + "] failed to be satisfied within " + maximumWaitTime;
        throw new ConditionFailedToBeSatisfiedWithinTime(message);
        
    }
}