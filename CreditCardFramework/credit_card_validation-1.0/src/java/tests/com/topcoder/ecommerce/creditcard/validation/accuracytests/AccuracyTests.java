/**
 *
 * Copyright (c) 2004, TopCoder, Inc. All rights reserved
 */
package com.topcoder.ecommerce.creditcard.validation.accuracytests;import com.topcoder.ecommerce.creditcard.validation.accuracytests.algorithms.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * <p>This test case aggregates all Accuracy test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(AbstractCreditCardValidatorTest.suite());        suite.addTest(VisaValidatorTest.suite());        suite.addTest(MasterCardValidatorTest.suite());        suite.addTest(JCBValidatorTest.suite());        suite.addTest(DiscoverValidatorTest.suite());        suite.addTest(DinersClubValidatorTest.suite());        suite.addTest(CustomValidatorTest.suite());        suite.addTest(AmericanExpressValidatorTest.suite());        suite.addTest(CreditCardValidatorRegistryTest.suite());        suite.addTest(ValidationFormatAllDigitsTest.suite());        suite.addTest(ValidationFormatLengthTest.suite());        suite.addTest(ValidationLUHNTest.suite());        suite.addTest(ValidationPrefixTest.suite());        suite.addTest(ValidationRangeTest.suite());        suite.addTest(AbstractValidationAlgorithmTest.suite());
        return suite;
    }

}
