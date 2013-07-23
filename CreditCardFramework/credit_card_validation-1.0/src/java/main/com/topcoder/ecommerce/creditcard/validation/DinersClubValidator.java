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
 * <strong>Purpose: </strong>implementation of a <em>CreditCardValidator </em> that will validate Diners Club/Carte
 * Blanche issued credit cards.&nbsp; See <em>CreditCardValidator </em> for the contract and
 * <em>AbstractCreditCardValidator </em> for how the validation works.
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class DinersClubValidator extends AbstractCreditCardValidator {
    ///////////////////////////////////////
    // attributes

    /**
     * <p>
     * <strong>Purpose: </strong>the prefixes of Diners Club/Carte Blanche issued credit card number
     * </p>
     */
    private static final String PREFIX_1_START = "300";
    private static final String PREFIX_1_END = "305";
    private static final String PREFIX_2 = "36";
    private static final String PREFIX_3 = "38";

    /**
     * <p>
     * <strong>Purpose: </strong>the length of Diners Club/Carte Blanche issued credit card number
     * </p>
     */
    private static final int LENGTH = 14;

    /**
     * <p>
     * <strong>Purpose: </strong>provide the default identifier for this validator.&nbsp; This value is a constant and
     * thus - non-null, non-empty and immutable
     * </p>
     */
    public static final String IDENTIFIER = "DinersClub";

    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong> create the instance of a Diners Club/Carte Blanche&nbsp; issued credit card
     * validator.
     * </p>
     */
    public DinersClubValidator() {
        super(DinersClubValidator.IDENTIFIER,
            new ValidationFormatAllDigits().and(new ValidationPrefix(DinersClubValidator.PREFIX_1_START,
                    DinersClubValidator.PREFIX_1_END).or(new ValidationPrefix(DinersClubValidator.PREFIX_2)).or(new ValidationPrefix(
                        DinersClubValidator.PREFIX_3))).and(new ValidationFormatLength(DinersClubValidator.LENGTH).and(
                    new ValidationLUHN())));
    }

    // end DinersClubValidator
}

// end DinersClubValidator
