/**
 * Copyright (c) 2004, TopCoder, Inc. All rights reserved
 */
package com.topcoder.ecommerce.creditcard.validation.failuretests;

import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationRange;

import junit.framework.TestCase;

/**
 * <p>Description: This is a failure test suite for ValidationPrefix.java. It
 * uses null and empty string as inputs, NPE and IAE are expected to be thrown,
     * respectively. In addition, startfix and endfix with different lengths, larger
 * startfix and smaller endfix are tested</p>
 *
 * @author jfjiang
 * @version 1.0
 */
public class ValidationRangeTests
    extends TestCase {
    /**
     * test ValidationRange using null as input
     */
    public void testConstructorNPE1() {
        try {
            new ValidationRange(null, "10", 1);
            fail("a NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test ValidationRange using null as input
     */
    public void testConstructorNPE2() {
        try {
            new ValidationRange("10", null, 1);
            fail("a NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test ValidationRange using null as input
     */
    public void testConstructorNPE3() {
        try {
            new ValidationRange(null, null, 1);
            fail("a NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test ValidationRange using 0 as pos
     */
    public void testConstructorIAE1() {
        try {
            new ValidationRange("1", "9", 0);
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException iae) {
            //pass
        }
    }

    /**
     * test ValidationRange using empty string as input
     */
    public void testConstructorIAE2() {
        try {
            new ValidationRange("", "9", 1);
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException iae) {
            //pass
        }
    }

    /**
     * test ValidationRange using empty string as input
     */
    public void testConstructorIAE3() {
        try {
            new ValidationRange("", "", 1);
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException iae) {
            //pass
        }
    }

    /**
     * test ValidationRange using empty string as input
     */
    public void testConstructorIAE4() {
        try {
            new ValidationRange("1", "", 1);
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException iae) {
            //pass
        }
    }

    /**
     * test ValidationRange using startfix that is larger and endfix
     */
    public void testConstructorIAE5() {
        try {
            new ValidationRange("6", "5", 1);
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException iae) {
            //pass
        }
    }

    /**
     * test ValidationRange using startfix that has different length with endfix
     */
    public void testConstructorIAE6() {
        try {
            new ValidationRange("6", "61", 1);
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException iae) {
            //pass
        }
    }

}