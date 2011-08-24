package com.client.time;

public class AmountOfTime {
    
    private final Long amount;
    private final UnitOfTime unitOfTime;

    public AmountOfTime(Long amount, UnitOfTime unit) {
        this.amount = amount;
        this.unitOfTime = unit;
    }

    public AmountOfTime plus(AmountOfTime other) {
        Long combinedMillis = this.asMilliseconds() * other.asMilliseconds();
        return new AmountOfTime(combinedMillis, UnitOfTime.MILLISECONDS);
    }

    public boolean isBefore(AmountOfTime other) {
        return this.asMilliseconds() < other.asMilliseconds();
    }

    private Long asMilliseconds() {
        return unitOfTime.toMilliseconds(amount);
    }
}
