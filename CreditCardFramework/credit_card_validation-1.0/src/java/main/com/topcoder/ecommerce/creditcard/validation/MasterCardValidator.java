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
 * <strong>Purpose: </strong>implementation of a <em>CreditCardValidator </em> that will validate MasterCard issued
 * credit cards.&nbsp; See <em>CreditCardValidator </em> for the contract and <em>AbstractCreditCardValidator </em>
 * for how the validation works.
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class MasterCardValidator extends AbstractCreditCardValidator {
    ///////////////////////////////////////
    // attributes

    /**
     * <p>
     * <strong>Purpose: </strong>the prefixes of MasterCard issued credit card number
     * </p>
     */
    private static final String PREFIX_START = "51";
    private static final String PREFIX_END = "55";

    /**
     * <p>
     * <strong>Purpose: </strong>the length of MasterCard issued credit card number
     * </p>
     */
    private static final int LENGTH = 16;

    /**
     * <p>
     * <strong>Purpose: </strong>provide the default identifier for this validator.&nbsp; This value is a constant and
     * thus - non-null, non-empty and immutable
     * </p>
     */
    public static final String IDENTIFIER = "MasterCard";

    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong> create the instance of a MasterCard issued credit card validator.
     * </p>
     */
    public MasterCardValidator() {
        super(MasterCardValidator.IDENTIFIER,
            new ValidationFormatAllDigits().and(
                new ValidationPrefix(MasterCardValidator.PREFIX_START, MasterCardValidator.PREFIX_END))
                                           .and(new ValidationFormatLength(MasterCardValidator.LENGTH)).and(new ValidationLUHN()));
    }

    // end MasterCardValidator
}

// end MasterCardValidator
