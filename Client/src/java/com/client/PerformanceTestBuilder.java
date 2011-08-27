package com.client;

import com.client.condition.Condition;
import com.client.condition.TimeIsAfter;
import com.client.time.AmountOfTime;
import com.client.time.SystemClock;
import com.client.time.UnitOfTime;

public class PerformanceTestBuilder {

    private Action<Boolean> action;
    private Condition condition;
    private AmountOfTime duration;

    public PerformanceTestBuilder perform(Action<Boolean> action) {
        this.action = action;
        return this;
    }

    public PerformanceTestBuilder forTime(Long amount, UnitOfTime unit) {
        this.duration = new AmountOfTime(amount, unit);        
        this.condition = new TimeIsAfter(new SystemClock().now().plus(this.duration));
        return this;
    }

    public PerformanceTest build() {
        return new PerformanceTest(duration, action);
    }
}
