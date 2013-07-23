/**
 * Copyright (c) 2004, TopCoder, Inc. All rights reserved
 */
 package com.topcoder.ecommerce.creditcard.validation.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Failure test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */

public class FailureTests extends TestCase {

    /**
     * This method aggregates all failure tests
     * @return a test suite that contains all failure tests
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(AbstractCreditCardValidatorTests.class);
        suite.addTestSuite(AbstractValidationAlgorithmTests.class);
        suite.addTestSuite(CreditCardValidatorRegistryTests.class);
        suite.addTestSuite(CustomValidatorTests.class);
        suite.addTestSuite(ValidationFormatLengthTests.class);
        suite.addTestSuite(ValidationPrefixTests.class);
        suite.addTestSuite(ValidationRangeTests.class);
        return suite;
    }
}

