/*
 * ComponentName: CreditCardValidation
 * FileName: AmericanExpressValidatorTest.java
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
 * This class contains the accuracy unit tests for AmericanExpressValidator.java</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class AmericanExpressValidatorTest extends TestCase {

    /**
     * <p>
     * Represents an instance of AmericanExpressValidator to be used for testing.</p>
     */
    private AmericanExpressValidator aeVD = new AmericanExpressValidator();

    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public AmericanExpressValidatorTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(AmericanExpressValidatorTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the constructor AmericanExpressValidator(). Check out 
     * the non-null instance of this.aeVD</p>
     *
     */
    public void testConstructorAccuracy() {
        assertNotNull("Should not be null.", this.aeVD);
    } // end testConstructorAccuracy()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(). test the case when length of AmericanExpress
     * is 15, starting with '34'</p>
     *
     */
    public void testIsValid_34() {
        // good visa card#
        assertTrue(this.aeVD.isValid("344648673015039"));
        assertTrue(this.aeVD.isValid("343591083854889"));
        assertTrue(this.aeVD.isValid("340926954778275"));
        
        // bad visa card#
        assertFalse(this.aeVD.isValid("348641989718083"));
        assertFalse(this.aeVD.isValid("342264335951723"));
        assertFalse(this.aeVD.isValid("343297284043111"));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(). test the case when length of AmericanExpress
     * is 15, starting with '37'</p>
     *
     */
    public void testIsValid_37() {
        // good visa card#
        assertTrue(this.aeVD.isValid("379152978702498"));
        assertTrue(this.aeVD.isValid("376622924111005"));
        assertTrue(this.aeVD.isValid("370655310266989"));
        
        // bad visa card#
        assertFalse(this.aeVD.isValid("375280066409632"));
        assertFalse(this.aeVD.isValid("372411110507234"));
        assertFalse(this.aeVD.isValid("371374185288681"));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the constructor isValid(). 
     * if null is to be validated, false should be expected.</p>
     *
     */
    public void testIsValid_null() {
        assertFalse(this.aeVD.isValid(null));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the constructor isValid(). 
     * if empty is to be validated, false should be expected.</p>
     *
     */
    public void testIsValid_emptp() {
        assertFalse(this.aeVD.isValid(""));
        assertFalse(this.aeVD.isValid("  "));
    } // end testIsValid()()


} // end AmericanExpressValidatorTest
