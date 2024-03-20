package com.deliveroo.cronparser.parser;

import com.deliveroo.cronparser.model.CronField;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class NumberParserTest {

    @Test
    public void testParse_ValidValue() {
        NumberParser parser = new NumberParser();
        CronField cronField = CronField.MINUTE; // or any other CronField
        List<Integer> result = parser.parse(cronField, "30");

        // Expected result should be a list containing the parsed value
        List<Integer> expected = List.of(30);

        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParse_InvalidValue() {
        NumberParser parser = new NumberParser();
        CronField cronField = CronField.HOUR; // or any other CronField
        parser.parse(cronField, "25"); // This should throw IllegalArgumentException
    }

    @Test
    public void testGetRegex() {
        NumberParser parser = new NumberParser();
        String regex = parser.getRegex();
        assertEquals("^\\d+$", regex);
    }
}
