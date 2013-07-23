/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

import java.lang.String;


/**
 * <p>
 * <strong>Purpose: </strong>implementation of a <em>ValidationAlgorithm </em> that will perform a 'not' validation
 * against another <em>ValidationAlgorithm</em>
 * </p>
 *
 * <p>
 * This class is thread safe because all attributes are immutable
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
class ValidationNot extends AbstractValidationAlgorithm {
    ///////////////////////////////////////
    // attributes

    /**
     * <p>
     * <strong>Purpose: </strong>this is the validator to check.
     * </p>
     */
    private ValidationAlgorithm validation;

    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong>creates the <em>ValidationAlgorithmAnd</em> instance that will perform an 'not'
     * against one other <em>ValidationAlgorithms</em>
     * </p>
     *
     * <p></p>
     *
     * <p>
     * <strong>Typical Args: a </strong> non-null <em>ValidationAlgorithm</em>
     * </p>
     *
     * @param validation a non-null ValidationAlgorithm
     *
     * @throws NullPointerException if the parameter is null
     */
    ValidationNot(ValidationAlgorithm validation) {
        if (validation == null) {
            throw new NullPointerException("validation should not be null");
        }

        this.validation = validation;
    }

    // end ValidationNot

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
     * <strong>Typical Return value: </strong>true if the c <em>reditCardText </em> is not valid for the validation,
     * false otherwise
     * </p>
     *
     * @param creditCardText a text string - possibly null, possibly empty
     *
     * @return true if the CreditCardText is not valid for the validation, false otherwise
     */
    public boolean isValid(String creditCardText) {
        return !this.validation.isValid(creditCardText);
    }

    // end isValid
}

// end ValidationNot
