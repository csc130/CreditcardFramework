/**
 * Copyright (c) 2004, TopCoder, Inc. All rights reserved
 */
package com.topcoder.ecommerce.creditcard.validation.failuretests;

import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationPrefix;

import junit.framework.TestCase;

/**
 * <p>Description: This is a failure test suite for ValidationPrefix.java. It
 * uses null and empty string as inputs, NPE and IAE are expected to be thrown,
 * respectively</p>
 *
 * @author jfjiang
 * @version 1.0
 */

public class ValidationPrefixTests
    extends TestCase {
    /**
     * test ValidationPrefix(String prefix) using null as input
     */
    public void testConstructorNPE1() {
        try {
            new ValidationPrefix(null);
            fail("a NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test ValidationPrefix(String prefix) using empty string as input
     */
    public void testConstructorIAE1() {
        try {
            new ValidationPrefix("");
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException npe) {
            //pass
        }
    }

    /**
         * test ValidationPrefix(String stratFix, String endFix) using null as input
     */
    public void testConstructorNPE2() {
        try {
            new ValidationPrefix(null, "1");
            fail("a NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
         * test ValidationPrefix(String stratFix, String endFix) using null as input
     */
    public void testConstructorNPE3() {
        try {
            new ValidationPrefix("1", null);
            fail("a NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
         * test ValidationPrefix(String stratFix, String endFix) using null as input
     */
    public void testConstructorNPE4() {
        try {
            new ValidationPrefix(null, null);
            fail("a NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test ValidationPrefix(String startfix, String endfix) using empty string as input
     */
    public void testConstructorIAE2() {
        try {
            new ValidationPrefix("", "1");
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException npe) {
            //pass
        }
    }

    /**
     * test ValidationPrefix(String startfix, String endfix) using empty string as input
     */
    public void testConstructorIAE3() {
        try {
            new ValidationPrefix("1", "");
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException npe) {
            //pass
        }
    }

    /**
     * test ValidationPrefix(String startfix, String endfix) using empty string as input
     */
    public void testConstructorIAE4() {
        try {
            new ValidationPrefix("", "");
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException npe) {
            //pass
        }
    }

    /**
     * test ValidationPrefix(String startfix, String endfix) using start prefix is
     * greater than end prefix when compared
     */
    public void testConstructorIAE5() {
        try {
            new ValidationPrefix("2", "1");
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException npe) {
            //pass
        }
    }

    /**
     * test ValidationPrefix(String startfix, String endfix) using start prefix
     * that has different length with end Prefix
     */
    public void testConstructorIAE6() {
        try {
            new ValidationPrefix("1","12");
            fail("a IAE is expected");
        }
        catch (IllegalArgumentException npe) {
            //pass
        }
    }
}