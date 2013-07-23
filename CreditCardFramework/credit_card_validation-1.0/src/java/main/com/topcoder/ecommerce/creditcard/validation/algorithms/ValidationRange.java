/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

/**
 * <p>
 * <strong>Purpose: </strong>an implementation of a <em>ValidationAlgorithm</em> that validates that the digits at a
 * specific position are within a specified range.
 * </p>
 *
 * <p>
 * This class is thread safe because all attributes are immutable
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class ValidationRange extends AbstractValidationAlgorithm {
    ///////////////////////////////////////
    // attributes

    /**
     * <p>
     * <strong>Purpose: </strong>&nbsp; specifies the starting number of the range (inclusive).
     * </p>
     */
    private String startPrefix = null;

    /**
     * <p>
     * <strong>Purpose: </strong>&nbsp; specifies the ending number of the range (inclusive).
     * </p>
     */
    private String endPrefix = null;

    /**
     * <p>
     * <strong>Purpose: </strong>&nbsp; specifies the position within the credit card text that will be checked.&nbsp;
     * This position starts with 1 (not 0).
     * </p>
     */
    private int position = 0;

    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong>creates an instance of the <em>ValidationRange </em> class that will validate a range
     * of numbers at a specific position within the credit card number text.&nbsp;
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>
     * </p>
     *
     * <ol>
     * <li>
     * A non-null, non-empty string
     * </li>
     * <li>
     * A non-null, non-empty string
     * </li>
     * <li>
     * An integer &gt;= 1
     * </li>
     * </ol>
     *
     *
     * @param startPrefix A non-null, non-empty string
     * @param endPrefix A non-null, non-empty string
     * @param position The Position (1 based) in the text to check
     *
     * @throws IllegalArgumentException if the position &lt; 1 or if start or end prefix is an empty string or if start
     *         prefix is greater than end prefix when compared or if the start and ending prefix are different lengths
     * @throws NullPointerException if start or end prefix is null
     */
    public ValidationRange(String startPrefix, String endPrefix, int position) {
        if (position < 1) {
            throw new IllegalArgumentException("position should not be less than 1");
        }

        if (startPrefix == null) {
            throw new NullPointerException("startPrefix should not be null");
        }

        if (startPrefix.trim().length() == 0) {
            throw new IllegalArgumentException("startPrefix should not be empty");
        }

        if (endPrefix == null) {
            throw new NullPointerException("endPrefix should not be null");
        }

        if (endPrefix.trim().length() == 0) {
            throw new IllegalArgumentException("endPrefix should not be empty");
        }

        if (startPrefix.length() != endPrefix.length()) {
            throw new IllegalArgumentException("startPrefix and endPrefix should have the same length");
        }

        if (startPrefix.compareTo(endPrefix) > 0) {
            throw new IllegalArgumentException("startPrefix should not be greater than endPrefix");
        }

        this.startPrefix = startPrefix;
        this.endPrefix = endPrefix;
        this.position = position;
    }

    // end ValidationRange

    /**
     * <p>
     * <strong>Purpose: </strong>validates the passed text by checking to see if the specified position/length is with
     * (inclusive) the range.&nbsp; Please see <em>ValidationAlgorithm#isValid(String) </em> for more details
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a text string - possibly null, possibly empty - validation is done by the
     * validators.
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong>true if the parse number is between (inclusive) the <em>startPrefix </em>
     * and <em>endPrefix </em> at <em>position</em>
     * </p>
     *
     * @param creditCardText true if the parse number is between (inclusive) the startPrefix and endPrefix at position
     *
     * @return true if the parse number is between (inclusive) the StartNumber and EndNumber at Position
     */
    public boolean isValid(String creditCardText) {
        int end = (this.position + this.startPrefix.length()) - 1;

        if ((creditCardText == null) || (end > creditCardText.length())) {
            return false;
        }

        String s = creditCardText.substring(this.position - 1, end);

        return (s.compareTo(this.startPrefix) >= 0) && (s.compareTo(this.endPrefix) <= 0);
    }

    // end isValid

    /**
     * <p>
     * <strong>Purpose: </strong>This method will get return the <em>position</em> variable
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong> a &gt;= 1 integer
     * </p>
     *
     * @return a >= 1 integer
     */
    public int getPosition() {
        return this.position;
    }

    // end getPosition

    /**
     * <p>
     * <strong>Purpose: </strong>This method will get return the <em>startPrefix</em> variable
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong> a non-null, non-empty string
     * </p>
     *
     * @return a non-null, non-empty string
     */
    public String getStartPrefix() {
        return this.startPrefix;
    }

    // end getStartPrefix

    /**
     * <p>
     * <strong>Purpose: </strong>This method will get return the <em>endPrefix </em> variable
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong> a non-null, non-empty string
     * </p>
     *
     * @return a non-null, non-empty string
     */
    public String getEndPrefix() {
        return this.endPrefix;
    }

    // end getEndPrefix
}

// end ValidationRange
