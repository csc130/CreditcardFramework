/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for ValidationOr class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestValidationOr extends TestCase {
    /**
     * Test ValidationOr(ValidationAlgorithm left, ValidationAlgorithm right) with null left, NullPointerException
     * expected
     */
    public void testConstrutorWithNullLeft() {
        try {
            new ValidationOr(null, new ValidationFormatAllDigits());
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test ValidationOr(ValidationAlgorithm left, ValidationAlgorithm right) with null right, NullPointerException
     * expected
     */
    public void testConstrutorWithNullRight() {
        try {
            new ValidationOr(new ValidationFormatAllDigits(), null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Functional test of boolean isValid(String creditCardText)
     */
    public void testIsValid() {
        ValidationOr validation = new ValidationOr(new ValidationFormatAllDigits(), new ValidationFormatLength(3));
        assertTrue("test1", validation.isValid("123"));
        assertTrue("test2", validation.isValid("12a"));
        assertTrue("test3", validation.isValid("1234"));
        assertFalse("test4", validation.isValid("123a"));
    }
}
