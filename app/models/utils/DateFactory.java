package models.utils;

import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * Date: 12/16/13
 */
public class DateFactory {
    public static Date Date(int year, int month, int day){
        return new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
    }
}
