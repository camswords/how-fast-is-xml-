package com.client.time;

import java.util.Date;

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

    public boolean isAfter(PointInTime time) {
        return millisecondsSince1970.isAfter(time.millisecondsSince1970);
    }

    public AmountOfTime minus(PointInTime other) {
        return millisecondsSince1970.minus(other.millisecondsSince1970);
    }

    @Override
    public String toString() {
        Date date = new Date(millisecondsSince1970.asMilliseconds());
        return date.toString();
    }
}
