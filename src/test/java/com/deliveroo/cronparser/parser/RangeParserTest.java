package com.deliveroo.cronparser.parser;

import com.deliveroo.cronparser.model.CronField;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class RangeParserTest {

    @Test
    public void testParse_ValidRange() {
        RangeParser parser = new RangeParser();
        CronField cronField = CronField.HOUR; // or any other CronField
        List<Integer> result = parser.parse(cronField, "10-15");

        // Expected result should be a list containing values from 10 to 15
        List<Integer> expected = List.of(10, 11, 12, 13, 14, 15);

        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParse_InvalidRange() {
        RangeParser parser = new RangeParser();
        CronField cronField = CronField.DAY_OF_MONTH; // or any other CronField
        parser.parse(cronField, "35-40"); // This should throw IllegalArgumentException
    }

    @Test
    public void testGetRegex() {
        RangeParser parser = new RangeParser();
        String regex = parser.getRegex();
        assertEquals("^\\d+\\-\\d+$", regex);
    }
}
