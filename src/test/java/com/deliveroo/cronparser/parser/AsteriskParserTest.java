package com.deliveroo.cronparser.parser;

import com.deliveroo.cronparser.model.CronField;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class AsteriskParserTest {

    @Test
    public void testParse() {
        AsteriskParser parser = new AsteriskParser();
        CronField cronField = CronField.MINUTE;
        List<Integer> result = parser.parse(cronField, "*");

        List<Integer> expected = new ArrayList<>();
        for (int i = cronField.getStartValue(); i <= cronField.getEndValue(); i++) {
            expected.add(i);
        }

        assertEquals(expected, result);
    }

    @Test
    public void testGetRegex() {
        AsteriskParser parser = new AsteriskParser();
        String regex = parser.getRegex();

        assertEquals("^\\*$", regex);
    }
}
