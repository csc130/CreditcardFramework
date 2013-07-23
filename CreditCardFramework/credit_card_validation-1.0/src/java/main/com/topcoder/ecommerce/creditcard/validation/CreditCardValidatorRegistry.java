/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * <strong>Purpose: </strong>Acts as a registry for all the <em>CreditCardValidators</em> that are defined by this
 * component and/or the application and can be initialized from a configuration file.&nbsp; The validators contained
 * within this class are mutatable by the application.
 * </p>
 *
 * <p>
 * <strong>Thread Safety </strong>: because the registry can be potentially used in a singleton mode and is mutatable,
 * thread safety needs to be addressed.&nbsp; A lock should be obtained/released on the <em>creditCardValidators </em>
 * variable when being accessed.
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class CreditCardValidatorRegistry {
    /**
     * <p>
     * <strong>Purpose: </strong>represents the singleton instance of the registry.
     * </p>
     */
    private static CreditCardValidatorRegistry instance = null;

    ///////////////////////////////////////
    // attributes

    /**
     * <p>
     * <strong>Purpose: </strong>represents the <em>CreditCardValidators </em> that are defined in this registry.&nbsp;
     * The key will be an application defined (of default) identifier for the validator (which is the value).
     * </p>
     */
    private Map creditCardValidators = new HashMap();

    ///////////////////////////////////////
    // operations

    /**
     * <p>
     * <strong>Purpose: </strong>Creates an instance of the registry retrieving a default list of validators from the
     * configuration file.
     * </p>
     *
     * @throws UnknownNamespaceException thrown by configuration manager
     * @throws InstantiationException thrown when instantiating classes
     * @throws IllegalAccessException thrown when instantiating classes
     * @throws ClassNotFoundException thrown when instantiating classes
     */
    public CreditCardValidatorRegistry()
        throws UnknownNamespaceException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        this(true);
    }

    // end CreditCardValidatorRegistry

    /**
     * <p>
     * <strong>Purpose: </strong>Creates an instance of the registry retrieving a default list of validators from the
     * configuration file if specified (see component specification for a listing of the configuration).
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>true to load the default validators, false otherwise
     * </p>
     *
     * @param useConfiguration true to load the default validators from the configuration file, false to start empty
     *
     * @throws UnknownNamespaceException thrown by configuration manager
     * @throws InstantiationException thrown when instantiating classes
     * @throws IllegalAccessException thrown when instantiating classes
     * @throws ClassNotFoundException thrown when instantiating classes
     * @throws ClassCastException thrown when casting created instance into CreditCardValidator
     */
    public CreditCardValidatorRegistry(boolean useConfiguration)
        throws UnknownNamespaceException, InstantiationException, IllegalAccessException, ClassNotFoundException,
            ClassCastException {
        if (useConfiguration) {
            ConfigManager manager = ConfigManager.getInstance();
            String namespace = CreditCardValidatorRegistry.class.getName();

            //get all the names
            Enumeration names = manager.getPropertyNames(namespace);

            //iterate over all the properties
            while (names.hasMoreElements()) {
                String id = (String) names.nextElement();
                String validator = manager.getString(namespace, id);
                this.creditCardValidators.put(id, (CreditCardValidator) Class.forName(validator).newInstance());
            }
        }
    }

    // end CreditCardValidatorRegistry

    /**
     * <p>
     * <strong>Purpose: </strong>returns the singleton instance of the registry.&nbsp; If this is the first time it is
     * called, the registry will automatically be loaded from the configuration file.
     * </p>
     *
     * <p>
     * <strong>Typical Return values: </strong>a non-null registry (loaded with defaults if the first time called)
     * </p>
     *
     * @return a non-null registry (loaded with defaults if the first time called)
     *
     * @throws UnknownNamespaceException thrown by configuration manager
     * @throws InstantiationException thrown when instantiating classes
     * @throws IllegalAccessException thrown when instantiating classes
     * @throws ClassNotFoundException thrown when instantiating classes
     */
    public static CreditCardValidatorRegistry getInstance()
        throws UnknownNamespaceException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        if (CreditCardValidatorRegistry.instance == null) {
            //create the instance with default constructor
            CreditCardValidatorRegistry.instance = new CreditCardValidatorRegistry();
        }

        return CreditCardValidatorRegistry.instance;
    }

    // end getInstance

    /**
     * <p>
     * <strong>Purpose: </strong>adds a new <em>CreditCardValidator </em> to the registry using the default identifier.
     * </p>
     *
     * @param validator a non-null validator to add to the registry
     *
     * @throws NullPointerException if the validator is null
     */
    public void addCreditCardValidator(CreditCardValidator validator) {
        if (validator == null) {
            throw new NullPointerException("validator should not be null");
        }

        addCreditCardValidator(validator.getDefaultIdentifier(), validator);
    }

    // end addCreditCardValidator

    /**
     * <p>
     * <strong>Purpose: </strong>adds a new <em>CreditCardValidator </em> to the registry associating it with the
     * <em>Identifier.</em>
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a non-null, non-empty identifier and a non-null validator
     * </p>
     *
     * @param identifier a non-null, non-empty identifier
     * @param validator a non-null validator to add to the registry
     *
     * @throws NullPointerException if either parameter is null
     * @throws IllegalArgumentException if identifier is an empty string
     */
    public void addCreditCardValidator(String identifier, CreditCardValidator validator) {
        if (identifier == null) {
            throw new NullPointerException("identifier should not be null");
        }

        if (identifier.trim().length() == 0) {
            throw new IllegalArgumentException("identifier should not be empty");
        }

        if (validator == null) {
            throw new NullPointerException("validator should not be null");
        }

        synchronized (this.creditCardValidators) {
            this.creditCardValidators.put(identifier, validator);
        }
    }

    // end addCreditCardValidator

    /**
     * <p>
     * <strong>Purpose: </strong>returns a map of <em>CreditCardValidators </em> that are registered with this class,
     * where the associated identifier is the key.
     * </p>
     *
     * <p>
     * <strong>Typical Return value:&nbsp; </strong>a non-null, possibly-empty map of <em>CreditCardValidators</em>
     * </p>
     *
     * @return a non-null, possibly-empty map of CreditCardValidators
     */
    public Map getCreditCardValidators() {
        synchronized (this.creditCardValidators) {
            return new HashMap(this.creditCardValidators);
        }
    }

    // end getCreditCardValidators

    /**
     * <p>
     * <strong>Purpose: </strong>returns a the <em>CreditCardValidators </em> that is associated with the
     * <em>Identifier</em>
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a non-null, non-empty string representing the identifier
     * </p>
     *
     * <p>
     * <strong>Typical Return value:&nbsp; </strong> the <em>CreditCardValidator </em> associated with the
     * <em>identifier </em> or null if none found
     * </p>
     *
     * @param identifier the CreditCardValidator associated with the Identifier or null if none found
     *
     * @return the validator associated with the identifier
     *
     * @throws NullPointerException if Identifier is null
     * @throws IllegalArgumentException if Identifier is an empty string
     */
    public CreditCardValidator getCreditCardValidator(String identifier) {
        if (identifier == null) {
            throw new NullPointerException("identifier should not be null");
        }

        if (identifier.trim().length() == 0) {
            throw new IllegalArgumentException("identifier should not be empty");
        }

        synchronized (this.creditCardValidators) {
            return (CreditCardValidator) this.creditCardValidators.get(identifier);
        }
    }

    // end getCreditCardValidator

    /**
     * <p>
     * <strong>Purpose: </strong>removes the <em>CreditCardValidators </em> that is associated with the <em>Identifier
     * </em> from this registry
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a non-null, non-empty string representing the identifier
     * </p>
     *
     * @param identifier the identifier of the CreditCardValidator to remove
     *
     * @throws NullPointerException if identifier is null
     * @throws IllegalArgumentException if identifier is an empty string
     */
    public void removeCreditCardValidator(String identifier) {
        if (identifier == null) {
            throw new NullPointerException("identifier should not be null");
        }

        if (identifier.trim().length() == 0) {
            throw new IllegalArgumentException("identifier should not be empty");
        }

        synchronized (this.creditCardValidators) {
            this.creditCardValidators.remove(identifier);
        }
    }

    // end removeCreditCardValidator

    /**
     * <p>
     * <strong>Purpose: </strong>removes all <em>CreditCardValidators </em> from this registry
     * </p>
     */
    public void clearCreditCardValidators() {
        synchronized (this.creditCardValidators) {
            this.creditCardValidators.clear();
        }
    }

    // end clearCreditCardValidators

    /**
     * <p>
     * <strong>Purpose: </strong>This method will validate the given credit card text against <strong>all
     * </strong><em>CreditCardValidators</em> that are registered and return a list of strings that identify the
     * credit card the text is valid for.
     * </p>
     *
     * <p>
     * <strong>Typical Args: </strong>a text string - possibly null, possibly empty with no validation done in this
     * method.
     * </p>
     *
     * <p>
     * <strong>Typical Return value: </strong>a non-null, possibly empty list of string identities that the given text
     * is valid for.
     * </p>
     *
     * @param creditCardText a non-null, possibly empty list of string identities that the given text is
     *
     * @return a non-null, possibly empty list of string identities that the given text is valid for
     */
    public List validate(String creditCardText) {
        ArrayList ret = new ArrayList();

        synchronized (this.creditCardValidators) {
            //iterator over all validators
            Iterator it = this.creditCardValidators.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();
                CreditCardValidator validator = (CreditCardValidator) entry.getValue();

                if (validator.isValid(creditCardText)) {
                    ret.add(key);
                }
            }
        }

        return ret;
    }

    // end validate
}

// end CreditCardValidatorRegistry
