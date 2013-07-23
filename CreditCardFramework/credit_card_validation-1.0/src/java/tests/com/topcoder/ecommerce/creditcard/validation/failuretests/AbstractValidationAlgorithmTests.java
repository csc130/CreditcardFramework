/**
 * Copyright (c) 2004, TopCoder, Inc. All rights reserved
 */
package com.topcoder.ecommerce.creditcard.validation.failuretests;

import com.topcoder.ecommerce.creditcard.validation.algorithms.
    AbstractValidationAlgorithm;

import junit.framework.TestCase;

/**
 * <p>Description: This Test Suite test AbstractValidationAlgorithm.class using
 * null as input. NullPointerException is expected</p>
 *
 * @author jfjiang
 * @version 1.0
 */

public class AbstractValidationAlgorithmTests
    extends TestCase {
    /**
     * test instance
     */
    private SimpleValidationAlgorithm ava = null;

    /**
     * set up test environment
     */
    protected void setUp() {
        ava = new SimpleValidationAlgorithm();
    }

    /**
     * test add method using null as input
     */
    public void testAddFailure1() {
        try {
            ava.and(null);
            fail("a NPE is expected");
        } catch (NullPointerException npe)
        {
            //pass
        }
    }

    /**
     * test or method using null as input
     */
    public void testOrFailure1()
    {
        try {
            ava.or(null);
            fail("a NPE is expected");
        } catch (NullPointerException npe) {
            //pass
        }
    }

    /**
     *  a simple extention of AbstractValidationAlgorithm, used for test only
     */
    private class SimpleValidationAlgorithm
        extends AbstractValidationAlgorithm {
        public boolean isValid(String creditCardText) {
            return true;
        }
    }

}