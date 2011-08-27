package com.client;

import com.client.run.Action;
import com.client.time.AmountOfTime;
import com.client.time.UnitOfTime;

public class PerformanceTestBuilder {

    private Action action;
    private AmountOfTime duration;

    public PerformanceTestBuilder perform(Action action) {
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
