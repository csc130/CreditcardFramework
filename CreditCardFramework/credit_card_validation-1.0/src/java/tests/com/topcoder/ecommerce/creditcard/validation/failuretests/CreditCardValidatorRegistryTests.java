/**
 * Copyright (c) 2004, TopCoder, Inc. All rights reserved
 */
package com.topcoder.ecommerce.creditcard.validation.failuretests;

import com.topcoder.ecommerce.creditcard.validation.CreditCardValidatorRegistry;
import com.topcoder.ecommerce.creditcard.validation.CustomValidator;

import junit.framework.TestCase;

/**
     * <p>Description: A failure test suite for CreditCardValidatorRegistry.java</p>
 *
 * @author jfjiang
 * @version 1.0
 */

public class CreditCardValidatorRegistryTests
    extends TestCase {

    /**
     * test instance
     */
    private CreditCardValidatorRegistry registry = null;

    /**
     * set up test environment
     */
    protected void setUp() {
        try {
            registry = new CreditCardValidatorRegistry(false);
        }
        catch (Exception e) {
            fail("unexpected exception" + e.toString());
        }
    }

    /**
     * test addCreditCardValidator using null as input
     */
    public void testAddCreditCardValidatorNPE1() {
        try {
            registry.addCreditCardValidator(null);
            fail("NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test addCreditCardValidator using null as input
     */
    public void testAddCreditCardValidatorNPE2() {
        try {
            registry.addCreditCardValidator(null, new CustomValidator("test"));
            fail("NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test addCreditCardValidator using null as input
     */
    public void testAddCreditCardValidatorNPE3() {
        try {
            registry.addCreditCardValidator(null, null);
            fail("NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test addCreditCardValidator using null as input
     */
    public void testAddCreditCardValidatorNPE4() {
        try {
            registry.addCreditCardValidator("test", null);
            fail("NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test addCreditCardValidator using empty string as input
     */
    public void testAddCreditCardValidatorIAE1() {
        try {
            registry.addCreditCardValidator("", new CustomValidator("test"));
            fail("IAE is expected");
        }
        catch (IllegalArgumentException iae) {
            //pass
        }
    }

    /**
     * test getCreditCardValidator using null as input
     */
    public void testGetCreditCardValidatorNPE1() {
        try {
            registry.getCreditCardValidator(null);
            fail("NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test getCreditCardValidator using empty as input
     */
    public void testGetCreditCardValidatorIAE1() {
        try {
            registry.getCreditCardValidator("");
            fail("IAE is expected");
        }
        catch (IllegalArgumentException iae) {
            //pass
        }
    }

    /**
     * test removeCreditCardValidator using null as input
     */
    public void testRemoveCreditCardValidatorNPE1() {
        try {
            registry.removeCreditCardValidator(null);
            fail("NPE is expected");
        }
        catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     * test removeCreditCardValidator using null as input
     */
    public void testRemoveCreditCardValidatorIAE1() {
        try {
            registry.removeCreditCardValidator("");
            fail("IAE is expected");
        }
        catch (IllegalArgumentException iae) {
            //pass
        }
    }

}