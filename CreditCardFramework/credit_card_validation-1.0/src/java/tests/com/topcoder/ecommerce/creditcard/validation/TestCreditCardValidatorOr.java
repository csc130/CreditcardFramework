/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationFormatAllDigits;
import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationFormatLength;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for CreditCardValidatorOr class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestCreditCardValidatorOr extends TestCase {
    /** The CardValidatorOr instance used for test */
    private CreditCardValidatorOr validator = null;

    /** The left validator instance used for test */
    private CreditCardValidator left = null;

    /** The right validator instance used for test */
    private CreditCardValidator right = null;

    /**
     * setup environment
     *
     * @throws Exception if any exception occurs during setup
     */
    protected void setUp() throws Exception {
        this.left = new CustomValidator("left", new ValidationFormatAllDigits());
        this.right = new CustomValidator("right", new ValidationFormatLength(3));
        this.validator = new CreditCardValidatorOr(left, right);
    }

    /**
     * Test CreditCardValidatorOr(CreditCardValidator left, CreditCardValidator right) with null left,
     * NullPointerException expected
     */
    public void testConstructorWithNullLeft() {
        try {
            new CreditCardValidatorOr(null, this.right) {
                };
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test CreditCardValidatorOr(CreditCardValidator left, CreditCardValidator right) with null right,
     * NullPointerException expected
     */
    public void testConstructorWithNullRight() {
        try {
            new CreditCardValidatorOr(this.left, null) {
                };
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Functional test of boolean isValid(String creditCardText)
     */
    public void testIsValid() {
        assertTrue("test1", this.validator.isValid("123"));
        assertTrue("test2", this.validator.isValid("1234"));
        assertTrue("test3", this.validator.isValid("12a"));
        assertFalse("test4", this.validator.isValid("1a"));
        assertFalse("test5", this.validator.isValid("1a45"));
    }
}
