/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for ValidationLUHN class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestValidationLUHN extends TestCase {
    /**
     * Functional test of boolean isValid(String creditCardText)
     */
    public void testIsValid() {
        ValidationLUHN validation = new ValidationLUHN();

        //valid number with odd number of digits
        assertTrue("test1", validation.isValid("0"));
        assertTrue("test2", validation.isValid("125"));
        assertTrue("test3", validation.isValid("12344"));

        //valid number with even number of digits
        assertTrue("test4", validation.isValid("18"));
        assertTrue("test5", validation.isValid("1230"));
        assertTrue("test6", validation.isValid("123455"));

        //valid number consists of digit and non-digit
        assertTrue("test7", validation.isValid("4111 1111 1111 1111"));
        assertTrue("test8", validation.isValid("5500-0000-0000-0004"));
        assertTrue("test9", validation.isValid("a12b345c5d"));

        //null text
        assertFalse("test2", validation.isValid(null));

        //empty text
        //assertTrue("test2", validation.isValid(""));

        //text with no digit
        assertTrue("test2", validation.isValid("abcdefg"));
    }
}
