/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

/**
 * <p>
 * <strong>Purpose: </strong>Defines the contract a <em>CreditCardValidator </em> must implement for this component to
 * use it.
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public interface CreditCardValidator {
    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong>This method will validate the given credit card text against the rules defined by the
     * implementation of this interface.
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a text string - possibly null, possibly empty with no validation done in this
     * method.
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong>true if the implementation considers the text valid, false otherwise
     * </p>
     *
     * @param creditCardText a text string - possibly null, possibly empty
     *
     * @return true if the CreditCardText is valid for both validators, false otherwise
     */
    public boolean isValid(String creditCardText);

    /**
     * <p>
     * <strong>Purpose: </strong>This method will return the default identifier for the implementation.&nbsp; Will be
     * used by the <em>CreditCardValidatorRegistry#addCreditCardValidator(creditCardValidator) </em> method to
     * determine what identifier to associate this implementation with.
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong> a non-null, non-empty string representing the default identifier name.
     * </p>
     *
     * @return a non-null, non-empty string representing the default identifier name.
     */
    public String getDefaultIdentifier();
}

// end CreditCardValidator
