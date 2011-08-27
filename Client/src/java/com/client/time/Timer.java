package com.client.time;

import com.client.condition.Condition;
import com.client.util.ExecutingThread;

public class Timer {

    private final AmountOfTime duration;
    private final SystemClock systemClock;

    public Timer(Integer amount, UnitOfTime unitOfTime) {
        this(new AmountOfTime(amount.longValue(), unitOfTime));
    }

    public Timer(AmountOfTime duration) {
        this.duration = duration;
        this.systemClock = new SystemClock();
    }

    public void waitFor(Condition condition) {
        PointInTime endTime = systemClock.now().plus(duration);

        while(systemClock.now().isBefore(endTime)) {
            if (condition.isSatisfied()) {
                return;
            }

            ExecutingThread.waitATinyBit();
        }

        String message = "Condition [" + condition.describe() + "] failed to be satisfied within " + duration;
        throw new ConditionFailedToBeSatisfiedWithinTime(message);
        
    }

    public CountDown countDown() {
        return new CountDown(duration).start();
    }
}
