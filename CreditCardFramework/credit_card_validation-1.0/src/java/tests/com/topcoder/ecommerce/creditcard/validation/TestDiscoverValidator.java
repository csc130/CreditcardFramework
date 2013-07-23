/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for DiscoverValidator class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestDiscoverValidator extends TestCase {
    /**
     * Test whether the public identifier is correct
     */
    public void testPublicIdentifier() {
        assertEquals("test1", "Discover", DiscoverValidator.IDENTIFIER);
    }

    /**
     * Test whether the constructor creates an DiscoverValidator correctly
     */
    public void testConstructor() {
        DiscoverValidator validator = new DiscoverValidator();

        //valid numbers
        assertTrue("test1", validator.isValid("6011000000000004"));

        //valid prefix & length, but invalid LUHN
        assertFalse("test2", validator.isValid("6011000000000014"));

        //valid LUHN & prefix, but invalid length
        assertFalse("test3", validator.isValid("601100000000000400"));

        //valid LUHN & length, but invalid prefix
        assertFalse("test4", validator.isValid("6012000000000003"));

        //not all digits
        assertFalse("test5", validator.isValid("601100000000000a"));
    }
}
