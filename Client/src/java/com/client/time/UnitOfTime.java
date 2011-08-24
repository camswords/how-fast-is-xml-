package com.client.time;

public class UnitOfTime {

    public static final UnitOfTime SECONDS = new UnitOfTime(1000, "s");
    public static final UnitOfTime MILLISECONDS = new UnitOfTime(1, "ms");

    private final int milliseconds;
    private final String unitCode;

    public UnitOfTime(int milliseconds, String unitCode) {
        this.milliseconds = milliseconds;
        this.unitCode = unitCode;
    }

    public Long toMilliseconds(Long amount) {
        return amount * milliseconds;
    }

    @Override
    public String toString() {
        return unitCode;
    }
}
