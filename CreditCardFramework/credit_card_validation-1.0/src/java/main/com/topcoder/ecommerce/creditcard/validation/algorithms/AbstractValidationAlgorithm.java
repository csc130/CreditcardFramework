/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

/**
 * <p>
 * <strong>Purpose: </strong>an abstract implementation of a <em>ValidationAlgorithm</em> that provides operator type
 * of functionality (and, or, not).
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public abstract class AbstractValidationAlgorithm implements ValidationAlgorithm {
    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong>This method provides an 'and' type of operator to algorithms.&nbsp; This method will
     * return a <em>AbstractValidationAlgorithm </em> that can perform an 'and' operation between the 'this' and
     * another algorithm.
     * </p>
     *
     * <p>
     * <strong>Typical Args: a </strong> non-null <em>ValidationAlgorithm </em>
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong> a non-null <em>ValidationAlgorithm </em>
     * </p>
     *
     * @param other a non-null ValidationAlgorithm
     *
     * @return a non-null ValidationAlgorithm
     *
     * @throws NullPointerException if parameter is null
     */
    public AbstractValidationAlgorithm and(ValidationAlgorithm other) {
        if (other == null) {
            throw new NullPointerException("other should not be null");
        }

        return new ValidationAnd(this, other);
    }

    // end and

    /**
     * <p>
     * <strong>Purpose: </strong>This method provides an 'or' type of operator to algorithms.&nbsp; This method will
     * return a <em>AbstractValidationAlgorithm </em> that can perform an 'or' operation between the 'this' and
     * another algorithm.
     * </p>
     *
     * <p>
     * <strong>Typical Args: a </strong> non-null <em>ValidationAlgorithm </em>
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong> a non-null <em>ValidationAlgorithm </em>
     * </p>
     *
     * @param other a non-null ValidationAlgorithm
     *
     * @return a non-null ValidationAlgorithm
     *
     * @throws NullPointerException if the parameter is null
     */
    public AbstractValidationAlgorithm or(ValidationAlgorithm other) {
        if (other == null) {
            throw new NullPointerException("other should not be null");
        }

        return new ValidationOr(this, other);
    }

    // end or

    /**
     * <p>
     * <strong>Purpose: </strong>This method provides an 'not' type of operator to algorithms.&nbsp; This method will
     * return a <em>AbstractValidationAlgorithm </em> that can perform an 'not' operation on this algorithm
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong> a non-null <em>ValidationAlgorithm </em>
     * </p>
     *
     * @return a non-null ValidationAlgorithm
     */
    public AbstractValidationAlgorithm not() {
        return new ValidationNot(this);
    }

    // end not
}

// end AbstractValidationAlgorithm
