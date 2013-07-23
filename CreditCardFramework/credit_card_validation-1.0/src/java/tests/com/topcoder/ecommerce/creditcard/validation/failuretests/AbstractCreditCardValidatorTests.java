/**
 * Copyright (c) 2004, TopCoder, Inc. All rights reserved
 */
package com.topcoder.ecommerce.creditcard.validation.failuretests;

import com.topcoder.ecommerce.creditcard.validation.AbstractCreditCardValidator;
import com.topcoder.ecommerce.creditcard.validation.algorithms.
    ValidationAlgorithm;
import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationLUHN;

import junit.framework.TestCase;

/**
 * <p>Description: This is a failure test for AbstractCreditCardValidator.java
 * </p>
 *
 * @author jfjiang
 * @version 1.0
 */

public class AbstractCreditCardValidatorTests
    extends TestCase {

    /**
     * test instance
     */
    private SimpleCreditCardValidator validator = null;

    /**
     * set uo test environment
     */
    protected void setUp() {
        validator = new SimpleCreditCardValidator("test");
    }

    /**
     * using null as constructor's input
     */
    public void testConstructorNPE1() {
        try {
            new SimpleCreditCardValidator(null);
            fail("an NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * using null as constructor's input
     */
    public void testConstructorNPE2() {
        try {
            new SimpleCreditCardValidator(null, new ValidationLUHN());
            fail("an NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * using null as constructor's input
     */
    public void testConstructorNPE3() {
        try {
            new SimpleCreditCardValidator("test", null);
            fail("an NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * using empty string as constructor's input
     */
    public void testConstructorIAE1() {
        try {
            new SimpleCreditCardValidator("");
            fail("an IAE is expected");
        }
        catch (IllegalArgumentException npe) {
            //pass
        }
    }

    /**
     * using empty string as constructor's input
     */
    public void testConstructorIAE2() {
        try {
            new SimpleCreditCardValidator("", new ValidationLUHN());
            fail("an IAE is expected");
        }
        catch (IllegalArgumentException npe) {
            //pass
        }
    }

    /**
     * using null as validator.or()'s input
     */
    public void testOrNPE1() {
        try {
            validator.or(null);
            fail("an NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }


    /**
     * <p>Description: a simple implemenmtation of AbstractCreditCardValidator
     * </p>
     */
    private class SimpleCreditCardValidator
        extends AbstractCreditCardValidator {
                public SimpleCreditCardValidator(String str) {
            super(str);
        }

        public SimpleCreditCardValidator(String str, ValidationAlgorithm va) {
            super(str, va);
        }
    }
}
