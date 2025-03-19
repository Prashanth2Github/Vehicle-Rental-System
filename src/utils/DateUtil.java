package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for handling date operations.
 */
public class DateUtil {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * Converts a Date object to a formatted string.
     * 
     * @param date Date object
     * @return Formatted date string
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }

    /**
     * Parses a date string into a Date object.
     * 
     * @param dateString Date string in "yyyy-MM-dd" format
     * @return Parsed Date object
     * @throws ParseException If the date format is incorrect
     */
    public static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.parse(dateString);
    }

    /**
     * Gets the current date formatted as a string.
     * 
     * @return Current date in "yyyy-MM-dd" format
     */
    public static String getCurrentDate() {
        return formatDate(new Date());
    }
}
