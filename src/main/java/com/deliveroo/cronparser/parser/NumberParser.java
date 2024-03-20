package com.deliveroo.cronparser.parser;

import com.deliveroo.cronparser.model.CronField;
import java.util.ArrayList;
import java.util.List;

public class NumberParser extends Parser {

    @Override
    public List<Integer> parse(CronField field, String expression) {
        List<Integer> result = new ArrayList<>();
        int value = Integer.parseInt(expression);
        if (isValidValue(value, field)) {
            result.add(value);
        } else {
            throw new IllegalArgumentException("Invalid time value: " + expression + " for field: " + field.getFieldName());
        }
        return result;
    }

    private boolean isValidValue(int value, CronField field) {
        return value >= field.getStartValue() && value <= field.getEndValue();
    }

    @Override
    public String getRegex() {
        return "^\\d+$";
    }
}
