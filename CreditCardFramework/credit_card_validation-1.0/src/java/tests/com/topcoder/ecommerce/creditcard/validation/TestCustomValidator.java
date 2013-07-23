/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationFormatAllDigits;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test for CustomValidator class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestCustomValidator extends TestCase {
    /**
     * Functional test of CustomValidator(String defaultIdentifier)
     */
    public void testConstructorString() {
        CustomValidator validator = new CustomValidator("test");
        assertEquals("test1", "test", validator.getDefaultIdentifier());
        assertNull("test2", validator.getValidation());
    }

    /**
     * Test CustomValidator(String defaultIdentifier) with null identifier, NullPointerException expected
     */
    public void testConstructorStringWithNullIdentifier() {
        try {
            new CustomValidator(null) {
                };
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test CustomValidator(String defaultIdentifier) with empty identifier, IllegalArgumentException expected
     */
    public void testConstructorStringWithEmptyIdentifier() {
        try {
            new CustomValidator("  ") {
                };
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Functional test of CustomValidator(String defaultIdentifier, ValidationAlgorithm validation)
     */
    public void testConstructorStringValidationAlgorithm() {
        ValidationFormatAllDigits algorithm = new ValidationFormatAllDigits();
        CustomValidator validator = new CustomValidator("test", algorithm);
        assertEquals("test1", "test", validator.getDefaultIdentifier());
        assertEquals("test2", algorithm, validator.getValidation());
    }

    /**
     * Test CustomValidator(String defaultIdentifier, ValidationAlgorithm validation) with null identifier,
     * NullPointerException expected
     */
    public void testConstructorStringValidationAlgorithmWithNullIdentifier() {
        try {
            new CustomValidator(null, new ValidationFormatAllDigits());
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test CustomValidator(String defaultIdentifier, ValidationAlgorithm validation) with empty identifier,
     * IllegalArgumentException expected
     */
    public void testConstructorStringValidationAlgorithmWithEmptyIdentifier() {
        try {
            new CustomValidator("  ", new ValidationFormatAllDigits());
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test CustomValidator(String defaultIdentifier, ValidationAlgorithm validation) with null algorithm,
     * NullPointerException expected
     */
    public void testConstructorStringValidationAlgorithmWithNullAlgorithm() {
        try {
            new CustomValidator("test", null) {
                };
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }
}
