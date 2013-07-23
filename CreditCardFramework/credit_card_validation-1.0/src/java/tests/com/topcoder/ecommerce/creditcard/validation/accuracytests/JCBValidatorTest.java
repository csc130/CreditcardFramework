/*
 * ComponentName: CreditCardValidation
 * FileName: JCBValidatorTest.java
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
 * This class contains the accuracy unit tests for JCBValidator.java</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class JCBValidatorTest extends TestCase {

    /**
     * <p>
     * Represents an instance of JCBValidator to be used for testing.</p>
     */
    private JCBValidator jcbVD = new JCBValidator();

    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public JCBValidatorTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(JCBValidatorTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the constructor JCBValidator(). Check if the instance 
     * is null.</p>
     *
     */
    public void testConstructorAccuracy() {
        assertNotNull("Should not be null.", this.jcbVD);
    } // end testConstructorAccuracy()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(). test the case when length of JCB
     * is 16, starting with '3'</p>
     *
     */
    public void testIsValid_len_16() {
        // good visa card#
        assertTrue(this.jcbVD.isValid("3645805137405582"));
        assertTrue(this.jcbVD.isValid("3460725101565942"));
        assertTrue(this.jcbVD.isValid("3527668957586847"));
        
        // bad visa card#
        assertFalse(this.jcbVD.isValid("3782591357441903"));
        assertFalse(this.jcbVD.isValid("3001138798013921"));
        assertFalse(this.jcbVD.isValid("3645738630455651"));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(). test the case when length of JCB 
     * is 15, starting with '2131, 1800'</p>
     *
     */
    public void testIsValid_len15() {
        // good visa card#
        assertTrue(this.jcbVD.isValid("213118003771402"));
        assertTrue(this.jcbVD.isValid("213118006178043"));
        assertTrue(this.jcbVD.isValid("213118008720305"));
        
        // bad visa card#
        assertFalse(this.jcbVD.isValid("213118002084480"));
        assertFalse(this.jcbVD.isValid("213118008035272"));
        assertFalse(this.jcbVD.isValid("213118004429196"));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the constructor isValid(). 
     * if null is to be validated, false should be expected.</p>
     *
     */
    public void testIsValid_null() {
        assertFalse(this.jcbVD.isValid(null));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the constructor isValid(). 
     * if empty is to be validated, false should be expected.</p>
     *
     */
    public void testIsValid_empty() {
        assertFalse(this.jcbVD.isValid(""));
        assertFalse(this.jcbVD.isValid("  "));
    } // end testIsValid()()


} // end JCBValidatorTest
