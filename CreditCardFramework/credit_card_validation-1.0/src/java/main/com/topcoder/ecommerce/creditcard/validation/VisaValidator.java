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
 * <strong>Purpose: </strong>implementation of a <em>CreditCardValidator </em> that will validate Visa issued credit
 * cards.&nbsp; See <em>CreditCardValidator </em> for the contract and <em>AbstractCreditCardValidator </em> for how
 * the validation works.
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class VisaValidator extends AbstractCreditCardValidator {
    ///////////////////////////////////////
    // attributes

    /**
     * <p>
     * <strong>Purpose: </strong>the prefixes of Visa issued credit card number
     * </p>
     */
    private static final String PREFIX = "4";

    /**
     * <p>
     * <strong>Purpose: </strong>the length of Visa issued credit card number
     * </p>
     */
    private static final int LENGTH_1 = 13;
    private static final int LENGTH_2 = 16;

    /**
     * <p>
     * <strong>Purpose: </strong>provide the default identifier for this validator.&nbsp; This value is a constant and
     * thus - non-null, non-empty and immutable
     * </p>
     */
    public static final String IDENTIFIER = "Visa";

    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong> create the instance of a Visa issued credit card validator.
     * </p>
     */
    public VisaValidator() {
        super(VisaValidator.IDENTIFIER,
            new ValidationFormatAllDigits().and(new ValidationPrefix(VisaValidator.PREFIX))
                                           .and(new ValidationFormatLength(VisaValidator.LENGTH_1).or(
                    new ValidationFormatLength(VisaValidator.LENGTH_2))).and(new ValidationLUHN()));
    }

    // end VisaValidator
}

// end VisaValidator
