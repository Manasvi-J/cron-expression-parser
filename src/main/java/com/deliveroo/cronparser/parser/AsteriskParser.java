package com.deliveroo.cronparser.parser;

import com.deliveroo.cronparser.model.CronField;
import java.util.ArrayList;
import java.util.List;

public class AsteriskParser extends Parser {

    @Override
    public List<Integer> parse(CronField CronField, String fieldValue){
        List<Integer> result = new ArrayList<>();
        int startValue = CronField.getStartValue();
        int endValue = CronField.getEndValue();

        while(startValue <= endValue) {
            result.add(startValue);
            startValue++;
        }
        return result;
    }

    @Override
    public String getRegex(){
        return "^\\*$";
    }

}
