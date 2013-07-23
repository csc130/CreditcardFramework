/*
 * Copyright (C) 2004 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.ecommerce.creditcard.validation;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

import junit.framework.TestCase;

import java.io.File;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * Unit test for CreditCardValidatorRegistry class
 * </p>
 *
 * @author Pops, TCSDEVELOPER
 * @version 1.0
 */
public class TestCreditCardValidatorRegistry extends TestCase {
    /** The CreditCardValidatorRegistry instance used for test */
    private CreditCardValidatorRegistry registry = null;

    /**
     * setup environment
     *
     * @throws Exception if any exception occurs during setup
     */
    protected void setUp() throws Exception {
        ConfigManager.getInstance().add(CreditCardValidatorRegistry.class.getName(),
            new File("test_files/validconfig.properties").getAbsolutePath(), ConfigManager.CONFIG_PROPERTIES_FORMAT);
        this.registry = new CreditCardValidatorRegistry();
    }

    /**
     * restore environment
     */
    protected void tearDown() {
        try {
            ConfigManager.getInstance().removeNamespace(CreditCardValidatorRegistry.class.getName());
        } catch (UnknownNamespaceException e) {
            //if the namespace is already removed, just ignore this exception
        }
    }

    /**
     * Functional test of CreditCardValidatorRegistry()
     */
    public void testDefaultConstructor() {
        //if validators is not empty, it means configuration is used
        assertNotNull("test1", this.registry.getCreditCardValidator("AmericanExpress"));
    }

    /**
     * Functional test of CreditCardValidatorRegistry(boolean useConfiguration)
     *
     * @throws Exception if any exception occurs during test
     */
    public void testConstructorBoolean() throws Exception {
        //do not use configuration
        this.registry = new CreditCardValidatorRegistry(false);

        //not validator should be put into map
        assertEquals("test1", 0, this.registry.getCreditCardValidators().size());

        //use configuration
        this.registry = new CreditCardValidatorRegistry(true);

        //iterate over the validators and put all validator classes into a
        // HashSet
        Iterator it = this.registry.getCreditCardValidators().values().iterator();
        HashSet validators = new HashSet();

        while (it.hasNext()) {
            validators.add(it.next().getClass());
        }

        //the result should contain all implemented credit card validator, and
        // vice versa
        List allValidators = Arrays.asList(new Class[] {
                    AmericanExpressValidator.class, DinersClubValidator.class, DiscoverValidator.class,
                    JCBValidator.class, MasterCardValidator.class, VisaValidator.class
                });
        assertTrue(validators.containsAll(allValidators));
        assertTrue(allValidators.containsAll(validators));
    }

    /**
     * Test CreditCardValidatorRegistry(boolean useConfiguration) without required namespace, UnknownNamespaceException
     * expected
     *
     * @throws Exception if any exception occurs during test
     */
    public void testConstructorBooleanWithoutRequiredNamespace()
        throws Exception {
        try {
            ConfigManager.getInstance().removeNamespace(CreditCardValidatorRegistry.class.getName());
            new CreditCardValidatorRegistry(true);
            fail("UnknownNamespaceException expected");
        } catch (UnknownNamespaceException e) {
        }
    }

    /**
     * Test CreditCardValidatorRegistry(boolean useConfiguration) with invalid class name, ClassNotFoundException
     * expected
     *
     * @throws Exception if any exception occurs during test
     */
    public void testConstructorBooleanWithInvalidClassName()
        throws Exception {
        try {
            ConfigManager.getInstance().removeNamespace(CreditCardValidatorRegistry.class.getName());
            ConfigManager.getInstance().add(CreditCardValidatorRegistry.class.getName(),
                new File("test_files/nosuchclass.properties").getAbsolutePath(), ConfigManager.CONFIG_PROPERTIES_FORMAT);
            new CreditCardValidatorRegistry(true);
            fail("ClassNotFoundException expected");
        } catch (ClassNotFoundException e) {
        }
    }

    /**
     * Test CreditCardValidatorRegistry(boolean useConfiguration) with invalid class(not instance of
     * CreditCardValidator, ClassCastException expected
     *
     * @throws Exception if any exception occurs during test
     */
    public void testConstructorBooleanWithInvalidClass()
        throws Exception {
        try {
            ConfigManager.getInstance().removeNamespace(CreditCardValidatorRegistry.class.getName());
            ConfigManager.getInstance().add(CreditCardValidatorRegistry.class.getName(),
                new File("test_files/notvalidator.properties").getAbsolutePath(), ConfigManager.CONFIG_PROPERTIES_FORMAT);
            new CreditCardValidatorRegistry(true);
            fail("ClassCastException expected");
        } catch (ClassCastException e) {
        }
    }

    /**
     * Functional test of CreditCardValidatorRegistry getInstance()
     *
     * @throws Exception if any exception occurs during test
     */
    public void testGetInstance() throws Exception {
        //two calls to getInstance() should return the same instance
        assertEquals("test1", CreditCardValidatorRegistry.getInstance(), CreditCardValidatorRegistry.getInstance());
    }

    /**
     * Functional test of void addCreditCardValidator(CreditCardValidator validator)
     */
    public void testAddCreditCardValidatorCreditCardValidator() {
        CreditCardValidator validator = new CustomValidator("test");
        this.registry.addCreditCardValidator(validator);
        assertEquals("test1", validator, this.registry.getCreditCardValidator("test"));
    }

    /**
     * Test void addCreditCardValidator(CreditCardValidator validator) will null validator, NullPointerException
     * expected
     */
    public void testAddCreditCardValidatorCreditCardValidatorWithNullValidator() {
        try {
            this.registry.addCreditCardValidator(null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Functional test of void addCreditCardValidator(String identifier, CreditCardValidator validator)
     */
    public void testAddCreditCardValidatorStringCreditCardValidator() {
        CreditCardValidator validator = new CustomValidator("test");
        this.registry.addCreditCardValidator("abc", validator);
        assertEquals("test1", validator, this.registry.getCreditCardValidator("abc"));
    }

    /**
     * Test void addCreditCardValidator(String identifier, CreditCardValidator validator) will null identifier,
     * NullPointerException expected
     */
    public void testAddCreditCardValidatorStringCreditCardValidatorWithNullIdentifier() {
        try {
            CreditCardValidator validator = new CustomValidator("test");
            this.registry.addCreditCardValidator(null, validator);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test void addCreditCardValidator(String identifier, CreditCardValidator validator) will empty identifier,
     * IllegalArgumentException expected
     */
    public void testAddCreditCardValidatorStringCreditCardValidatorWithEmptyIdentifier() {
        try {
            CreditCardValidator validator = new CustomValidator("test");
            this.registry.addCreditCardValidator("   ", validator);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test void addCreditCardValidator(String identifier, CreditCardValidator validator) will null validator,
     * NullPointerException expected
     */
    public void testAddCreditCardValidatorStringCreditCardValidatorWithNullValidator() {
        try {
            this.registry.addCreditCardValidator("test", null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Functional test of Map getCreditCardValidators()
     */
    public void testGetCreditCardValidators() {
        Map validators = this.registry.getCreditCardValidators();

        //it should not be empty according to default configuration file
        assertTrue("test1", validators.size() > 0);

        //check whether modification to the result will influence the inner map
        validators.clear();
        assertTrue("test2", this.registry.getCreditCardValidators().size() > 0);
    }

    /**
     * Functional test of CreditCardValidator getCreditCardValidator(String identifier)
     */
    public void testGetCreditCardValidator() {
        CreditCardValidator validator = new CustomValidator("test");
        this.registry.addCreditCardValidator("abc", validator);
        assertEquals("test1", validator, this.registry.getCreditCardValidator("abc"));
    }

    /**
     * Test CreditCardValidator getCreditCardValidator(String identifier) with null identifier, NullPointerException
     * expected
     */
    public void testGetCreditCardValidatorWithNullIdentifier() {
        try {
            this.registry.getCreditCardValidator(null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test CreditCardValidator getCreditCardValidator(String identifier) with empty identifier,
     * IllegalArgumentException expected
     */
    public void testGetCreditCardValidatorWithEmptyIdentifier() {
        try {
            this.registry.getCreditCardValidator("   ");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Functional test of CreditCardValidator removeCreditCardValidator(String identifier)
     */
    public void testRemoveCreditCardValidator() {
        //assure that VisaValidator exists
        assertNotNull("test1", this.registry.getCreditCardValidator(VisaValidator.IDENTIFIER));
        this.registry.removeCreditCardValidator(VisaValidator.IDENTIFIER);

        //check whether it has been removed
        assertNull("test2", this.registry.getCreditCardValidator(VisaValidator.IDENTIFIER));
    }

    /**
     * Test CreditCardValidator removeCreditCardValidator(String identifier) with null identifier, NullPointerException
     * expected
     */
    public void testRemoveCreditCardValidatorWithNullIdentifier() {
        try {
            this.registry.removeCreditCardValidator(null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
        }
    }

    /**
     * Test CreditCardValidator removeCreditCardValidator(String identifier) with empty identifier,
     * IllegalArgumentException expected
     */
    public void testRemoveCreditCardValidatorWithEmptyIdentifier() {
        try {
            this.registry.removeCreditCardValidator("   ");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Functional test of void clearCreditCardValidators()
     */
    public void testClearCreditCardValidators() {
        this.registry.clearCreditCardValidators();
        assertEquals("test1", 0, this.registry.getCreditCardValidators().size());
    }

    /**
     * Functional test of List validate(String creditCardText)
     */
    public void testValidate() {
        List result = null;

        //visa
        result = this.registry.validate("4111111111111111");
        assertEquals("test1 size", 1, result.size());
        assertEquals("test1 content", VisaValidator.IDENTIFIER, result.get(0));

        //master card
        result = this.registry.validate("5500000000000004");
        assertEquals("test2 size", 1, result.size());
        assertEquals("test2 content", MasterCardValidator.IDENTIFIER, result.get(0));

        //american express
        result = this.registry.validate("340000000000009");
        assertEquals("test3 size", 1, result.size());
        assertEquals("test3 content", AmericanExpressValidator.IDENTIFIER, result.get(0));

        //diner's club
        result = this.registry.validate("30000000000004");
        assertEquals("test4 size", 1, result.size());
        assertEquals("test4 content", DinersClubValidator.IDENTIFIER, result.get(0));

        //discover
        result = this.registry.validate("6011000000000004");
        assertEquals("test5 size", 1, result.size());
        assertEquals("test5 content", DiscoverValidator.IDENTIFIER, result.get(0));

        //jcb
        result = this.registry.validate("3088000000000009");
        assertEquals("test6 size", 1, result.size());
        assertEquals("test6 content", JCBValidator.IDENTIFIER, result.get(0));

        //none
        result = this.registry.validate("");
        assertEquals("test7", 0, result.size());
    }
}
