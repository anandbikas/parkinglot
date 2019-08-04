/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.parkinglot.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validation utility.
 */
public class Validation {

    // KA-01-HH-1234
    private static String registrationNumberRegex = "^[A-Za-z]{2}-[\\d]{2}-[A-Za-z]{1,2}-[\\d]{1,4}$";
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
