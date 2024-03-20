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
        StringBuffer buffer = new StringBuffer();
        for (CronField field : CronField.values()) {
            appendField(buffer, field);
        }
        buffer.append(String.format("%-14s%s\n", "command", cronCommand));
        System.out.print(buffer.toString());
    }

    private void appendField(StringBuffer buffer, CronField field) {
        String fieldName = field.getFieldName();
        if (cronValues.containsKey(fieldName)) {
            List<Integer> values = cronValues.get(fieldName);
            buffer.append(String.format("%-14s%s\n", fieldName, String.join(" ", values.toString())));
        }
    }

    public Map<String, List<Integer>> getCronValues() {
        return cronValues;
    }

    public String getCronCommand() {
        return cronCommand;
    }
}
