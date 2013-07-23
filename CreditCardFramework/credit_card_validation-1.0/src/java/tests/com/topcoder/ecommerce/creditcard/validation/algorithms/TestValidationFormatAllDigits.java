/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for ValidationFormatAllDigits class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestValidationFormatAllDigits extends TestCase {
    /**
     * Functional test of boolean isValid(String creditCardText)
     */
    public void testIsValid() {
        ValidationFormatAllDigits validation = new ValidationFormatAllDigits();
        assertTrue("test1", validation.isValid("123"));
        assertFalse("test2", validation.isValid("12a"));

        //null text
        assertFalse("test3", validation.isValid(null));
    }
}
