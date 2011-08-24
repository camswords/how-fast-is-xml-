package com.client.time;

public class UnitOfTime {

    public static final UnitOfTime SECONDS = new UnitOfTime(1000);
    public static final UnitOfTime MILLISECONDS = new UnitOfTime(1);

    private final int milliseconds;

    public UnitOfTime(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public Long toMilliseconds(Long amount) {
        return amount * milliseconds;
    }
}
