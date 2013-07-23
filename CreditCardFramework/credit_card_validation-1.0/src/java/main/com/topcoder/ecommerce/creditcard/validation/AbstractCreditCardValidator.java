/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationAlgorithm;


/**
 * <p>
 * <strong>Purpose: </strong>an abstract implementation of a <em>CreditCardValidator </em> that provides most of the
 * base functionality of the <em>CreditCardValidator </em> interface and provides some new functionality: the ability
 * to 'or' validators together and the ability to mutate the algorithm.
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public abstract class AbstractCreditCardValidator implements CreditCardValidator {
    ///////////////////////////////////////
    // attributes

    /**
     * <p>
     * <strong>Purpose: </strong>represents the default identifier that can potentially be used as the key in the
     * <em>CreditCardValidationRegistry</em> It is also used as the internal lock for thread synchronization
     * </p>
     */
    private String defaultIdentifier = null;

    /**
     * <p>
     * <strong>Purpose: </strong>represents the validation algorithm that will be used to validate the credit card
     * text.
     * </p>
     */
    private ValidationAlgorithm validation = null;

    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong>creates the <em>AbstractCreditCardValidator</em> and sets the default
     * identifier.&nbsp; This constructor assumes that the <em>ValidationAlgorithm</em> will be set later.
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a non-null, non-empty identifier
     * </p>
     *
     * @param defaultIdentifier a non-null, non-empty identifier
     *
     * @throws NullPointerException if the identifier is null
     * @throws IllegalArgumentException if the identifier is an empty string
     */
    public AbstractCreditCardValidator(String defaultIdentifier) {
        if (defaultIdentifier == null) {
            throw new NullPointerException("defaultIdentifier shoule not be null");
        }

        if (defaultIdentifier.trim().length() == 0) {
            throw new IllegalArgumentException("defaultIdentifier shoule not be empty");
        }

        this.defaultIdentifier = defaultIdentifier;
    }

    // end AbstractCreditCardValidator

    /**
     * <p>
     * <strong>Purpose: </strong>creates the <em>AbstractCreditCardValidator</em> and sets the default identifier and
     * <em>ValidationAlgorithm.</em>
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a non-null, non-empty identifier and a non-null <em>ValidationAlgorithm</em>
     * </p>
     *
     * @param defaultIdentifier a non-null, non-empty identifier
     * @param validation a non-null ValidationAlgorithm
     *
     * @throws NullPointerException if either parameter is null
     */
    public AbstractCreditCardValidator(String defaultIdentifier, ValidationAlgorithm validation) {
        this(defaultIdentifier);

        if (validation == null) {
            throw new NullPointerException("validation should not be null");
        }

        this.setValidation(validation);
    }

    // end AbstractCreditCardValidator

    /**
     * <p>
     * <strong>Purpose: </strong>This method will set the <em>ValidationAlgorithm </em> that will be used by this
     * class.
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a, possibly null, <em>ValidationAlgorithm</em>
     * </p>
     *
     * @param algorithm the, possibly null, ValidationAlgorithm
     */
    public void setValidation(ValidationAlgorithm algorithm) {
        synchronized (this.defaultIdentifier) {
            this.validation = algorithm;
        }
    }

    // end setValidation

    /**
     * <p>
     * <strong>Purpose: </strong>This method will get the current <em>ValidationAlgorithm </em> that will be used by
     * this class.
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong>a, possibly null if none set, <em>ValidationAlgorithm</em>
     * </p>
     *
     * @return a, possibly null, ValidationAlgorithm
     */
    public ValidationAlgorithm getValidation() {
        synchronized (this.defaultIdentifier) {
            return this.validation;
        }
    }

    // end getValidation

    /**
     * <p>
     * <strong>Purpose: </strong>This method will return whether the passed string is valid or not for this
     * <em>CreditCardValidator</em> .&nbsp; &nbsp;Please see <em>CreditCardValidator#isValid(String) </em> for more
     * details
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a text string - possibly null, possibly empty with validation being deferred to
     * the ValidationAlgorithm
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong>true if the implementation considers the text valid, false otherwise
     * </p>
     *
     * @param creditCardText a text string - possibly null, possibly empty
     *
     * @return true if the CreditCardText is valid, false otherwise
     */
    public boolean isValid(String creditCardText) {
        synchronized (this.defaultIdentifier) {
            return (this.validation == null) ? true : this.validation.isValid(creditCardText);
        }
    }

    // end isValid

    /**
     * <p>
     * <strong>Purpose: </strong>This method will get the current default identifier for this implementation.
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong> a non-null, non-empty identifier
     * </p>
     *
     * @return a non-null, non-empty identifier
     */
    public String getDefaultIdentifier() {
        return this.defaultIdentifier;
    }

    // end getDefaultIdentifier

    /**
     * <p>
     * <strong>Purpose: </strong>This method is utility method to create an 'or' condition between this validator and
     * another onte.&nbsp; This method will return an <em>AbstractCreditCardValidation </em> that can perform an 'or'
     * operation between the this and another <em>CreditCardValidations</em>
     * </p>
     *
     * <p>
     * <strong>Typical Args: a </strong> non-null <em>CreditCardValidators</em>
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong> a non-null <em>AbstractCreditCardValidator</em>
     * </p>
     *
     * @param other a non-null CreditCardValidator
     *
     * @return a non-null AbstractCreditCardValidator
     *
     * @throws NullPointerException if other is null
     */
    public AbstractCreditCardValidator or(CreditCardValidator other) {
        if (other == null) {
            throw new NullPointerException("other should not be null");
        }

        return new CreditCardValidatorOr(this, other);
    }

    // end or
}

// end AbstractCreditCardValidator
