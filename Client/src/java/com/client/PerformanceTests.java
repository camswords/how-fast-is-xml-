package com.client;

import com.client.report.ReportCard;
import com.client.run.SendSimpleWebRequestAction;
import com.client.time.UnitOfTime;
import com.client.util.Lists;

import java.io.IOException;
import java.util.List;

public class PerformanceTests {
    
    private List<PerformanceTest> performanceTests;

    public PerformanceTests(PerformanceTest ... performanceTests) {
        this.performanceTests = Lists.create(performanceTests);
    }

    private void run() {
        for (PerformanceTest performanceTest : performanceTests) {
            ReportCard reportCard = performanceTest.run();
            System.out.println(reportCard.summarise());
        }
    }

    public static void main(String[] args) throws IOException {
        PerformanceTest simpleWebRequest = new PerformanceTestBuilder()
                                    .perform(new SendSimpleWebRequestAction())
                                    .forTime(5L, UnitOfTime.SECONDS)
                                    .build();

        new PerformanceTests(simpleWebRequest).run();
    }
}
