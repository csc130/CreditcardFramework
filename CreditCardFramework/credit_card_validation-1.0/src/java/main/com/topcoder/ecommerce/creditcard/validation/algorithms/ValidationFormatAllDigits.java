/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

import java.lang.String;


/**
 * <p>
 * <strong>Purpose: </strong>an implementation of a <em>ValidationAlgorithm</em> that validates that passed credit card
 * is all digits ('0'-'9')
 * </p>
 *
 * <p>
 * This class is thread safe because it has no attribute
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class ValidationFormatAllDigits extends AbstractValidationAlgorithm {
    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong>creates an instance of the <em>ValidationFormatAllDigits</em> class that will validate
     * that the text is all digits
     * </p>
     */
    public ValidationFormatAllDigits() {
    }

    // end ValidationFormatAllDigits

    /**
     * <p>
     * <strong>Purpose: </strong>validates the passed text by checking to see the passed text is all digits
     * ('0'-'9').&nbsp; Please see <em>ValidationAlgorithm#isValid(String) </em> for more details
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a text string - possibly null, possibly empty - validation is done by the
     * validators.
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong>true if the number is all digits
     * </p>
     *
     * @param creditCardText a text string - possibly null, possibly empty - validation is done by the validators.
     *
     * @return true if the number is all digits
     */
    public boolean isValid(String creditCardText) {
        if (creditCardText == null || creditCardText.length() == 0) {
            return false;
        }

        for (int i = 0; i < creditCardText.length(); i++) {
            if (!Character.isDigit(creditCardText.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    // end isValid
}

// end ValidationFormatAllDigits
