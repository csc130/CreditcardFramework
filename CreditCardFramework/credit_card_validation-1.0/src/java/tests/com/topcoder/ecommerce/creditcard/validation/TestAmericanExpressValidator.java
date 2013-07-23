/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for AmericanExpressValidator class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestAmericanExpressValidator extends TestCase {
    /**
     * Test whether the public identifier is correct
     */
    public void testPublicIdentifier() {
        assertEquals("test1", "AmericanExpress", AmericanExpressValidator.IDENTIFIER);
    }

    /**
     * Test whether the constructor creates an AmericanExpressValidator correctly
     */
    public void testConstructor() {
        AmericanExpressValidator validator = new AmericanExpressValidator();

        //valid numbers with prefix 34
        assertTrue("test1", validator.isValid("340000000000009"));
        assertTrue("test2", validator.isValid("340200000000039"));

        //valid numbers with prefix 37
        assertTrue("test3", validator.isValid("370000000006009"));
        assertTrue("test4", validator.isValid("371000000006909"));
        assertTrue("test5", validator.isValid("371700000006979"));
        assertTrue("test6", validator.isValid("371701000406979"));
        assertTrue("test7", validator.isValid("371761020406979"));
        assertTrue("test8", validator.isValid("371761122476979"));

        //valid prefix & length, but invalid LUHN
        assertFalse("test9", validator.isValid("340000000000001"));

        //valid LUHN & prefix, but invalid length
        assertFalse("test10", validator.isValid("34000000000000900"));

        //valid LUHN & length, but invalid prefix
        assertFalse("test11", validator.isValid("350000000000099"));

        //not all digits
        assertFalse("test12", validator.isValid("35000000000009a"));
    }
}
