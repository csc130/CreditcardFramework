/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for ValidationNot class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestValidationNot extends TestCase {
    /**
     * Test ValidationNot(ValidationAlgorithm validation) with null left, NullPointerException expected
     */
    public void testConstrutorWithNullValidation() {
        try {
            new ValidationNot(null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Functional test of boolean isValid(String creditCardText)
     */
    public void testIsValid() {
        ValidationNot validation = new ValidationNot(new ValidationFormatAllDigits());
        assertFalse("test1", validation.isValid("123"));
        assertTrue("test2", validation.isValid("12a"));
    }
}
