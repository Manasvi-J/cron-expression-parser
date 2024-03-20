package com.deliveroo.cronparser.model;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CronExpressionResponseTest {

    @Test
    public void testPrintResponse() {
        // Arrange
        Map<String, List<Integer>> cronValues = new HashMap<>();
        cronValues.put("minute", Arrays.asList(0, 15, 30, 45));
        cronValues.put("hour", Arrays.asList(0));
        cronValues.put("day of month", Arrays.asList(1, 15));
        cronValues.put("month", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        cronValues.put("day of week", Arrays.asList(1, 2, 3, 4, 5));
        String cronCommand = "/usr/bin/find";
        CronExpressionResponse response = new CronExpressionResponse(cronValues, cronCommand);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        response.printResponse();

        // Assert
        String expectedOutput = "minute        0 15 30 45" + System.lineSeparator() +
                "hour          0" + System.lineSeparator() +
                "day of month  1 15" + System.lineSeparator() +
                "month         1 2 3 4 5 6 7 8 9 10 11 12" + System.lineSeparator() +
                "day of week   1 2 3 4 5" + System.lineSeparator() +
                "command       /usr/bin/find" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}
