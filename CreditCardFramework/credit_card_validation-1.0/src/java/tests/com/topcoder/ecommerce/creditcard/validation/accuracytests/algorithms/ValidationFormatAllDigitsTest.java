/*
 * ComponentName: CreditCardValidation
 * FileName: ValidationFormatAllDigitsTest.java
 * Version: 1.0
 * Date: 10/28/2004
 *
 * <p>Copyright (c) 2004, TopCoder, Inc. All rights reserved</p>
 */

package com.topcoder.ecommerce.creditcard.validation.accuracytests.algorithms;

import com.topcoder.ecommerce.creditcard.validation.algorithms.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This class contains the accuracy unit tests for ValidationFormatAllDigits.java</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class ValidationFormatAllDigitsTest extends TestCase {

    /**
     * <p>
     * Represents an instance of ValidationFormatAllDigits to be used for testing.</p>
     */
    private ValidationFormatAllDigits allDigs = new ValidationFormatAllDigits();;

    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public ValidationFormatAllDigitsTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(ValidationFormatAllDigitsTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the constructor ValidationFormatAllDigits(). 
     * Simply check if the instance has been created successfully.</p>
     *
     */
    public void testConstructorAccuracy() {
        assertNotNull("Should be not null", this.allDigs);
    } // end testConstructorAccuracy()

    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * test true cases.</p>
     *
     */
    public void testIsValidAccuracy1() {
        // test true case
        assertTrue(allDigs.isValid("1"));
        assertTrue(allDigs.isValid("456786878989"));
        assertTrue(allDigs.isValid("846843519846845"));
    } // end testIsValidAccuracy1()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * test false casees</p>
     *
     */
    public void testIsValidAccuracy2() {
        // test false case
        assertFalse(allDigs.isValid(null));
        assertFalse(allDigs.isValid("1542*46567657"));
        assertFalse(allDigs.isValid("154246567d657"));
        assertFalse(allDigs.isValid("154246567=657"));
        // 
    } // end testIsValidAccuracy2()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * test empty casees</p>
     *
     */
    public void testIsValidAccuracy_empty() {
        // test false case
        assertFalse(allDigs.isValid(""));
    } // end testIsValidAccuracy2()

} // end ValidationFormatAllDigitsTest
