/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for MasterCardValidator class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestMasterCardValidator extends TestCase {
    /**
     * Test whether the public identifier is correct
     */
    public void testPublicIdentifier() {
        assertEquals("test1", "MasterCard", MasterCardValidator.IDENTIFIER);
    }

    /**
     * Test whether the constructor creates an MasterCardValidator correctly
     */
    public void testConstructor() {
        MasterCardValidator validator = new MasterCardValidator();

        //valid numbers with prefix 51
        assertTrue("test1", validator.isValid("5100000000000008"));

        //valid numbers with prefix 52
        assertTrue("test2", validator.isValid("5200000000000007"));

        //valid numbers with prefix 53
        assertTrue("test3", validator.isValid("5300000000000006"));

        //valid numbers with prefix 54
        assertTrue("test4", validator.isValid("5400000000000005"));

        //valid numbers with prefix 55
        assertTrue("test5", validator.isValid("5500000000000004"));

        //valid prefix & length, but invalid LUHN
        assertFalse("test6", validator.isValid("5100000000000007"));

        //valid LUHN & prefix, but invalid length
        assertFalse("test7", validator.isValid("510000000000000800"));

        //valid LUHN & length, but invalid prefix
        assertFalse("test8", validator.isValid("4900000000000003"));
        assertFalse("test9", validator.isValid("5600000000000003"));

        //not all digits
        assertFalse("test10", validator.isValid("510000000000000a"));
    }
}
