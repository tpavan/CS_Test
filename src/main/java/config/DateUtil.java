package config;

import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DateUtil {

    private static String defaultFormat = "yyyy-MM-dd";

    public static String getCurrentDate(String format) {
        if(format.isEmpty()){
            format = defaultFormat;
        }
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String date = dateObj.format(formatter);
        return date;
    }

    public static String getOldDate(String format) {
        if(format.isEmpty()){
            format = defaultFormat;
        }
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String date = dateObj.format(formatter);
        return date;
    }

    public static String getFutureDate(int oldDays , String format) {
        if(format.isEmpty()){
            format = defaultFormat;
        }
        LocalDate dateObj = LocalDate.now().plusDays(oldDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String date = dateObj.format(formatter);
        return date;
    }

    public static String getFutureDate(int oldDays) {
        LocalDate dateObj = LocalDate.now().plusDays(oldDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(defaultFormat);
        String date = dateObj.format(formatter);
        return date;
    }

    public static String getPastDate(int oldDays ) {

        LocalDate dateObj = LocalDate.now().minusDays(oldDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(defaultFormat);
        String date = dateObj.format(formatter);
        return date;
    }

    public static String getUpcomingWeekendDate(){
         return  LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).toString();
    }

}
