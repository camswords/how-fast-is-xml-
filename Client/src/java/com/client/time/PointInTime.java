package com.client.time;

public class PointInTime {
    
    private final AmountOfTime millisecondsSince1970;

    public PointInTime(AmountOfTime millisecondsSince1970) {
        this.millisecondsSince1970 = millisecondsSince1970;
    }

    public PointInTime plus(AmountOfTime amountOfTime) {
        return new PointInTime(amountOfTime.plus(millisecondsSince1970));
    }

    public boolean isBefore(PointInTime time) {
        return millisecondsSince1970.isBefore(time.millisecondsSince1970);
    }
}
