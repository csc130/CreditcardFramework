/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for DinersClubValidator class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestDinersClubValidator extends TestCase {
    /**
     * Test whether the public identifier is correct
     */
    public void testPublicIdentifier() {
        assertEquals("test1", "DinersClub", DinersClubValidator.IDENTIFIER);
    }

    /**
     * Test whether the constructor creates an DinersClubValidator correctly
     */
    public void testConstructor() {
        DinersClubValidator validator = new DinersClubValidator();

        //valid numbers with prefix 300
        assertTrue("test1", validator.isValid("30000000000004"));

        //valid numbers with prefix 301
        assertTrue("test2", validator.isValid("30100000000044"));

        //valid numbers with prefix 302
        assertTrue("test3", validator.isValid("30200000000034"));

        //valid numbers with prefix 303
        assertTrue("test4", validator.isValid("30300000000024"));

        //valid numbers with prefix 304
        assertTrue("test5", validator.isValid("30400000000014"));

        //valid numbers with prefix 305
        assertTrue("test6", validator.isValid("30500000000094"));

        //valid numbers with prefix 36
        assertTrue("test7", validator.isValid("36000000000024"));

        //valid numbers with prefix 38
        assertTrue("test8", validator.isValid("38000000000014"));

        //valid prefix & length, but invalid LUHN
        assertFalse("test9", validator.isValid("30000000000005"));

        //valid LUHN & prefix, but invalid length
        assertFalse("test10", validator.isValid("3000000000000400"));

        //valid LUHN & length, but invalid prefix
        assertFalse("test11", validator.isValid("31000000000094"));
        assertFalse("test12", validator.isValid("30600000000084"));

        //not all digits
        assertFalse("test13", validator.isValid("3000000000000a"));
    }
}
