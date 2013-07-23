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
 * <strong>Purpose: </strong>implementation of a <em>CreditCardValidator </em> that will validate JCB issued credit
 * cards.&nbsp; See <em>CreditCardValidator </em> for the contract and <em>AbstractCreditCardValidator </em> for how
 * the validation works.
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class JCBValidator extends AbstractCreditCardValidator {
    ///////////////////////////////////////
    // attributes

    /**
     * <p>
     * <strong>Purpose: </strong>the prefixes of JCB issued credit card number
     * </p>
     */
    private static final String PREFIX_1 = "3";
    private static final String PREFIX_2 = "2131";
    private static final String PREFIX_3 = "1800";

    /**
     * <p>
     * <strong>Purpose: </strong>the lengths of JCB issued credit card number
     * </p>
     */
    private static final int LENGTH_1 = 16;
    private static final int LENGTH_2 = 15;

    /**
     * <p>
     * <strong>Purpose: </strong>provide the default identifier for this validator.&nbsp; This value is a constant and
     * thus - non-null, non-empty and immutable
     * </p>
     */
    public static String IDENTIFIER = "JCB";

    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong> create the instance of a JCB issued credit card validator.
     * </p>
     */
    public JCBValidator() {
        super(JCBValidator.IDENTIFIER,
            new ValidationFormatAllDigits().and(new ValidationPrefix(JCBValidator.PREFIX_1).and(
                    new ValidationFormatLength(JCBValidator.LENGTH_1)).or(new ValidationPrefix(JCBValidator.PREFIX_2))
                                                                                           .or(new ValidationPrefix(
                        JCBValidator.PREFIX_3).and(new ValidationFormatLength(JCBValidator.LENGTH_2))).and(new ValidationLUHN())));
    }

    // end JCBValidator
}

// end JCBValidator
