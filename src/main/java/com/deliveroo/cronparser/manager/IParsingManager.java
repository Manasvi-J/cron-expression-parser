package com.deliveroo.cronparser.manager;

import com.deliveroo.cronparser.model.CronField;

import java.util.List;

public interface IParsingManager {
    List<Integer> getTimingsList(CronField cronField, String cronExpression);
    void registerParsers();
}
