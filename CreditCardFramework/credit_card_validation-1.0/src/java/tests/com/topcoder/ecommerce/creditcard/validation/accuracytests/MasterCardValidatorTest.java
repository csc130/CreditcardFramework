/*
 * ComponentName: CreditCardValidation
 * FileName: MasterCardValidatorTest.java
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
 * This class contains the accuracy unit tests for MasterCardValidator.java</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class MasterCardValidatorTest extends TestCase {

    /**
     * <p>
     * Represents an instance of MasterCardValidator to be used for testing.</p>
     */
    private MasterCardValidator masterVD = new MasterCardValidator();

    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public MasterCardValidatorTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(MasterCardValidatorTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the constructor MasterCardValidator(). Check if the 
     * instance of this class has been created.</p>
     *
     */
    public void testConstructorAccuracy() {
        assertNotNull("Should not be null.", this.masterVD);
    } // end testConstructorAccuracy()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(). test the case when length of MASTER 
     * is 16, starting with '51-55'</p>
     *
     */
    public void testIsValid_len_16() {
        // good master card#
        assertTrue(this.masterVD.isValid("5153454098838082"));
        assertTrue(this.masterVD.isValid("5578408056312883"));
        assertTrue(this.masterVD.isValid("5392061861985841"));
        
        // bad master card#
        assertFalse(this.masterVD.isValid("5118517232827931"));
        assertFalse(this.masterVD.isValid("5520853468563153"));
        assertFalse(this.masterVD.isValid("5304435607531341"));
    } // end testIsValid()()

    /**
     *<p>
     * Tests accuracy of the constructor isValid(). 
     * if null is to be validated, false should be expected.</p>
     *
     */
    public void testIsValid_null() {
        assertFalse(this.masterVD.isValid(null));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the constructor isValid(). 
     * if empty is to be validated, false should be expected.</p>
     *
     */
    public void testIsValid_emptp() {
        assertFalse(this.masterVD.isValid(""));
        assertFalse(this.masterVD.isValid("  "));
    } // end testIsValid()()


} // end MasterCardValidatorTest
