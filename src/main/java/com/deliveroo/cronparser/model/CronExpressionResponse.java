package com.deliveroo.cronparser.model;

import java.util.List;
import java.util.Map;

public class CronExpressionResponse {
    private Map<String, List<Integer>> cronValues;
    private String cronCommand;

    public CronExpressionResponse(Map<String, List<Integer>> cronValues, String cronCommand) {
        this.cronValues = cronValues;
        this.cronCommand = cronCommand;
    }

    public void printResponse() {
        for (CronField field : CronField.values()) {
            appendField(field);
        }
        System.out.println(String.format("%-14s%s", "command", cronCommand));
    }

    private void appendField(CronField field) {
        String fieldName = field.getFieldName();
        if (cronValues.containsKey(fieldName)) {
            List<Integer> values = cronValues.get(fieldName);
            System.out.println(String.format("%-14s%s", fieldName, formatValues(values)));
        }
    }

    private String formatValues(List<Integer> values) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) {
                builder.append(" ");
            }
            builder.append(values.get(i));
        }
        return builder.toString();
    }

    public Map<String, List<Integer>> getCronValues() {
        return cronValues;
    }

    public String getCronCommand() {
        return cronCommand;
    }
}
