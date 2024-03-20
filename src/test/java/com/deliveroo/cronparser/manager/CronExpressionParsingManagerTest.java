package com.deliveroo.cronparser.manager;

import com.deliveroo.cronparser.model.CronField;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CronExpressionParsingManagerTest {

    private CronExpressionParsingManager parsingManager;

    @Before
    public void setUp() {
        parsingManager = new CronExpressionParsingManager();
        parsingManager.registerParsers();
    }

    @Test
    public void testGetTimingsListForValidExpression() {
        String cronExpression = "*/15";
        CronField cronField = CronField.MINUTE;
        List<Integer> expected = List.of(0, 15, 30, 45);
        List<Integer> result = parsingManager.getTimingsList(cronField, cronExpression);
        assertEquals(expected, result);
    }

    @Test(expected = RuntimeException.class)
    public void testGetTimingsListForInvalidExpression() {
        String cronExpression = "invalid";
        CronField cronField = CronField.MINUTE;
        parsingManager.getTimingsList(cronField, cronExpression);
    }

}
