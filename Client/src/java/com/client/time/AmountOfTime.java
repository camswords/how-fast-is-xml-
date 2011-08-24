package com.client.time;

public class AmountOfTime {
    
    private final Long amount;
    private final UnitOfTime unitOfTime;

    public AmountOfTime(Long amount, UnitOfTime unit) {
        this.amount = amount;
        this.unitOfTime = unit;
    }

    public AmountOfTime plus(AmountOfTime other) {
        return new AmountOfTime(this.asMilliseconds() + other.asMilliseconds(), UnitOfTime.MILLISECONDS);
    }

    public AmountOfTime minus(AmountOfTime other) {
        return new AmountOfTime(this.asMilliseconds() - other.asMilliseconds(), UnitOfTime.MILLISECONDS);
    }
    
    public AmountOfTime divide(int scalar) {
        return new AmountOfTime(this.asMilliseconds() / scalar, UnitOfTime.MILLISECONDS);
    }

    public boolean isBefore(AmountOfTime other) {
        return this.asMilliseconds() < other.asMilliseconds();
    }

    @Override
    public String toString() {
        return amount.toString() + unitOfTime.toString();
    }

    private Long asMilliseconds() {
        return unitOfTime.toMilliseconds(amount);
    }
}
