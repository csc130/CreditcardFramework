/*
 * ComponentName: CreditCardValidation
 * FileName: ValidationLUHNTest.java
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
 * This class contains the accuracy unit tests for ValidationLUHN.java</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class ValidationLUHNTest extends TestCase {

    /**
     * <p>
     * Represents an instance of ValidationLUHN to be used for testing.</p>
     */
    private ValidationLUHN luhn = new ValidationLUHN();

    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public ValidationLUHNTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(ValidationLUHNTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the constructor ValidationLUHN(). Simply check if 
     * the instance has been created.</p>
     *
     */
    public void testConstructorAccuracy() {
        assertNotNull("Should not be null.", this.luhn);
    } // end testConstructorAccuracy()

    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * test true cases.</p>
     *
     */
    public void testIsValidAccuracy1() {
        assertTrue("true case", luhn.isValid("00000000"));
        assertTrue("true case", luhn.isValid("4111111111111111"));
        
        assertTrue("true case", luhn.isValid("4559677806842243"));
        assertTrue("true case", luhn.isValid("4559677806842342"));
        assertTrue("true case", luhn.isValid("4188353718427841"));
        assertTrue("true case", luhn.isValid("4796917702514402"));
    } // end testIsValidAccuracy1()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * test true cases. The format "41-11-1111-11-11-1111" should be valid.</p>
     *
     */
    public void testIsValidAccuracy_ingoreNonDig() {
        assertTrue("true case", luhn.isValid("4111-1111-1111-1111"));
        assertTrue("true case", luhn.isValid("41-11-1111-11-11-1111"));
        
        assertTrue("true case", luhn.isValid("4559-6778-0684-2243"));
        assertTrue("true case", luhn.isValid("4559-6778-0684-2342"));

    } // end testIsValidAccuracy1()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * test false cases.</p>
     *
     */
    public void testIsValidAccuracy2() {
        assertFalse("bad case", luhn.isValid("4111-1111-1111-1191"));
        assertFalse("bad case", luhn.isValid("4111111111111191"));
        assertFalse("bad case", luhn.isValid("4111111111119111"));
        
        assertFalse("bad case", luhn.isValid("4559677806892243"));
        assertFalse("bad case", luhn.isValid("4199042703612756"));
        assertFalse("bad case", luhn.isValid("4545646269619291"));
    } // end testIsValidAccuracy2()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * If carditCardTest is null, false expected.</p>
     *
     */
    public void testIsValidAccuracy_null() {
        assertFalse("bad case", luhn.isValid(null));
    } // end testIsValidAccuracy_empty()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * If carditCardTest is empty, false expected.</p>
     *
     */
    public void testIsValidAccuracy_empty() {
        assertFalse("bad case", luhn.isValid(""));
    } // end testIsValidAccuracy_empty()

} // end ValidationLUHNTest
