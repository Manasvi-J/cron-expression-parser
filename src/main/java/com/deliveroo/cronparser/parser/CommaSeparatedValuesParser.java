package com.deliveroo.cronparser.parser;

import com.deliveroo.cronparser.model.CronField;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CommaSeparatedValuesParser extends Parser {

    private boolean isValidTimeValue(int value, CronField field) {
        return value >= field.getStartValue() && value <= field.getEndValue();
    }

    @Override
    public List<Integer> parse(CronField field, String expression) {
        Set<Integer> parsedValues = new TreeSet<>();
        String[] values = expression.split(",");
        for (String value : values) {
            int intValue = Integer.parseInt(value);
            if (isValidTimeValue(intValue, field)) {
                parsedValues.add(intValue);
            } else {
                throw new IllegalArgumentException("Invalid time value: " + intValue + " for field: " + field.getFieldName());
            }
        }
        return new ArrayList<>(parsedValues);
    }

    @Override
    public String getRegex() {
        return "^\\d+(,\\d+)*$";
    }
}
