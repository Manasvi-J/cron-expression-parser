package com.deliveroo.cronparser.parser;

import com.deliveroo.cronparser.model.CronField;
import java.util.List;

public abstract class Parser {

    public abstract String getRegex();
    public abstract List<Integer> parse(CronField cronField, String cronExpression);
}
