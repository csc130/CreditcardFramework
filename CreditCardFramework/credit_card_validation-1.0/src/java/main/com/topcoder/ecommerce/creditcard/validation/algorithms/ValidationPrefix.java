/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation.algorithms;

/**
 * <p>
 * <strong>Purpose: </strong>an subclass of <em>ValidationRange </em> that specifically checks for a prefix.&nbsp; This
 * is a utility/helper class to more easily define prefixes.
 * </p>
 *
 * <p>
 * This class is thread safe because all attributes are immutable
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class ValidationPrefix extends ValidationRange {
    ///////////////////////////////////////
    // attributes

    /**
     * <p>
     * <strong>Purpose: </strong>a constant representing the prefix for the Major Industry Identity prefix for 'ISO/TC
     * 68 and other industry assignments'
     * </p>
     */
    public static final String MII_OTHER = "0";

    /**
     * <p>
     * <strong>Purpose: </strong>a constant representing the prefix for the Major Industry Identity prefix for
     * 'Airlines'
     * </p>
     */
    public static final String MII_AIRLINES = "1";

    /**
     * <p>
     * <strong>Purpose: </strong>a constant representing the prefix for the Major Industry Identity prefix for
     * 'Airlines and other industry assignments'
     * </p>
     */
    public static final String MII_AIRLINES_OTHER = "2";

    /**
     * <p>
     * <strong>Purpose: </strong>a constant representing the prefix for the Major Industry Identity prefix for 'Travel
     * and Entertainment'
     * </p>
     */
    public static final String MII_TRAVEL_ENT = "3";

    /**
     * <p>
     * <strong>Purpose: </strong>a constant representing the prefix for the Major Industry Identity prefix for 'Banking
     * and financial'
     * </p>
     */
    public static final String MII_BANKING1 = "4";

    /**
     * <p>
     * <strong>Purpose: </strong>a constant representing the <em>another</em> prefix for the Major Industry Identity
     * prefix for 'Banking and financial'
     * </p>
     */
    public static final String MII_BANKING2 = "5";

    /**
     * <p>
     * <strong>Purpose: </strong>a constant representing the prefix for the Major Industry Identity prefix for
     * 'Merchandizing and Banking'
     * </p>
     */
    public static final String MII_MERCHANDIZING = "6";

    /**
     * <p>
     * <strong>Purpose: </strong>a constant representing the prefix for the Major Industry Identity prefix for
     * 'Petroleum'
     * </p>
     */
    public static final String MII_PETROLEUM = "7";

    /**
     * <p>
     * <strong>Purpose: </strong>a constant representing the prefix for the Major Industry Identity prefix for
     * 'Telecommunications and other industry assignments'
     * </p>
     */
    public static final String MII_TELECOMMUNICATIONS = "8";

    /**
     * <p>
     * <strong>Purpose: </strong>a constant representing the prefix for the Major Industry Identity prefix for
     * 'National assignments'
     * </p>
     */
    public static final String MII_NATIONAL = "9";

    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong>creates an instance of the <em>ValidationPrefix</em> class that will validate a single
     * prefix.&nbsp; .
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a non-null, non-empty string
     * </p>
     *
     * @param prefix a non-null, non-empty string
     */
    public ValidationPrefix(String prefix) {
        super(prefix, prefix, 1);
    }

    // end ValidationPrefix

    /**
     * <p>
     * <strong>Purpose: </strong>creates an instance of the <em>ValidationPrefix</em> class that will validate a range
     * of prefixs.&nbsp; &nbsp;
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
     * </ol>
     *
     * <p></p>
     *
     * @param startPrefix A non-null, non-empty string
     * @param endPrefix A non-null, non-empty string
     */
    public ValidationPrefix(String startPrefix, String endPrefix) {
        super(startPrefix, endPrefix, 1);
    }

    // end ValidationPrefix
}

// end ValidationPrefix
