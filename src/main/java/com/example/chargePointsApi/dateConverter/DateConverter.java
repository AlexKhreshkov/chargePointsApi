package com.example.chargePointsApi.dateConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    private static final String[] SUPPORTED_FORMATS = {
            "yyyy/MM/dd HH:mm", "yyyy/MM/dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd"
    };

    public static Date convert(String str) throws ParseException {
        ParseException exception = null;
        for (String format : SUPPORTED_FORMATS) {
            try {
                return new SimpleDateFormat(format).parse(str);
            } catch (ParseException e) {
                if (exception == null) {
                    exception = e;
                }
            }
        }
        if (exception != null) {
            throw exception;
        }
        throw new ParseException("Unknown date format", 0);
    }
}