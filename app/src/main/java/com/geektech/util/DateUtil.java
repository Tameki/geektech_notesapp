package com.geektech.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String formatDefaultDate(Date date) {
        return SimpleDateFormat
                .getDateTimeInstance()
                .format(date);
    }
}
