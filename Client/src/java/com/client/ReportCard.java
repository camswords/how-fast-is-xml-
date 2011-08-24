package com.client;

import com.client.time.AmountOfTime;
import com.client.util.Lists;

import java.util.List;

public class ReportCard {

    private final List<Run> runs = Lists.create();
    private final AmountOfTime testDuration;

    public ReportCard(AmountOfTime testDuration) {
        this.testDuration = testDuration;
    }

    public String describe() {
        AmountOfTime averageTime = testDuration.divide(runs.size());

        StringBuilder description = new StringBuilder();
        description.append("Runs (" + runs.size() + " in total, " + averageTime + " average time per request)\n");
        description.append("--------------------\n");
        for (Run run : runs) {
            description.append(run.describe() + "\n");
        }
        description.append("--------------------\n");
        return description.toString();
    }

    public void add(Run run) {
        runs.add(run);
    }
}
