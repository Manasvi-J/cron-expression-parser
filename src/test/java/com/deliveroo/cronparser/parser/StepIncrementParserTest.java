package com.deliveroo.cronparser.parser;

import com.deliveroo.cronparser.model.CronField;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class StepIncrementParserTest {

    @Test
    public void testParse_ValidIncrement() {
        StepIncrementParser parser = new StepIncrementParser();
        CronField cronField = CronField.MINUTE; // or any other CronField
        List<Integer> result = parser.parse(cronField, "*/5");

        // Expected result should be a list containing values incremented by 5 within the field range
        List<Integer> expected = List.of(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);

        assertEquals(expected, result);
    }

    @Test
    public void testGetRegex() {
        StepIncrementParser parser = new StepIncrementParser();
        String regex = parser.getRegex();
        assertEquals("^\\*\\/\\d+$", regex);
    }
}
