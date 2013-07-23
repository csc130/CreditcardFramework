/*
 * ComponentName: CreditCardValidation
 * FileName: DinersClubValidatorTest.java
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
 * This class contains the accuracy unit tests for DinersClubValidator.java</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class DinersClubValidatorTest extends TestCase {

    /**
     * <p>
     * Represents an instance of DinersClubValidator to be used for testing.</p>
     */
    private DinersClubValidator dinerVD = new DinersClubValidator();

    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public DinersClubValidatorTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(DinersClubValidatorTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the constructor DinersClubValidator(). check out the 
     * non-null result.</p>
     *
     */
    public void testConstructorAccuracy() {
        assertNotNull("Should not be null.", this.dinerVD);
    } // end testConstructorAccuracy()

    /**
     *<p>
     * Tests accuracy of the method isValid(). test the case when length of VISA 
     * is 16, starting with '300305'</p>
     *
     */
    public void testIsValid_0() {
        // good visa card#
        assertTrue(this.dinerVD.isValid("30030561761926"));
        assertTrue(this.dinerVD.isValid("30030501848270"));
        assertTrue(this.dinerVD.isValid("30030595570707"));
        
        // bad visa card#
        assertFalse(this.dinerVD.isValid("30030563162468"));
        assertFalse(this.dinerVD.isValid("30030558934492"));
        assertFalse(this.dinerVD.isValid("30030529618775"));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(). test the case when length of DinersClub 
     * is 14, starting with '36'</p>
     *
     */
    public void testIsValid_1() {
        // good visa card#
        assertTrue(this.dinerVD.isValid("36035539883839"));
        assertTrue(this.dinerVD.isValid("36561040405242"));
        assertTrue(this.dinerVD.isValid("36470095445519"));
        
        // bad visa card#
        assertFalse(this.dinerVD.isValid("36847719893471"));
        assertFalse(this.dinerVD.isValid("36380314448492"));
        assertFalse(this.dinerVD.isValid("36647841683478"));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(). test the case when length of DinersClub 
     * is 14, starting with '38'</p>
     *
     */
    public void testIsValid_2() {
        // good visa card#
        assertTrue(this.dinerVD.isValid("38992483364638"));
        assertTrue(this.dinerVD.isValid("38867353496233"));
        assertTrue(this.dinerVD.isValid("38730150347613"));
        
        // bad visa card#
        assertFalse(this.dinerVD.isValid("38030968212790"));
        assertFalse(this.dinerVD.isValid("38516821725548"));
        assertFalse(this.dinerVD.isValid("38571719824524"));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the constructor isValid(). 
     * if null is to be validated, false should be expected.</p>
     *
     */
    public void testIsValid_null() {
        assertFalse(this.dinerVD.isValid(null));
    } // end testIsValid()()
    
    /**
     *<p>
     * Tests accuracy of the constructor isValid(). 
     * if empty is to be validated, false should be expected.</p>
     *
     */
    public void testIsValid_emptp() {
        assertFalse(this.dinerVD.isValid(""));
        assertFalse(this.dinerVD.isValid("  "));
    } // end testIsValid()()

} // end DinersClubValidatorTest
