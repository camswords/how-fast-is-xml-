package com.client.report;

import com.client.time.AmountOfTime;
import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Statistics {
    
    private DescriptiveStatistics stats;

    public Statistics() {
        stats = new DescriptiveStatistics();
    }

    public void add(AmountOfTime amountOfTime) {
        stats.addValue(amountOfTime.asMilliseconds());
    }

    public BigDecimal average() {
        return scale(stats.getMean());
    }

    public BigDecimal standardDeviation() {
        return scale(stats.getStandardDeviation());
    }

    public Long numberOfResults() {
        return stats.getN();
    }

    public BigDecimal maximum() {
        return scale(stats.getMax());
    }

    public BigDecimal minimum() {
        return scale(stats.getMin());
    }

    private BigDecimal scale(double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN);
    }
}
