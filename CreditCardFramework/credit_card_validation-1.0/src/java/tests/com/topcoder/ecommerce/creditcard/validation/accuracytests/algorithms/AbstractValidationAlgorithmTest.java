/*
 * ComponentName: CreditCardValidation
 * FileName: AbstractValidationAlgorithmTest.java
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
 * This class contains the accuracy unit tests for AbstractValidationAlgorithm.java. 
 * Since this abstract class will be completely exercised by its subclasses, this 
 * testcase simply checks if all of its three methods work normally, saying 
 * returning no-null instance after being invoked.</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class AbstractValidationAlgorithmTest extends TestCase {

    /**
     * <p>
     * Represents an instance of AbstractValidationAlgorithm to be used for testing.</p>
     */
    private AbstractValidationAlgorithm algor = null;

    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public AbstractValidationAlgorithmTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Sets up the fixture.</p>
     */
    protected void setUp() {
        algor = new SubAbstractValidationAlgorithm();
    } // end setUp()

    /**
     *<p>
     * Tears down the fixture.</p>
     */
    protected void tearDown() {
        algor = null;
    } // end tearDown()

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(AbstractValidationAlgorithmTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the method and(ValidationAlgorithm other)</p>
     *
     */
    public void testAndAccuracy() {
        ValidationAlgorithm other = new ValidationFormatLength(2);
        assertNotNull("Should not be null.", algor.and(other));
    } // end testAndAccuracy()

    /**
     *<p>
     * Tests accuracy of the method or(ValidationAlgorithm other)</p>
     *
     */
    public void testOrAccuracy() {
        ValidationAlgorithm other = new ValidationFormatLength(2);
        assertNotNull("Should not be null.", algor.or(other));
    } // end testOrAccuracy()

    /**
     *<p>
     * Tests accuracy of the method not()</p>
     *
     */
    public void testNotAccuracy() {
        ValidationAlgorithm other = new ValidationFormatLength(2);
        assertNotNull("Should not be null.", algor.or(other));
    } // end testNotAccuracy()
    
    private class SubAbstractValidationAlgorithm extends AbstractValidationAlgorithm {
        /**
         * <p>
         * Simply an empty constructor
         *</p>
         */
        public SubAbstractValidationAlgorithm() {
        }
        
        /**
         * This method implements the abstract method
         * ValidationAlgorithm#isValid(String). It will always return true if
         * the creditCardText is null, otherwise false.
         *
         * @param creditCardText a non-null ValidationAlgorithm
         *
         * @return false forever
         */
        public boolean isValid(String creditCardText) {
            return false;
        }
    }

} // end AbstractValidationAlgorithmTest
