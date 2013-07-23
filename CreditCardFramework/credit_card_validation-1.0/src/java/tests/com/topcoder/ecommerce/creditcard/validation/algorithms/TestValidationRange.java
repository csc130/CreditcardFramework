/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for ValidationRange class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestValidationRange extends TestCase {
    /** The ValidationRange instance used for test */
    private ValidationRange validation = null;

    /**
     * setup environment
     *
     * @throws Exception if any exception occurs during setup
     */
    protected void setUp() throws Exception {
        this.validation = new ValidationRange("001", "100", 2);
    }

    /**
     * Functional test of ValidationRange(String startPrefix, String endPrefix, int position)
     */
    public void testConstructor() {
        assertEquals("test1", "001", this.validation.getStartPrefix());
        assertEquals("test2", "100", this.validation.getEndPrefix());
        assertEquals("test3", 2, this.validation.getPosition());
    }

    /**
     * Test ValidationRange(String startPrefix, String endPrefix, int position) with equal prefixes, no exception
     * should be thrown
     */
    public void testConstructorWithEqualPrefixes() {
        new ValidationRange("001", "001", 1);
    }

    /**
     * Test ValidationRange(String startPrefix, String endPrefix, int position) with invalid position,
     * IllegalArgumentException expected
     */
    public void testConstructorWithInvalidPosition() {
        try {
            new ValidationRange("001", "100", 0);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test ValidationRange(String startPrefix, String endPrefix, int position) with null start prefix,
     * NullPointerException expected
     */
    public void testConstructorWithNullStartPrefix() {
        try {
            new ValidationRange(null, "100", 2);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test ValidationRange(String startPrefix, String endPrefix, int position) with empty start prefix,
     * IllegalArgumentException expected
     */
    public void testConstructorWithEmptyStartPrefix() {
        try {
            new ValidationRange("   ", "100", 2);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test ValidationRange(String startPrefix, String endPrefix, int position) with null endt prefix,
     * NullPointerException expected
     */
    public void testConstructorWithNullEndPrefix() {
        try {
            new ValidationRange("001", null, 2);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test ValidationRange(String startPrefix, String endPrefix, int position) with empty end prefix,
     * IllegalArgumentException expected
     */
    public void testConstructorWithEmptyEndtPrefix() {
        try {
            new ValidationRange("001", "   ", 2);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test ValidationRange(String startPrefix, String endPrefix, int position) with different prefix length,
     * IllegalArgumentException expected
     */
    public void testConstructorWithDifferentPrefixLength() {
        try {
            new ValidationRange("1", "100", 2);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test ValidationRange(String startPrefix, String endPrefix, int position) with end prefix greater than start
     * prefix, IllegalArgumentException expected
     */
    public void testConstructorWithLargerStartPrefix() {
        try {
            new ValidationRange("100", "001", 2);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Functional test of boolean isValid(String creditCardText)
     */
    public void testIsValid() {
        //valid text
        assertTrue("test1", this.validation.isValid("a001"));
        assertTrue("test2", this.validation.isValid("a050"));
        assertTrue("test3", this.validation.isValid("a10000"));

        //invalid text
        assertFalse("test4", this.validation.isValid("a101"));

        //too short text
        assertFalse("test5", this.validation.isValid("a10"));

        //null text
        assertFalse("test6", this.validation.isValid(null));
    }

    /**
     * Funcational test of int getPosition()
     */
    public void testPosition() {
        assertEquals("test1", 2, this.validation.getPosition());
    }

    /**
     * Funcational test of String getStartPrefix()
     */
    public void testGetStartPrefix() {
        assertEquals("test1", "001", this.validation.getStartPrefix());
    }

    /**
     * Funcational test of String getEndPrefix()
     */
    public void testGetEndPrefix() {
        assertEquals("test1", "100", this.validation.getEndPrefix());
    }
}
