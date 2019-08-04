package com.anand.parkinglot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validation utility.
 */
public class Validation {

    // KA-01-HH-1234
    private static String registrationNumberRegex = "^[A-Z]{2}-[\\d]{2}-[A-Z]{1,2}-[\\d]{1,4}$";
    private static Pattern registrationNumberPattern = Pattern.compile(registrationNumberRegex);

    /**
     *
     * @return true/false
     */
    public static boolean isValidRegistrationNumber(final String registrationNumber){
        Matcher matcher = registrationNumberPattern.matcher(registrationNumber.trim());
        return matcher.find();
    }

}
