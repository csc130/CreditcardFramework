/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

import java.lang.String;


/**
 * <p>
 * <strong>Purpose: </strong>an implementation of a <em>ValidationAlgorithm</em> that applys the LUHN algorithm ot the
 * test string
 * </p>
 *
 * <p>
 * This class is thread safe because it has no attribute
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class ValidationLUHN extends AbstractValidationAlgorithm {
    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong>simply creates an instance of the <em>ValidationLUHN</em> class
     * </p>
     */
    public ValidationLUHN() {
    }

    // end ValidationLUHN

    /**
     * <p>
     * <strong>Purpose: </strong>validates the passed text by appling the LUHN algorithm.&nbsp; Please see
     * <em>ValidationAlgorithm#isValid(String) </em> for more details
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a text string - possibly null, possibly empty - validation is done by the
     * validators.
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong>true if the <em>CreditCardText </em> passes the LUHN algorithm, false
     * otherwise
     * </p>
     *
     * <p></p>
     *
     * @param creditCardText a text string - possibly null, possibly empty
     *
     * @return true if the CreditCardText passes the LUHN algorithm, false otherwise
     */
    public boolean isValid(String creditCardText) {
        //return false if creditCardText is null
        if (creditCardText == null || creditCardText.length() == 0) {
            return false;
        }

        int sum = 0; //initialize the sum to 0
        int k = 1; //used as a sequence number for digits

        for (int i = creditCardText.length() - 1; i >= 0; i--) {
            int digit = Character.digit(creditCardText.charAt(i), 10); //change character into digit number value

            //if a non-digit is met, ignore it
            if ((digit < 0) || (digit > 9)) {
                continue;
            }

            if ((k & 1) > 0) {
                //sequence number is odd
                sum += digit; //add to sum directly
            } else {
                //sequence number is even
                digit <<= 1; //double the value

                if (digit > 9) {
                    digit -= 9; //it is always in format like 1x, 1 + x = 1 * 10 + x - 9 = 1x - 9
                }

                sum += digit; //add to sum
            }

            k++; //increase the sequence number
        }

        return (sum % 10) == 0; //return true if sum is divisible by 10
    }

    // end isValid
}

// end ValidationLUHN
