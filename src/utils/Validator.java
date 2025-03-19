package utils;

import java.util.regex.Pattern;

/**
 * Utility class for validating user input.
 */
public class Validator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+(\\.[0-9]+)?$");

    /**
     * Validates an email address.
     * 
     * @param email Email address string
     * @return true if valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validates a phone number (10-digit).
     * 
     * @param phone Phone number string
     * @return true if valid, false otherwise
     */
    public static boolean isValidPhone(String phone) {
        return PHONE_PATTERN.matcher(phone).matches();
    }

    /**
     * Checks if a string is a valid number.
     * 
     * @param number Number string
     * @return true if valid, false otherwise
     */
    public static boolean isValidNumber(String number) {
        return NUMBER_PATTERN.matcher(number).matches();
    }

    /**
     * Checks if a string is not empty or null.
     * 
     * @param input Input string
     * @return true if valid, false otherwise
     */
    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }
}
