package com.deliveroo.cronparser.parser;

import com.deliveroo.cronparser.model.CronField;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class CommaSeparatedValuesParserTest {

    @Test
    public void testParse() {
        CommaSeparatedValuesParser parser = new CommaSeparatedValuesParser();
        CronField cronField = CronField.MINUTE; // or any other CronField
        List<Integer> result = parser.parse(cronField, "1,5,10");
        List<Integer> expected = List.of(1, 5, 10);

        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParse_InvalidValue() {
        CommaSeparatedValuesParser parser = new CommaSeparatedValuesParser();
        CronField cronField = CronField.HOUR; // or any other CronField
        parser.parse(cronField, "25"); // This should throw IllegalArgumentException
    }

    @Test
    public void testGetRegex() {
        CommaSeparatedValuesParser parser = new CommaSeparatedValuesParser();
        String regex = parser.getRegex();
        assertEquals("^\\d+(,\\d+)*$", regex);
    }
}
