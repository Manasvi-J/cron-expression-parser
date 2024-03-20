package com.deliveroo.cronparser.parser;

import com.deliveroo.cronparser.model.CronField;
import java.util.ArrayList;
import java.util.List;

public class RangeParser extends Parser {

    private boolean isValidRange(int start, int end, CronField field) {
        return start >= field.getStartValue() && start <= end && end <= field.getEndValue();
    }

    @Override
    public List<Integer> parse(CronField field, String expression) {
        List<Integer> result = new ArrayList<>();
        String[] values = expression.split("-");
        int start = Integer.parseInt(values[0]);
        int end = Integer.parseInt(values[1]);
        if (isValidRange(start, end, field)) {
            for (int value = start; value <= end; value++) {
                result.add(value);
            }
        } else {
            throw new IllegalArgumentException("Invalid range values: " + expression + " for field: " + field.getFieldName());
        }
        return result;
    }

    @Override
    public String getRegex() {
        return "^\\d+\\-\\d+$";
    }
}
