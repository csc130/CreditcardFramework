/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for ValidationPrefix class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestValidationPrefix extends TestCase {
    /**
     * Test whether the public identifiers are correct
     */
    public void testPublicIdentifier() {
        assertEquals("test1", "0", ValidationPrefix.MII_OTHER);
        assertEquals("test1", "1", ValidationPrefix.MII_AIRLINES);
        assertEquals("test1", "2", ValidationPrefix.MII_AIRLINES_OTHER);
        assertEquals("test1", "3", ValidationPrefix.MII_TRAVEL_ENT);
        assertEquals("test1", "4", ValidationPrefix.MII_BANKING1);
        assertEquals("test1", "5", ValidationPrefix.MII_BANKING2);
        assertEquals("test1", "6", ValidationPrefix.MII_MERCHANDIZING);
        assertEquals("test1", "7", ValidationPrefix.MII_PETROLEUM);
        assertEquals("test1", "8", ValidationPrefix.MII_TELECOMMUNICATIONS);
        assertEquals("test1", "9", ValidationPrefix.MII_NATIONAL);
    }

    /**
     * Functional test of ValidationPrefix(String prefix)
     */
    public void testConstrutorString() {
        ValidationPrefix validation = new ValidationPrefix("test");
        assertEquals("test1", "test", validation.getStartPrefix());
        assertEquals("test2", "test", validation.getEndPrefix());
        assertEquals("test3", 1, validation.getPosition());
    }

    /**
     * Test ValidationPrefix(String prefix) with null prefix, NullPointerException expected
     */
    public void testConstructorStringWithNullPrefix() {
        try {
            new ValidationPrefix(null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test ValidationPrefix(String prefix) with empty prefix, IllegalArgumentException expected
     */
    public void testConstructorStringWithEmptyPrefix() {
        try {
            new ValidationPrefix("   ");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Functional test of ValidationPrefix(String startPrefix, String endPrefix)
     */
    public void testConstrutorStringString() {
        ValidationPrefix validation = new ValidationPrefix("a", "b");
        assertEquals("test1", "a", validation.getStartPrefix());
        assertEquals("test2", "b", validation.getEndPrefix());
        assertEquals("test3", 1, validation.getPosition());
    }

    /**
     * Test ValidationPrefix(String startPrefix, String endPrefix, int position) with equal prefixes, no exception
     * should be thrown
     */
    public void testConstructorStringStringWithEqualPrefixes() {
        new ValidationPrefix("001", "001");
    }

    /**
     * Test ValidationPrefix(String startPrefix, String endPrefix, int position) with null start prefix,
     * NullPointerException expected
     */
    public void testConstructorStringStringWithNullStartPrefix() {
        try {
            new ValidationPrefix(null, "100");
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test ValidationPrefix(String startPrefix, String endPrefix, int position) with empty start prefix,
     * IllegalArgumentException expected
     */
    public void testConstructorStringStringWithEmptyStartPrefix() {
        try {
            new ValidationPrefix("   ", "100");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test ValidationPrefix(String startPrefix, String endPrefix, int position) with null endt prefix,
     * NullPointerException expected
     */
    public void testConstructorStringStringWithNullEndPrefix() {
        try {
            new ValidationPrefix("001", null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test ValidationPrefix(String startPrefix, String endPrefix, int position) with empty end prefix,
     * IllegalArgumentException expected
     */
    public void testConstructorStringStringWithEmptyEndtPrefix() {
        try {
            new ValidationPrefix("001", "   ");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test ValidationPrefix(String startPrefix, String endPrefix, int position) with different prefix length,
     * IllegalArgumentException expected
     */
    public void testConstructorStringStringWithDifferentPrefixLength() {
        try {
            new ValidationPrefix("1", "100");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test ValidationPrefix(String startPrefix, String endPrefix, int position) with end prefix greater than start
     * prefix, IllegalArgumentException expected
     */
    public void testConstructorStringStringWithLargerStartPrefix() {
        try {
            new ValidationPrefix("100", "001");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }
}
