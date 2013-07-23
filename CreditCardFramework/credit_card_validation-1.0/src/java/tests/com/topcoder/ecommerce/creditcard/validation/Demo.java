/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationAlgorithm;
import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationFormatAllDigits;
import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationFormatLength;
import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationLUHN;
import com.topcoder.ecommerce.creditcard.validation.algorithms.ValidationPrefix;

import junit.framework.TestCase;

import java.util.List;


/**
 * <p>
 * Demo of Credit Card Validation component
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {
    /**
     * Demonstrate that this component allows the application to be very flexible in how it uses it
     *
     * @throws Exception if any exception occurs during test
     */
    public void test1() throws Exception {
        String cc = "1234-1234-1234";

        //  Use the registry to see which cards it matches
        List cards = CreditCardValidatorRegistry.getInstance().validate(cc);

        if (cards.size() > 0) { // is valid
        }

        //  Validate against a specific card using the registry
        boolean valid = CreditCardValidatorRegistry.getInstance().getCreditCardValidator(DiscoverValidator.IDENTIFIER)
                                                   .isValid(cc);

        //  Or validate against the instance specifically
        valid = new DiscoverValidator().isValid(cc);

        //  Or validate against an algorithm specifically
        valid = new ValidationLUHN().isValid(cc);
    }

    /**
     * Demonstrate how to put together ¡®profiles¡¯ of credit card validations
     *
     * @throws Exception if any exception occurs during test
     */
    public void test2() throws Exception {
        String cc = "1234-1234-1234";

        //  Create a profile for MasterCard/Visa
        CreditCardValidator MV = new MasterCardValidator().or(new VisaValidator());

        //     Validate against it directly
        boolean valid = MV.isValid(cc);

        //     Or add it to the registry for the application to use under
        //     an application specific identifier
        CreditCardValidatorRegistry.getInstance().addCreditCardValidator("mv", MV);
        CreditCardValidatorRegistry.getInstance().removeCreditCardValidator("mv");
    }

    /**
     * Demonstrate how to create new validations using the expressive class construction for algorithms
     *
     * @throws Exception if any exception occurs during test
     */
    public void test3() throws Exception {
        //  Create the enRoute validation
        ValidationAlgorithm enRouteValidation = new ValidationFormatLength(15).and(new ValidationPrefix("2014").or(
                    new ValidationPrefix("2149"))).and(new ValidationFormatAllDigits()).and(new ValidationLUHN());

        //     Create the validator
        CreditCardValidator enRouteValidator = new CustomValidator("enRoute", enRouteValidation);

        //         Add it to the registry using default identifier
        CreditCardValidatorRegistry.getInstance().addCreditCardValidator(enRouteValidator);
        CreditCardValidatorRegistry.getInstance().removeCreditCardValidator("enRoute");
    }

    /**
     * Demonstrate how to validate against all industry specific cards
     *
     * @throws Exception if any exception occurs during test
     */
    public void test4() throws Exception {
        //  Create a gas industry validation algorithm using
        //  the major industry identifiers (MII)
        ValidationAlgorithm gasAlgo = new ValidationPrefix(ValidationPrefix.MII_PETROLEUM).and(new ValidationFormatAllDigits())
                                                                                          .and(new ValidationLUHN());

        //  Create the custom validation
        CreditCardValidator gasValidator = new CustomValidator("gas", gasAlgo);

        //  Add it to the registry
        CreditCardValidatorRegistry.getInstance().addCreditCardValidator(gasValidator);
        CreditCardValidatorRegistry.getInstance().removeCreditCardValidator("gas");
    }
}
