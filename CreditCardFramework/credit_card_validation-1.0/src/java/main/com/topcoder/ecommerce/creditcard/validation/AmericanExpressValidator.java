/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationFormatAllDigits;
import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationFormatLength;
import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationLUHN;
import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationPrefix;


/**
 * <p>
 * <strong>Purpose: </strong>implementation of a <em>CreditCardValidator </em> that will validate AmericanExpress
 * issued credit cards.&nbsp; See <em>CreditCardValidator </em> for the contract and <em>AbstractCreditCardValidator
 * </em> for how the validation works.
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class AmericanExpressValidator extends AbstractCreditCardValidator {
    ///////////////////////////////////////
    // attributes

    /**
     * <p>
     * <strong>Purpose: </strong>provide the default identifier for this validator.&nbsp; This value is a constant and
     * thus - non-null, non-empty and immutable
     * </p>
     */
    public static final String IDENTIFIER = "AmericanExpress";

    /**
     * <p>
     * <strong>Purpose: </strong>the prefixes of AmericanExpress issued credit card number
     * </p>
     */
    private static final String PREFIX_1 = "34";
    private static final String PREFIX_2 = "37";

    /**
     * <p>
     * <strong>Purpose: </strong>the length of AmericanExpress issued credit card number
     * </p>
     */
    private static final int LENGTH = 15;

    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong> create the instance of a American Express issued credit card validator.
     * </p>
     */
    public AmericanExpressValidator() {
        super(AmericanExpressValidator.IDENTIFIER,
            new ValidationFormatAllDigits().and(new ValidationPrefix(AmericanExpressValidator.PREFIX_1).or(
                    new ValidationPrefix(AmericanExpressValidator.PREFIX_2)))
                                           .and(new ValidationFormatLength(AmericanExpressValidator.LENGTH))
                                           .and(new ValidationLUHN()));
    }

    // end AmericanExpressValidator
}

// end AmericanExpressValidator
