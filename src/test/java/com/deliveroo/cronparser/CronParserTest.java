package com.deliveroo.cronparser;

import com.deliveroo.cronparser.manager.IParsingManager;
import com.deliveroo.cronparser.model.CronExpressionResponse;
import com.deliveroo.cronparser.model.CronField;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CronParserTest {

    private IParsingManager parsingManager;

    @Before
    public void setUp() {
        parsingManager = mock(IParsingManager.class);
    }

    @Test
    public void testParseExpression_ValidCronString() {
        // Mock parsing manager behavior
        when(parsingManager.getTimingsList(CronField.MINUTE, "*")).thenReturn(List.of(0, 1, 2));
        when(parsingManager.getTimingsList(CronField.HOUR, "*/2")).thenReturn(List.of(0, 2, 4));
        when(parsingManager.getTimingsList(CronField.DAY_OF_MONTH, "1")).thenReturn(List.of(1));
        when(parsingManager.getTimingsList(CronField.MONTH, "3")).thenReturn(List.of(3));
        when(parsingManager.getTimingsList(CronField.DAY_OF_WEEK, "1")).thenReturn(List.of(1));

        // Create the cron parser
        CronParser cronParser = new CronParser(parsingManager);

        // Test the parseExpression method
        String cronString = "* */2 1 3 1 some_command";
        CronExpressionResponse response = cronParser.parseExpression(cronString);

        // Expected result
        Map<String, List<Integer>> expectedCronValues = Map.of(
                "minute", List.of(0, 1, 2),
                "hour", List.of(0, 2, 4),
                "day of month", List.of(1),
                "month", List.of(3),
                "day of week", List.of(1)
        );
        CronExpressionResponse expectedResponse = new CronExpressionResponse(expectedCronValues, "some_command");

        // Assertions
        assertEquals(expectedResponse.getCronCommand(), response.getCronCommand());
        assertEquals(expectedResponse.getCronValues(), response.getCronValues());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseExpression_InvalidCronString() {
        // Create the cron parser
        CronParser cronParser = new CronParser(parsingManager);

        // Test an invalid cron string
        String invalidCronString = "* */2 1 3"; // Missing the command part
        cronParser.parseExpression(invalidCronString); // This should throw an IllegalArgumentException
    }
}
