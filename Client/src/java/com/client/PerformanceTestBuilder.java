package com.client;

import com.client.condition.Condition;
import com.client.time.AmountOfTime;
import com.client.time.UnitOfTime;

public class PerformanceTestBuilder {

    private Action<Boolean> action;
    private AmountOfTime duration;

    public PerformanceTestBuilder perform(Action<Boolean> action) {
        this.action = action;
        return this;
    }

    public PerformanceTestBuilder forTime(Long amount, UnitOfTime unit) {
        this.duration = new AmountOfTime(amount, unit);        
        return this;
    }

    public PerformanceTest build() {
        return new PerformanceTest(duration, action);
    }
}
