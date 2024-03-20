package com.deliveroo.cronparser.manager;

import com.deliveroo.cronparser.model.CronField;
import com.deliveroo.cronparser.parser.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CronExpressionParsingManager implements IParsingManager {
    private Set<Parser> parserSet = new HashSet<>();

    @Override
    public List<Integer> getTimingsList(CronField cronField, String cronExpression) {
        for(Parser parser: parserSet) {
            if(Pattern.matches(parser.getRegex(),cronExpression)) {
                return parser.parse(cronField, cronExpression);
            }
        }
        throw new RuntimeException("Invalid cron expression entered, Cannot be parsed!");
    }

    @Override
    public void registerParsers() {
        parserSet.add(new AsteriskParser());
        parserSet.add(new StepIncrementParser());
        parserSet.add(new CommaSeparatedValuesParser());
        parserSet.add(new NumberParser());
        parserSet.add(new RangeParser());
    }

    public Set<Parser> getParserSet() {
        return parserSet;
    }
}