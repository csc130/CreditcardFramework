/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

/**
 * <p>
 * <strong>Purpose: </strong>implementation of a <em>ValidationAlgorithm</em> that will perform an 'or' validation
 * between two other <em>ValidationAlgorithm</em>
 * </p>
 *
 * <p>
 * This class is thread safe because all attributes are immutable
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
class ValidationOr extends AbstractValidationAlgorithm {
    ///////////////////////////////////////
    // attributes

    /**
     * <p>
     * <strong>Purpose: </strong>this is the 'left' side of the 'or'
     * </p>
     */
    private ValidationAlgorithm left;

    /**
     * <p>
     * <strong>Purpose: </strong>this is the &nbsp;'right' side of the 'or'
     * </p>
     */
    private ValidationAlgorithm right;

    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong>creates the <em>ValidationAlgorithmOr </em> instance that will perform an 'or' between
     * two other <em>ValidationAlgorithms</em>
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>two non-null <em>ValidationAlgorithms</em>
     * </p>
     *
     * @param left a non-null ValidationAlgorithm
     * @param right a non-null ValidationAlgorithm
     *
     * @throws NullPointerException if either parameter is null
     */
    ValidationOr(ValidationAlgorithm left, ValidationAlgorithm right) {
        if ((left == null) || (right == null)) {
            throw new NullPointerException("neither left nor right should be null");
        }

        this.left = left;
        this.right = right;
    }

    // end ValidationOr

    /**
     * <p>
     * <strong>Purpose: </strong>validates the passed text.&nbsp; Please see <em>ValidationAlgorithm#isValid(String)
     * </em> for more details
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a text string - possibly null, possibly empty - validation is done by the
     * validators.
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong>true if the <em>creditCardText </em> is valid for either validators,
     * false otherwise
     * </p>
     *
     * @param creditCardText a text string - possibly null, possibly empty
     *
     * @return true if the CreditCardText is valid for either validators, false otherwise
     */
    public boolean isValid(String creditCardText) {
        return this.left.isValid(creditCardText) || this.right.isValid(creditCardText);
    }

    // end isValid
}

// end ValidationOr
