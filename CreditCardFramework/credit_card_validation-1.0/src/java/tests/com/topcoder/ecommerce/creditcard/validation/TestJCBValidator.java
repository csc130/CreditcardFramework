/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for JCBValidator class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestJCBValidator extends TestCase {
    /**
     * Test whether the public identifier is correct
     */
    public void testPublicIdentifier() {
        assertEquals("test1", "JCB", JCBValidator.IDENTIFIER);
    }

    /**
     * Test whether the constructor creates an JCBValidator correctly
     */
    public void testConstructor() {
        JCBValidator validator = new JCBValidator();

        //valid numbers with prefix 3
        assertTrue("test1", validator.isValid("3088000000000009"));

        //valid numbers with prefix 2131
        assertTrue("test3", validator.isValid("213100000000001"));

        //valid numbers with prefix 1800
        assertTrue("test3", validator.isValid("180000000000002"));

        //valid prefix & length, but invalid LUHN
        assertFalse("test4", validator.isValid("3088000000000000"));

        //valid LUHN & prefix, but invalid length
        assertFalse("test5", validator.isValid("308800000000000900"));

        //valid LUHN & length, but invalid prefix
        assertFalse("test6", validator.isValid("4088000000000007"));

        //not all digits
        assertFalse("test7", validator.isValid("308800000000000a"));
    }
}
