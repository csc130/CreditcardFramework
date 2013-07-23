/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

/**
 * <p>
 * <strong>Purpose: </strong>an implementation of a <em>ValidationAlgorithm</em> that validates that passed credit card
 * is a specific length
 * </p>
 *
 * <p>
 * This class is thread safe because all attributes are immutable
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class ValidationFormatLength extends AbstractValidationAlgorithm {
    ///////////////////////////////////////
    // attributes

    /**
     * <p>
     * <strong>Purpose: </strong>&nbsp; the length that will be checked
     * </p>
     */
    private int length = 0;

    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong>creates an instance of the <em>ValidationFormatLength </em> class that will validate
     * that the text is a certain length
     * </p>
     *
     * @param length Length to validate - must be &gt;= 1
     *
     * @throws IllegalArgumentException if Length is &lt; 1
     */
    public ValidationFormatLength(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("length should not be less than 1");
        }

        this.length = length;
    }

    // end ValidationFormatLength

    /**
     * <p>
     * <strong>Purpose: </strong>validates the passed text by checking to see the passed text is a specified
     * length.&nbsp; Please see <em>ValidationAlgorithm#isValid(String) </em> for more details
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a text string - possibly null, possibly empty - validation is done by the
     * validators.
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong>true if the string is a specified length
     * </p>
     *
     * @param creditCardText a text string - possibly null, possibly empty - validation is done by the validators.
     *
     * @return true if the string is a specified length
     */
    public boolean isValid(String creditCardText) {
        return (creditCardText == null) ? false : (creditCardText.length() == this.length);
    }

    // end isValid

    /**
     * <p>
     * <strong>Purpose: </strong>This method will get return the <em>length </em> variable
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong> a &gt;= 1 integer
     * </p>
     *
     * @return a >= 1 integer
     */
    public int getLength() {
        return this.length;
    }

    // end getLength
}

// end ValidationFormatLength
