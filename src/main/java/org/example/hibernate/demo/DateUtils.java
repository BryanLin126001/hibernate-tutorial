package org.example.hibernate.demo;

import javassist.Loader;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateUtils
{
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


    public static Date parseDate(String dateStr) throws ParseException
    {
        return formatter.parse(dateStr);
    }

    public static String formatDate(Date date)
    {
        return date != null? formatter.format(date) : null;
    }
}