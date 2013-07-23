/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationAlgorithm;


/**
 * <p>
 * <strong>Purpose: </strong>implementation of a <em>CreditCardValidator </em> that will allow the application to setup
 * it's own validator.&nbsp; See <em>CreditCardValidator </em> for the contract and <em>AbstractCreditCardValidator
 * </em> for how the validation works.
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class CustomValidator extends AbstractCreditCardValidator {
    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong>creates the <em>CustomValidator </em> instance with the given default
     * identifier.&nbsp; This constructor assume the application will set a validation algorithm later.
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a non-null, non-empty identifier
     * </p>
     *
     * @param defaultIdentifier a non-null, non-empty identifier
     */
    public CustomValidator(String defaultIdentifier) {
        super(defaultIdentifier);
    }

    // end CustomValidator

    /**
     * <p>
     * <strong>Purpose: </strong>creates the <em>CustomValidator </em> instance with the given default identifier and
     * <em>ValidationAlgorithm.&nbsp; </em>
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a non-null, non-empty identifier and a non-null <em>ValidationAlgorithm</em>
     * </p>
     *
     * @param defaultIdentifier a non-null, non-empty identifier
     * @param validation a non-null ValidationAlgorithm
     */
    public CustomValidator(String defaultIdentifier, ValidationAlgorithm validation) {
        super(defaultIdentifier, validation);
    }

    // end CustomValidator
}

// end CustomValidator
