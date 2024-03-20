package com.deliveroo.cronparser.model;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CronExpressionResponseTest {

    @Test
    public void testPrintResponse() {
        // Arrange
        Map<String, List<Integer>> cronValues = new HashMap<>();
        cronValues.put("minute", List.of(0, 15, 30, 45));
        cronValues.put("hour", List.of(0));
        cronValues.put("day of month", List.of(1, 15));
        cronValues.put("month", List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        cronValues.put("day of week", List.of(1, 2, 3, 4, 5));
        String cronCommand = "/usr/bin/find";
        CronExpressionResponse response = new CronExpressionResponse(cronValues, cronCommand);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Act
        response.printResponse();

        // Assert
        String expectedOutput = "minute        [0, 15, 30, 45]\n" +
                "hour          [0]\n" +
                "day of month  [1, 15]\n" +
                "month         [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]\n" +
                "day of week   [1, 2, 3, 4, 5]\n" +
                "command       /usr/bin/find\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
