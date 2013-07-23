/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for VisaValidator class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestVisaValidator extends TestCase {
    /**
     * Test whether the public identifier is correct
     */
    public void testPublicIdentifier() {
        assertEquals("test1", "Visa", VisaValidator.IDENTIFIER);
    }

    /**
     * Test whether the constructor creates an VisaValidator correctly
     */
    public void testConstructor() {
        VisaValidator validator = new VisaValidator();

        //valid numbers with length 13
        assertTrue("test1", validator.isValid("4000000000030"));

        //valid numbers with length 16
        assertTrue("test1", validator.isValid("4111111111111111"));

        //valid prefix & length, but invalid LUHN
        assertFalse("test9", validator.isValid("4111111111111112"));

        //valid LUHN & prefix, but invalid length
        assertFalse("test10", validator.isValid("411111111111111100"));

        //valid LUHN & length, but invalid prefix
        assertFalse("test11", validator.isValid("3111111111111113"));

        //not all digits
        assertFalse("test12", validator.isValid("411111111111111a"));
    }
}
