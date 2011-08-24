package com.client.time;

public class ConditionFailedToBeSatisfiedWithinTime extends RuntimeException {

    public ConditionFailedToBeSatisfiedWithinTime(String message) {
        super(message);
    }
}
