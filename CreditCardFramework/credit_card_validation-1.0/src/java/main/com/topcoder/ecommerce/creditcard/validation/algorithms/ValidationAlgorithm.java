/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

/**
 * <p>
 * <strong>Purpose: </strong>Defines the contract a <em>ValidationAlgorithm </em> must implement for this component to
 * use it.
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public interface ValidationAlgorithm {
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
     * @return true if the implementation considers the text valid, false otherwise
     */
    public boolean isValid(String creditCardText);
}

// end ValidationAlgorithm
