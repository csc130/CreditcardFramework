/*
 * ComponentName: CreditCardValidation
 * FileName: VisaValidatorTest.java
 * Version: 1.0
 * Date: 10/28/2004
 *
 * <p>Copyright (c) 2004, TopCoder, Inc. All rights reserved</p>
 */

package com.topcoder.ecommerce.creditcard.validation.accuracytests;

import com.topcoder.ecommerce.creditcard.validation.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This class contains the accuracy unit tests for VisaValidator.java</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class VisaValidatorTest extends TestCase {

    /**
     * <p>
     * Represents an instance of VisaValidator to be used for testing.</p>
     */
    private VisaValidator visaVD = new VisaValidator();

    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public VisaValidatorTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(VisaValidatorTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the constructor VisaValidator(). 
     * Check if the instance has been create.</p>
     *
     */
    public void testConstructorAccuracy() {
        assertNotNull("Should not be null.", this.visaVD);
    } // end testConstructorAccuracy()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(). test the case when length of VISA 
     * is 16, starting with '4'</p>
     *
     */
    public void testIsValid_len_16() {
        // good visa card#
        assertTrue(this.visaVD.isValid("4515310023788980"));
        assertTrue(this.visaVD.isValid("4188353718427841"));
        assertTrue(this.visaVD.isValid("4283606141412365"));
        
        // bad visa card#
        assertFalse(this.visaVD.isValid("4479180004516893"));
        assertFalse(this.visaVD.isValid("4504327512599782"));
        assertFalse(this.visaVD.isValid("4250047578210079"));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(). test the case when length of VISA 
     * is 13, starting with '4'</p>
     *
     */
    public void testIsValid_len13() {
        // good visa card#
        assertTrue(this.visaVD.isValid("4754114764309"));
        assertTrue(this.visaVD.isValid("4930761787963"));
        assertTrue(this.visaVD.isValid("4816195851899"));
        
        // bad visa card#
        assertFalse(this.visaVD.isValid("4427703913304"));
        assertFalse(this.visaVD.isValid("4559189694477"));
        assertFalse(this.visaVD.isValid("4781998166687"));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the constructor isValid(). 
     * if null is to be validated, false should be expected.</p>
     *
     */
    public void testIsValid_null() {
        assertFalse(this.visaVD.isValid(null));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the constructor isValid(). 
     * if empty is to be validated, false should be expected.</p>
     *
     */
    public void testIsValid_emptp() {
        assertFalse(this.visaVD.isValid(""));
        assertFalse(this.visaVD.isValid("  "));
    } // end testIsValid()()

} // end VisaValidatorTest
