/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationAlgorithm;
import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationFormatAllDigits;
import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationFormatLength;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for AbstractCreditCardValidator class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestAbstractCreditCardValidator extends TestCase {
    /** The AbstractCreditCardValidator instance used for test */
    private AbstractCreditCardValidator validator = null;

    /** The ValidationAlgorithm instance used for test */
    private ValidationAlgorithm algorithm = null;

    /**
     * setup environment
     *
     * @throws Exception if any exception occurs during setup
     */
    protected void setUp() throws Exception {
        this.algorithm = new ValidationFormatAllDigits();
        this.validator = new AbstractCreditCardValidator("test") {
                };
    }

    /**
     * Functional test of AbstractCreditCardValidator(String defaultIdentifier)
     */
    public void testConstructorString() {
        this.validator = new AbstractCreditCardValidator("test") {
                };
        assertEquals("test1", "test", this.validator.getDefaultIdentifier());
        assertNull("test2", this.validator.getValidation());
    }

    /**
     * Test AbstractCreditCardValidator(String defaultIdentifier) with null identifier, NullPointerException expected
     */
    public void testConstructorStringWithNullIdentifier() {
        try {
            new AbstractCreditCardValidator(null) {
                };
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test AbstractCreditCardValidator(String defaultIdentifier) with empty identifier, IllegalArgumentException
     * expected
     */
    public void testConstructorStringWithEmptyIdentifier() {
        try {
            new AbstractCreditCardValidator("  ") {
                };
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Functional test of AbstractCreditCardValidator(String defaultIdentifier, ValidationAlgorithm validation)
     */
    public void testConstructorStringValidationAlgorithm() {
        this.validator = new AbstractCreditCardValidator("test", this.algorithm) {
                };
        assertEquals("test1", "test", this.validator.getDefaultIdentifier());
        assertEquals("test2", this.algorithm, this.validator.getValidation());
    }

    /**
     * Test AbstractCreditCardValidator(String defaultIdentifier, ValidationAlgorithm validation) with null identifier,
     * NullPointerException expected
     */
    public void testConstructorStringValidationAlgorithmWithNullIdentifier() {
        try {
            new AbstractCreditCardValidator(null, this.algorithm) {
                };
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test AbstractCreditCardValidator(String defaultIdentifier, ValidationAlgorithm validation) with empty
     * identifier, IllegalArgumentException expected
     */
    public void testConstructorStringValidationAlgorithmWithEmptyIdentifier() {
        try {
            new AbstractCreditCardValidator("  ", this.algorithm) {
                };
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test AbstractCreditCardValidator(String defaultIdentifier, ValidationAlgorithm validation) with null algorithm,
     * NullPointerException expected
     */
    public void testConstructorStringValidationAlgorithmWithNullAlgorithm() {
        try {
            new AbstractCreditCardValidator("test", null) {
                };
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Functional test of void setValidation(ValidationAlgorithm algorithm)
     */
    public void testSetValidation() {
        this.validator.setValidation(this.algorithm);
        assertEquals("test1", this.algorithm, this.validator.getValidation());
    }

    /**
     * Functional test of ValidationAlgorithm getValidation()
     */
    public void testGetValidation() {
        assertNull("test1", this.validator.getValidation());
        this.validator.setValidation(this.algorithm);
        assertEquals("test2", this.algorithm, this.validator.getValidation());
    }

    /**
     * Test isValid(String creditCardText) without algorithm set, should always return true
     */
    public void testIsValidWithNullAlgorithm() {
        //normal text
        assertTrue("test1", this.validator.isValid("test"));

        //null text
        assertTrue("test2", this.validator.isValid(null));

        //empty text
        assertTrue("test3", this.validator.isValid(""));
    }

    /**
     * Test isValid(String creditCardText) with algorithm set as ValidationFormatAllDigits
     */
    public void testIsValidWithValidationFormatAllDigits() {
        //set the algorithm
        this.validator.setValidation(this.algorithm);

        //valid text
        assertTrue("test1", this.validator.isValid("12345"));

        //invalid text
        assertFalse("test2", this.validator.isValid("abc"));
        assertFalse("test3", this.validator.isValid("1234a"));
        assertFalse("test4", this.validator.isValid("1234 "));
    }

    /**
     * Functional test of String getDefaultIdentifier()
     */
    public void testGetDefaultIdentifier() {
        assertEquals("test1", "test", this.validator.getDefaultIdentifier());
    }

    /**
     * Functional test of AbstractCreditCardValidator or(CreditCardValidator other)
     */
    public void testOr() {
        this.validator = new AbstractCreditCardValidator("left", new ValidationFormatAllDigits()) {
                }.or(new AbstractCreditCardValidator("right", new ValidationFormatLength(3)) {
                });
        assertTrue("test1", this.validator.isValid("123"));
        assertTrue("test2", this.validator.isValid("1234"));
        assertTrue("test3", this.validator.isValid("12a"));
        assertFalse("test4", this.validator.isValid("1a"));
        assertFalse("test5", this.validator.isValid("1a45"));
    }
}
