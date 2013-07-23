/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * This test case aggregates all Unit test cases.
 * </p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * Returns the test suite
     *
     * @return the test suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(TestAbstractCreditCardValidator.class);
        suite.addTestSuite(TestAmericanExpressValidator.class);
        suite.addTestSuite(TestCreditCardValidatorOr.class);
        suite.addTestSuite(TestCreditCardValidatorRegistry.class);
        suite.addTestSuite(TestCustomValidator.class);
        suite.addTestSuite(TestDinersClubValidator.class);
        suite.addTestSuite(TestDiscoverValidator.class);
        suite.addTestSuite(TestJCBValidator.class);
        suite.addTestSuite(TestMasterCardValidator.class);
        suite.addTestSuite(TestVisaValidator.class);
        suite.addTestSuite(com.topcoder.ecommerce.creditcard.validation.algorithms.TestAbstractValidationAlgorithm.class);
        suite.addTestSuite(com.topcoder.ecommerce.creditcard.validation.algorithms.TestValidationAnd.class);
        suite.addTestSuite(com.topcoder.ecommerce.creditcard.validation.algorithms.TestValidationFormatAllDigits.class);
        suite.addTestSuite(com.topcoder.ecommerce.creditcard.validation.algorithms.TestValidationFormatLength.class);
        suite.addTestSuite(com.topcoder.ecommerce.creditcard.validation.algorithms.TestValidationLUHN.class);
        suite.addTestSuite(com.topcoder.ecommerce.creditcard.validation.algorithms.TestValidationNot.class);
        suite.addTestSuite(com.topcoder.ecommerce.creditcard.validation.algorithms.TestValidationOr.class);
        suite.addTestSuite(com.topcoder.ecommerce.creditcard.validation.algorithms.TestValidationPrefix.class);
        suite.addTestSuite(com.topcoder.ecommerce.creditcard.validation.algorithms.TestValidationRange.class);
        suite.addTestSuite(Demo.class);

        return suite;
    }
}
