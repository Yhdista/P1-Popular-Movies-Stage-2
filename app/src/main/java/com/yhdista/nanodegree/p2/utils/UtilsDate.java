/*
 * Copyright (C) 2013 The Android Open Source Project
 */

package com.yhdista.nanodegree.p2.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Date Utility
 */
public class UtilsDate {


    /**
     * Basic method to change Date format from one String format to another String format
     *
     * @param inputDate     we want to change
     * @param inputPattern  input String format like "yyyy-MM-dd HH:mm:ss"
     * @param outputPattern output String format like "dd.MM.yyyy HH:mm:ss"
     * @return date in new format
     * @throws ParseException
     */
    public static String parseDate(String inputDate, String inputPattern, String outputPattern) throws ParseException {
        String outputDate = null;
        if (!inputDate.isEmpty()) {
            SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.getDefault());
            SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.getDefault());
            outputDate = outputFormat.format(inputFormat.parse(inputDate));
        }
        return outputDate;
    }

    public static String parseDate(String inputDate) throws ParseException {
        String outputDate = null;
        if (!inputDate.isEmpty()) {
            String inputPattern = "yyyy-MM-dd HH:mm:ss";
            String outputPattern = "dd.MM.yyyy HH:mm:ss";
            SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.getDefault());
            SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.getDefault());
            outputDate = outputFormat.format(inputFormat.parse(inputDate));
        }
        return outputDate;
    }

    public static Date parseDate_YYYY_MM_DD(String stringDate) throws ParseException {
        Date date = null;
        if (!stringDate.isEmpty()) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            date = format.parse(stringDate);
        }
        return date;
    }

    public static long parseDateAndGetMillis_YYYY_MM_DD(String stringDate) throws ParseException {
        Date date = parseDate_YYYY_MM_DD(stringDate);
        return getMillisFromDate(date);
    }


    /**
     * Get time in millis as a Long
     *
     * @param date input time
     * @return time as a Long
     */
    public static long getMillisFromDate(Date date) {
        return date.getTime();
    }

    /**
     * Geta Date object from Long number in millis
     *
     * @param millis input time
     * @return tome as a Date
     */
    public static Date getDateFromMillis(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public static int getTimeAsYear(Date date) {
        String year = new SimpleDateFormat("yyyy", Locale.ENGLISH).format(date);
        return Integer.valueOf(year);
    }


}
