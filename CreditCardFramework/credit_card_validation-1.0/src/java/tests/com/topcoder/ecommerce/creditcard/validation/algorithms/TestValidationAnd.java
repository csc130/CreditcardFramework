/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for ValidationAnd class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestValidationAnd extends TestCase {
    /**
     * Test ValidationAnd(ValidationAlgorithm left, ValidationAlgorithm right) with null left, NullPointerException
     * expected
     */
    public void testConstrutorWithNullLeft() {
        try {
            new ValidationAnd(null, new ValidationFormatAllDigits());
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test ValidationAnd(ValidationAlgorithm left, ValidationAlgorithm right) with null right, NullPointerException
     * expected
     */
    public void testConstrutorWithNullRight() {
        try {
            new ValidationAnd(new ValidationFormatAllDigits(), null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Functional test of boolean isValid(String creditCardText)
     */
    public void testIsValid() {
        ValidationAnd validation = new ValidationAnd(new ValidationFormatAllDigits(), new ValidationFormatLength(3));
        assertTrue("test1", validation.isValid("123"));
        assertFalse("test2", validation.isValid("12a"));
        assertFalse("test3", validation.isValid("1234"));
    }
}
