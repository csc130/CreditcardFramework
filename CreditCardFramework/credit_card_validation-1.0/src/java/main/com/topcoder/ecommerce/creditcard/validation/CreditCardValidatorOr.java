/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

/**
 * <p>
 * <strong>Purpose: </strong>implementation of a <em>CreditCardValidator </em> that will combine the validation of two
 * other <em>CreditCardValidators.</em>
 * </p>
 *
 * <p>
 * This class is thread safe because all attributes are immutable
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
class CreditCardValidatorOr extends AbstractCreditCardValidator {
    /**
     * <p>
     * <strong>Purpose: </strong>provide the default identifier for this validator.&nbsp; This value is a constant and
     * thus - non-null, non-empty and immutable
     * </p>
     */
    private static final String IDENTIFIER = "CreditCardValidatorOr";

    ///////////////////////////////////////
    // attributes

    /**
     * <p>
     * <strong>Purpose: </strong>this is the left side of the 'or' condition
     * </p>
     */
    private final CreditCardValidator left;

    /**
     * <p>
     * <strong>Purpose: </strong>this is the right side of the 'or' condition
     * </p>
     */
    private final CreditCardValidator right;

    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong>creates the <em>CreditCardValidatorOr </em> instance that will perform an 'or' between
     * two other <em>CreditCardValidators</em>
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>two non-null <em>CreditCardValidators</em>
     * </p>
     *
     * @param left a non-null CreditCardValidator
     * @param right a non-null CreditCardValidator
     *
     * @throws NullPointerException if either parm is null
     */
    CreditCardValidatorOr(CreditCardValidator left, CreditCardValidator right) {
        super(CreditCardValidatorOr.IDENTIFIER);

        if ((left == null) || (right == null)) {
            throw new NullPointerException("neither left nor right should be null");
        }

        this.left = left;
        this.right = right;
    }

    // end CreditCardValidatorOr

    /**
     * <p>
     * <strong>Purpose: </strong>validates the passed text.&nbsp; Please see <em>CreditCardValidator#IsValid(String)
     * </em> for more details
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a text string - possibly null, possibly empty - validation is done by the
     * validators.
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong>true if the <em>CreditCardText </em> is valid for either validators,
     * false otherwise
     * </p>
     *
     * @param creditCardText a text string - possibly null, possibly empty
     *
     * @return true if the CreditCardText is valid for both validators, false otherwise
     */
    public boolean isValid(String creditCardText) {
        return this.left.isValid(creditCardText) || this.right.isValid(creditCardText);
    }

    // end isValid
}

// end CreditCardValidatorOr
