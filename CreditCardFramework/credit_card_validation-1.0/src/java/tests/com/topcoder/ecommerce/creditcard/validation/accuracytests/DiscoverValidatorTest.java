/*
 * ComponentName: CreditCardValidation
 * FileName: DiscoverValidatorTest.java
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
 * This class contains the accuracy unit tests for DiscoverValidator.java</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class DiscoverValidatorTest extends TestCase {

    /**
     * <p>
     * Represents an instance of DiscoverValidator to be used for testing.</p>
     */
    private DiscoverValidator disVD = new DiscoverValidator();

    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public DiscoverValidatorTest(String name) {
        super(name);
    }
    
    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(DiscoverValidatorTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the constructor DiscoverValidator(). Check out the 
     * non-null isntance of this.disVD</p>
     *
     */
    public void testConstructorAccuracy() {
        assertNotNull("Should not be null.", this.disVD);
    } // end testConstructorAccuracy()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(). test the case when length of Discover 
     * is 16, starting with '6011'</p>
     *
     */
    public void testIsValid_len_16() {
        // good visa card#
        assertTrue(this.disVD.isValid("6011128301084375"));
        assertTrue(this.disVD.isValid("6011371229724264"));
        assertTrue(this.disVD.isValid("6011739351345274"));
        
        // bad visa card#
        assertFalse(this.disVD.isValid("6011474338309970"));
        assertFalse(this.disVD.isValid("6011112393877224"));
        assertFalse(this.disVD.isValid("6011387947457447"));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the constructor isValid(). 
     * if null is to be validated, false should be expected.</p>
     *
     */
    public void testIsValid_null() {
        assertFalse(this.disVD.isValid(null));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the constructor isValid(). 
     * if empty is to be validated, false should be expected.</p>
     *
     */
    public void testIsValid_emptp() {
        assertFalse(this.disVD.isValid(""));
        assertFalse(this.disVD.isValid("  "));
    } // end testIsValid()()


} // end DiscoverValidatorTest
