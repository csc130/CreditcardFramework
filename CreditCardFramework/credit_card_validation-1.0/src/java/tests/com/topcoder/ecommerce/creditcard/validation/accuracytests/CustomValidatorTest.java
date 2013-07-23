/*
 * ComponentName: CreditCardValidation
 * FileName: CustomValidatorTest.java
 * Version: 1.0
 * Date: 10/28/2004
 *
 * <p>Copyright (c) 2004, TopCoder, Inc. All rights reserved</p>
 */

package com.topcoder.ecommerce.creditcard.validation.accuracytests;

import com.topcoder.ecommerce.creditcard.validation.*;
import com.topcoder.ecommerce.creditcard.validation.algorithms.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This class contains the accuracy unit tests for CustomValidator.java</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class CustomValidatorTest extends TestCase {
    /**
     * <p>
     * Represents an instance of ValidationFormatAllDigits to be used for testing.</p>
     */
    private ValidationFormatLength lenVD = new ValidationFormatLength(20);

    /**
     * <p>
     * Represents an instance of CustomValidator to be used for testing.</p>
     */
    private CustomValidator customVD1 = new CustomValidator("csm1");; 
    
    /**
     * <p>
     * Represents an instance of CustomValidator to be used for testing.</p>
     */
    private CustomValidator customVD2 = new CustomValidator("csm2", this.lenVD); 
    
    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public CustomValidatorTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(CustomValidatorTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the constructor CustomValidator(String defaultIdentifier). 
     * Simply check out non-null instance of this.customVD1</p>
     *
     */
    public void testConstructorAccuracy() {
        assertNotNull("Should not be null.", this.customVD1);
    } // end testConstructorAccuracy()

    /**
     *<p>
     * Tests accuracy of the constructor 
     * CustomValidator(String defaultIdentifier, ValidationAlgorithm validation). 
     * Simply check out non-null instance of this.customVD2.</p>
     *
     */
    public void testConstructorTwoAccuracy() {
        assertNotNull("Should not be null.", this.customVD2);
    } // end testConstructorTwoAccuracy()
    
    /**
     * Tests accuracy of isValid() and or() methods.
     *
     */
    public void testIsValid_Or() {
        // validate visa 
        assertTrue(this.customVD2.
                or(new VisaValidator()).
                isValid("4515310023788980"));
        
        // validate AmecricanExpress
        assertFalse(this.customVD2.
                or(new VisaValidator()).
                isValid("344648673015039"));
        assertTrue(this.customVD2.
                or(new VisaValidator()).
                or(new AmericanExpressValidator()).
                isValid("344648673015039"));
        
        // validte Master Card
        assertFalse(this.customVD2.
                or(new VisaValidator()).
                or(new AmericanExpressValidator()).
                isValid("5153454098838082"));
        assertTrue(this.customVD2.
                or(new VisaValidator()).
                or(new AmericanExpressValidator()).
                or(new MasterCardValidator()).
                isValid("5153454098838082"));
    }

} // end CustomValidatorTest
