/**
 * Copyright (c) 2004, TopCoder, Inc. All rights reserved
 */
package com.topcoder.ecommerce.creditcard.validation.failuretests;

import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationFormatLength;

import junit.framework.TestCase;

/**
 * <p>Description: This is a failure test suite for ValidationFormatLength. It
 * uses a postion < 1 as input, an IAE is expected to be thrown</p>
 *
 * @author jfjiang
 * @version 1.0
 */

public class ValidationFormatLengthTests extends TestCase {
    /**
     * test constructor, use 0 as input parameter, an IAE is expected
     */
    public void testConstructorFailure11()
    {
        try {
            new ValidationFormatLength(0);
            fail("an IAE is expected here");
        } catch (IllegalArgumentException iae)
        {
            //pass
        }
    }

    /**
 * test constructor, use -10 as input parameter, an IAE is expected
 */
public void testConstructorFailure12()
{
    try {
        new ValidationFormatLength(-10);
        fail("an IAE is expected here");
    } catch (IllegalArgumentException iae)
    {
        //pass
    }
}

}