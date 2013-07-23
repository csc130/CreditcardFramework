/*
 * ComponentName: CreditCardValidation
 * FileName: AbstractCreditCardValidatorTest.java
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
 * This class contains the accuracy unit tests for AbstractCreditCardValidator.java 
 * by testing it's subclass SubAbstractCreditCardValidator</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class AbstractCreditCardValidatorTest extends TestCase {

    /**
     * <p>
     * Represents an instance of AbstractCreditCardValidator to be used for testing.</p>
     */
    private AbstractCreditCardValidator algor1 = null;
    
    /**
     * <p>
     * Represents an instance of AbstractCreditCardValidator to be used for testing.</p>
     */
    private AbstractCreditCardValidator algor2 = null;
    
    /**
     * <p>
     * Represents an instance of ValidationAlgorithm to be used for testing.</p>
     */
    private ValidationAlgorithm validator = new ValidationFormatLength(5);;

    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public AbstractCreditCardValidatorTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Sets up the fixture.</p>
     */
    protected void setUp() {
        algor2= new SubAbstractCreditCardValidator("algor2", validator);
        algor1 = new SubAbstractCreditCardValidator("algor1");
    } // end setUp()

    /**
     *<p>
     * Tears down the fixture.</p>
     */
    protected void tearDown() {
        algor1 = null;
        algor2 = null;
    } // end tearDown()

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(AbstractCreditCardValidatorTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the constructor AbstractCreditCardValidator(String defaultIdentifier). 
     * Simply check if this.algor1 has been created.</p>
     *
     */
    public void testConstructorAccuracy() {
        assertNotNull("Should not be null.", this.algor1);
    } // end testConstructorAccuracy()

    /**
     *<p>
     * Tests accuracy of the constructor 
     * AbstractCreditCardValidator(String defaultIdentifier, ValidationAlgorithm validation). 
     * Simply check if this.algor2 has been created.</p>
     *
     */
    public void testConstructorTwoAccuracy() {
        assertNotNull("Should not be null.", this.algor2);
    } // end testConstructorTwoAccuracy()

    /**
     *<p>
     * Tests accuracy of the method setValidation(ValidationAlgorithm algorithm). 
     * Set the validation algorithm for this.algor1, and then get it to check out 
     * the result.</p>
     *
     */
    public void testSetValidationAccuracy() {
        // first null
        assertNull("Should be null.", this.algor1.getValidation());
        
        // set it 
        this.algor1.setValidation(this.validator);
        
        // assert the same
        assertSame("Should be same", this.validator, this.algor1.getValidation());
        
        // set it null again.
        this.algor1.setValidation(null);
    } // end testSetValidationAccuracy()

    /**
     *<p>
     * Tests accuracy of the method getValidation(). Simply check out the validator 
     * of this.algor2, this.validator is expected.</p>
     *
     */
    public void testGetValidationAccuracy() {
        assertSame("Should be same", this.validator, this.algor2.getValidation());
    } // end testGetValidationAccuracy()

    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * Test if the contained validators work well </p>
     *
     */
    public void testIsValidAccuracy() {
        assertTrue("Len 5 is acceptable", this.algor2.isValid("12345"));
        assertFalse("Len 3 is not acceptable", this.algor2.isValid("rfg"));
    } // end testIsValidAccuracy()

    /**
     *<p>
     * Tests accuracy of the method getDefaultIdentifier(). 
     * Simply check out the default identifier of this.algor1 and this.algor2</p>
     *
     */
    public void testGetDefaultIdentifierAccuracy() {
        assertTrue("algor1".equals(this.algor1.getDefaultIdentifier()));
        assertTrue("algor2".equals(this.algor2.getDefaultIdentifier()));
    } // end testGetDefaultIdentifierAccuracy()

    /**
     *<p>
     * Tests accuracy of the method or(CreditCardValidator other). Add more 
     * validation algorithms into this.algor2, and test if it works well with 
     * these algorithms.</p>
     *
     */
    public void testOrAccuracy() {
        ValidationAlgorithm v1 = new ValidationFormatAllDigits();
        this.algor1.setValidation(v1);
        
        assertFalse("Should be false first", this.algor2.isValid("123"));
        
        assertTrue("Should be true again", this.algor2.or(this.algor1).isValid("123"));
        
    } // end testOrAccuracy()
    
    private class SubAbstractCreditCardValidator extends AbstractCreditCardValidator {
        /**
         * Creates the AbstractCreditCardValidator and sets the default identifier.
         * This constructor assumes that the ValidationAlgorithm will be set
         * later.
         *
         * @param iden a non-null, non-empty identifier
         *
         * @throws NullPointerException if the iden is null
         * @throws IllegalArgumentException if the iden is an empty string
         */
        public SubAbstractCreditCardValidator(String iden) {
            super(iden);
        }
        
        /**
         * Creates the AbstractCreditCardValidator and sets the default identifier
         * and ValidationAlgorithm.
         *
         * @param iden a non-null, non-empty identifier
         * @param algor a non-null ValidationAlgorithm
         *
         * @throws NullPointerException if either parameter is null
         * @throws IllegalArgumentException if the identifier is an empty string
         */
        public SubAbstractCreditCardValidator(String iden, ValidationAlgorithm algor) {
            super(iden, algor);
        }
    }

} // end AbstractCreditCardValidatorTest
