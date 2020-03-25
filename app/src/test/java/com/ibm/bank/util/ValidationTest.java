package com.ibm.bank.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationTest {

    @Test
    public void checkUserWithCPFValid() {
        assertTrue(Validation.checkUserLogin("12345678975"));
    }

    @Test
    public void checkUserWithoutCPFValid() {
        assertFalse(Validation.checkUserLogin("1234567897"));
        assertFalse(Validation.checkUserLogin("123456789758"));
    }

    @Test
    public void checkUserWithEmailValid() {
        assertTrue(Validation.checkUserLogin("marcos@gmail.com"));
        assertTrue(Validation.checkUserLogin("marcos@gmail.com.br"));
    }

    @Test
    public void checkUserWithoutEmailValid() {
        assertFalse(Validation.checkUserLogin("marcosgmail.com"));
        assertFalse(Validation.checkUserLogin("marcos@gmail.com."));
        assertFalse(Validation.checkUserLogin("marcos@gmail"));
        assertFalse(Validation.checkUserLogin("marcos@gmail.br"));
    }

    @Test
    public void checkPasswordWithoutMinimumRequirements() {
        assertFalse(Validation.checkPasswordLogin("abc123#"));
        assertFalse(Validation.checkPasswordLogin("aBc123"));
    }

    @Test
    public void checkPasswordWithMinimumRequirements() {
        assertTrue(Validation.checkPasswordLogin("Spring#123"));
        assertTrue(Validation.checkPasswordLogin("sprinG@123"));
    }
}