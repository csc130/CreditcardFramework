/*
 * ComponentName: CreditCardValidation
 * FileName: ValidationPrefixTest.java
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
 * This class contains the accuracy unit tests for ValidationPrefix.java. 
 * The ValidationPrefix class is particular subclass of ValidationRange. We only 
 * test the constructors of this class here. Please see the ValidationRangeTest.java
 *  for more detail.</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class ValidationPrefixTest extends TestCase {
    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public ValidationPrefixTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(ValidationPrefixTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the constructor ValidationPrefix(String prefix). Simply 
     * create an instance of this class and check out non-null result.</p>
     *
     */
    public void testConstructorAccuracy() {
        assertNotNull("Should not be null.", new ValidationPrefix("123"));
    } // end testConstructorAccuracy()

    /**
     *<p>
     * Tests accuracy of the constructor 
     * ValidationPrefix(String startPrefix, String endPrefix). Simply 
     * create an instance of this class and check out non-null result.</p>
     *
     */
    public void testConstructorTwoAccuracy() {
        assertNotNull("Should not be null.", new ValidationPrefix("123", "345"));
    } // end testConstructorTwoAccuracy()

} // end ValidationPrefixTest
