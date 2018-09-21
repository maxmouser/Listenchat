package edu.utn.listenchat.utils;

import org.apache.commons.lang3.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fabian on 9/10/17.
 */

public class DateUtils {

    private static final DateFormat UNTIL_SECOND_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private static final DateFormat UNTIL_MINUTE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    private static final DateFormat UNTIL_DAY_FORMAT = new SimpleDateFormat("yyyy-MM-dd");


    public static String toStringUntilSecond(Date date) {
        return UNTIL_SECOND_FORMAT.format(date);
    }

    public static String toStringUntilMinute(Date date) {
        return UNTIL_MINUTE_FORMAT.format(date);
    }

    public static String toStringUntilDay(Date date) {
        return UNTIL_DAY_FORMAT.format(date);
    }

    public static Date toDate(String stringDate) {
        try {
            return UNTIL_SECOND_FORMAT.parse(stringDate);
        } catch(ParseException e) {
            return null;
        }
    }

    public static String toPrettyString(String stringDate) {
        String[] arrayDate = stringDate.split("-");
        return "Día " + withoutZero(arrayDate[2]) + " del " + withoutZero(arrayDate[1]) + " de " + arrayDate[0] + ". ";
    }

    private static String withoutZero(String s) {
        return s.startsWith("0") ? s.substring(1) : s;
    }

}
