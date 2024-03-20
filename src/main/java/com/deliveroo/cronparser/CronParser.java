package com.deliveroo.cronparser;

import com.deliveroo.cronparser.model.CronExpressionResponse;
import com.deliveroo.cronparser.model.CronField;
import com.deliveroo.cronparser.manager.IParsingManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CronParser {
    private IParsingManager parsingManager;

    public CronParser(IParsingManager parsingManager) {
        this.parsingManager = parsingManager;
    }

    public CronExpressionResponse parseExpression(String cronString) {
        String[] subCronExpressions = cronString.split(" ");
        if (subCronExpressions.length != CronField.values().length + 1) {
            throw new IllegalArgumentException("Invalid cron string format (expected " + (CronField.values().length + 1) + " fields)");
        }

        Map<String, List<Integer>> cronValuesMap = new HashMap<>();
        for (int i = 0; i < subCronExpressions.length - 1; i++) {
            String fieldName = CronField.getByIndex(i).getFieldName();
            List<Integer> fieldValues = parsingManager.getTimingsList(CronField.getByIndex(i), subCronExpressions[i]);
            cronValuesMap.put(fieldName, fieldValues);
        }

        String command = subCronExpressions[subCronExpressions.length - 1];
        return new CronExpressionResponse(cronValuesMap, command);
    }
}
