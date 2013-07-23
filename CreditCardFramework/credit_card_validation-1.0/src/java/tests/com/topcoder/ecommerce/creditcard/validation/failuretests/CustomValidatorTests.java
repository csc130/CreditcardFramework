/**
 * Copyright (c) 2004, TopCoder, Inc. All rights reserved
 */
package com.topcoder.ecommerce.creditcard.validation.failuretests;

import com.topcoder.ecommerce.creditcard.validation.algorithms.
    ValidationAlgorithm;
import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationLUHN;
import com.topcoder.ecommerce.creditcard.validation.CustomValidator;

import junit.framework.TestCase;

/**
 * <p>Description: This is a failure test suite for CustonValidator.java</p>
 *
 * @author jfjiang
 * @version 1.0
 */

public class CustomValidatorTests
    extends TestCase {

    /**
     * test constructor using null as input
     */
    public void testConstructorNPE1() {
        try {
            new CustomValidator(null);
            fail("a NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test constructor using null as input
     */
    public void testConstructorNPE2() {
        try {
            new CustomValidator(null, new ValidationLUHN());
            fail("a NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test constructor using null as input
     */
    public void testConstructorNPE3() {
        try {
            new CustomValidator(null, null);
            fail("a NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test constructor using null as input
     */
    public void testConstructorNPE4() {
        try {
            new CustomValidator("test", null);
            fail("a NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test constructor using empty string as input
     */
    public void testConstructorIAE1() {
        try {
            new CustomValidator("");
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException iae) {
            //pass
        }
    }

    /**
     * test constructor using empty string as input
     */
    public void testConstructorIAE2() {
        try {
            new CustomValidator("", new ValidationLUHN());
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException iae) {
            //pass
        }
    }

}