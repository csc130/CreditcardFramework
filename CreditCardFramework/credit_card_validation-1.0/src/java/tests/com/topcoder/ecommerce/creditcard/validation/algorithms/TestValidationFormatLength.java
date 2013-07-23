/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for ValidationFormatLength class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestValidationFormatLength extends TestCase {
    /**
     * Functional test of ValidationFormatLength(int length)
     */
    public void testConstrutor() {
        assertEquals("test1", 3, new ValidationFormatLength(3).getLength());
    }

    /**
     * Test ValidationFormatLength(int length) with invalid length, IllegalArgumentException expected
     */
    public void testConstrutorWithInvalidLength() {
        try {
            new ValidationFormatLength(0);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Functional test of boolean isValid(String creditCardText)
     */
    public void testIsValid() {
        ValidationFormatLength validation = new ValidationFormatLength(3);
        assertTrue("test1", validation.isValid("123"));
        assertFalse("test2", validation.isValid("123a"));

        //null text
        assertFalse("test3", validation.isValid(null));
    }

    /**
     * Functional test of int getLength()
     */
    public void testGetLength() {
        assertEquals("test1", 3, new ValidationFormatLength(3).getLength());
    }
}
