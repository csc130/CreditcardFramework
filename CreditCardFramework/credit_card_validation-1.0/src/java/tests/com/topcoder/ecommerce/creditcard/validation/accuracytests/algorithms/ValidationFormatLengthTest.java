/*
 * ComponentName: CreditCardValidation
 * FileName: ValidationFormatLengthTest.java
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
 * This class contains the accuracy unit tests for ValidationFormatLength.java</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class ValidationFormatLengthTest extends TestCase {

    /**
     * <p>
     * Represents an instance of ValidationFormatLength to be used for testing.</p>
     */
    private ValidationFormatLength validateLen1 = new ValidationFormatLength(1);
    
    /**
     * <p>
     * Represents an instance of ValidationFormatLength to be used for testing.</p>
     */
    private ValidationFormatLength validateLen10 = new ValidationFormatLength(10);

    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public ValidationFormatLengthTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(ValidationFormatLengthTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the constructor ValidationFormatLength(int length)</p>
     *
     */
    public void testConstructorAccuracy() {
        assertNotNull(this.validateLen10);
    } // end testConstructorAccuracy()

    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText)</p>
     *
     */
    public void testIsValidAccuracy1() {
        assertTrue(validateLen1.isValid("2"));
        assertTrue(validateLen1.isValid("h"));
        assertTrue(validateLen1.isValid("*"));
        
        assertFalse(validateLen1.isValid(""));
        assertFalse(validateLen1.isValid("23"));
    } // end testIsValidAccuracy1()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText)</p>
     *
     */
    public void testIsValidAccuracy2() {
        assertTrue(validateLen10.isValid("1234567890"));
        assertTrue(validateLen10.isValid("dhfimvjfrt"));
        assertTrue(validateLen10.isValid("@#$%$#@!&*"));
        
        assertFalse(validateLen10.isValid(null));
        assertFalse(validateLen10.isValid(""));
        assertFalse(validateLen10.isValid("25684f"));
    } // end testIsValidAccuracy2()

    /**
     *<p>
     * Tests accuracy of the method getLength(). Simply check the len of 
     * validateLen1 and validateLen10.</p>
     *
     */
    public void testGetLengthAccuracy() {
        assertTrue(validateLen1.getLength() == 1);
        assertTrue(validateLen10.getLength() == 10);
    } // end testGetLengthAccuracy()

} // end ValidationFormatLengthTest
