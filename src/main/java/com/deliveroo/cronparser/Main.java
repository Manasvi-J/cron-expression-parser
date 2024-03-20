package com.deliveroo.cronparser;

import com.deliveroo.cronparser.manager.CronExpressionParsingManager;
import com.deliveroo.cronparser.manager.IParsingManager;
import com.deliveroo.cronparser.model.CronExpressionResponse;

public class Main {
    public static void main(String[] args){
        if(args.length != 1 && args[0].split(" ").length != 6) {
            throw new RuntimeException("Invalid number of arguments passed!");
        }
        String cronExpression = args[0];

        IParsingManager parsingManager = new CronExpressionParsingManager();
        parsingManager.registerParsers();
        CronParser cronParser = new CronParser(parsingManager);
        try{
            CronExpressionResponse cronExpressionResponse = cronParser.parseExpression(cronExpression);
            cronExpressionResponse.printResponse();
        } catch(RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
