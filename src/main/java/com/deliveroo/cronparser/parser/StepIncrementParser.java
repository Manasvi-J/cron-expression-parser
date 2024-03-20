package com.deliveroo.cronparser.parser;

import com.deliveroo.cronparser.model.CronField;
import java.util.ArrayList;
import java.util.List;

public class StepIncrementParser extends Parser {

    @Override
    public List<Integer> parse(CronField cronField, String cronExpression) {
        List<Integer> result = new ArrayList<>();
        String prefix = "*/";
        int increment;
        try {
            increment = Integer.parseInt(cronExpression.substring(prefix.length()));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid increment value format: " + cronExpression);
        }
        int minValue = cronField.getStartValue();
        int maxValue = cronField.getEndValue();
        if (increment < minValue || increment > maxValue) {
            throw new IllegalArgumentException("Invalid increment value: " + increment + " for field: " + cronField.getFieldName());
        }
        for (int value = minValue; value <= maxValue; value += increment) {
            result.add(value);
        }
        return result;
    }

    @Override
    public String getRegex() {
        return "^\\*\\/\\d+$";
    }
}
