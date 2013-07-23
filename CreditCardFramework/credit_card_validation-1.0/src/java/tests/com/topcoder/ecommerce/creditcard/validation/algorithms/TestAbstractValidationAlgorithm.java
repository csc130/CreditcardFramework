/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for AbstractValidationAlgorithm class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestAbstractValidationAlgorithm extends TestCase {
    /** The AbstractValidationAlgorithm instance used for test */
    private AbstractValidationAlgorithm algorithm = null;

    /**
     * setup environment
     *
     * @throws Exception if any exception occurs during setup
     */
    protected void setUp() throws Exception {
        this.algorithm = new ValidationFormatAllDigits();
    }

    /**
     * Functional test of AbstractValidationAlgorithm and(ValidationAlgorithm other)
     */
    public void testAnd() {
        this.algorithm = this.algorithm.and(new ValidationFormatLength(3));
        assertTrue("test1", this.algorithm.isValid("123"));
        assertFalse("test2", this.algorithm.isValid("12a"));
        assertFalse("test3", this.algorithm.isValid("1234"));
    }

    /**
     * Functional test of AbstractValidationAlgorithm and(ValidationAlgorithm other) with null algorithm,
     * NullPointerException expected
     */
    public void testAndWithNullAlgorithm() {
        try {
            this.algorithm.and(null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Functional test of AbstractValidationAlgorithm or(ValidationAlgorithm other)
     */
    public void testOr() {
        this.algorithm = this.algorithm.or(new ValidationFormatLength(3));
        assertTrue("test1", this.algorithm.isValid("123"));
        assertTrue("test2", this.algorithm.isValid("12a"));
        assertTrue("test3", this.algorithm.isValid("1234"));
        assertFalse("test4", this.algorithm.isValid("123a"));
    }

    /**
     * Functional test of AbstractValidationAlgorithm or(ValidationAlgorithm other) with null algorithm,
     * NullPointerException expected
     */
    public void testOrWithNullAlgorithm() {
        try {
            this.algorithm.or(null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Functional test of AbstractValidationAlgorithm not()
     */
    public void testNot() {
        this.algorithm = this.algorithm.not();
        assertFalse("test1", this.algorithm.isValid("123"));
        assertTrue("test2", this.algorithm.isValid("12a"));
    }
}
