package com.deliveroo.cronparser.model;

public enum CronField {
    MINUTE("minute",0,59),
    HOUR("hour",0,23),
    DAY_OF_MONTH("day of month",1,31),
    MONTH("month",1,12),
    DAY_OF_WEEK("day of week",1,7);

    private String fieldName;
    private int startValue;
    private int endValue;

    CronField(String name, int startValue, int endValue) {
        this.fieldName = name;
        this.startValue = startValue;
        this.endValue = endValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public int getStartValue() {
        return startValue;
    }

    public int getEndValue() {
        return endValue;
    }

    public static CronField getByIndex(int index) {
        for (CronField field : CronField.values()) {
            if (field.ordinal() == index) {
                return field;
            }
        }
        return null;
    }
}
