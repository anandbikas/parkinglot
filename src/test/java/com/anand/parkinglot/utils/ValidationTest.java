package com.anand.parkinglot.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ValidationTest {

    final String validRegistrationNumber = "KA-01-HH-9999";
    final String invalidRegistrationNumber = "KA-01-HH-INVALID";

    @Test
    public void testValidRegistrationNumber(){
        Assert.assertTrue(Validation.isValidRegistrationNumber(validRegistrationNumber));
    }

    @Test
    public void testInvalidRegistrationNumber(){
        Assert.assertFalse(Validation.isValidRegistrationNumber(invalidRegistrationNumber));
    }
}
