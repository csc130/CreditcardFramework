/*
 * ComponentName: CreditCardValidation
 * FileName: CreditCardValidatorRegistryTest.java
 * Version: 1.0
 * Date: 10/28/2004
 *
 * <p>Copyright (c) 2004, TopCoder, Inc. All rights reserved</p>
 */

package com.topcoder.ecommerce.creditcard.validation.accuracytests;

import com.topcoder.ecommerce.creditcard.validation.*;
import com.topcoder.util.config.ConfigManagerException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This class contains the accuracy unit tests for CreditCardValidatorRegistry.java</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class CreditCardValidatorRegistryTest extends TestCase {

    /**
     * <p>
     * Represents an instance of CreditCardValidatorRegistry to be used for testing.</p>
     */
    private CreditCardValidatorRegistry reg1 = null;
    
    /**
     * <p>
     * Represents an instance of CreditCardValidatorRegistry to be used for testing.</p>
     */
    private CreditCardValidatorRegistry reg2 = null;

    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public CreditCardValidatorRegistryTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Sets up the fixture.</p>
     * 
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        ConfigHelper.initialConfigManager();
        reg1 = new CreditCardValidatorRegistry();
        reg2 = new CreditCardValidatorRegistry(true);
        
    } // end setUp()

    /**
     *<p>
     * Tears down the fixture.</p>
     */
    protected void tearDown() {
        // do nothing here
    } // end tearDown()

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(CreditCardValidatorRegistryTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the constructor CreditCardValidatorRegistry(). 
     * Check out non-null instance of this class here</p>
     *
     * @throws ConfigManagerException to JUnit
     * @throws ClassNotFoundException to JUnit
     * @throws IllegalAccessException to JUnit
     * @throws InstantiationException to JUnit
     */
    public void testConstructorAccuracy() throws ConfigManagerException, 
                                    ClassNotFoundException, IllegalAccessException, 
                                    InstantiationException {
        assertNotNull("should not be null", this.reg1);
        
    } // end testConstructorAccuracy()

    /**
     *<p>
     * Tests accuracy of the constructor CreditCardValidatorRegistry(boolean useConfiguration)</p>
     *
     * @throws ConfigManagerException to JUnit
     * @throws ClassNotFoundException to JUnit
     * @throws IllegalAccessException to JUnit
     * @throws InstantiationException to JUnit
     */
    public void testConstructorTwoAccuracy() throws ConfigManagerException, 
                                    ClassNotFoundException, 
                                    IllegalAccessException, InstantiationException {
        assertNotNull("Should not be null.", this.reg2);
    } // end testConstructorTwoAccuracy()

    /**
     *<p>
     * Tests accuracy of the method getInstance(). Simply return instance without 
     * catching all the exceptions defined by this component.</p>
     *
     * @throws Exception to JUnit
     * 
     */
    public void testGetInstanceAccuracy() throws Exception {
        assertNotNull("non-null should be returned", CreditCardValidatorRegistry.getInstance());
    } // end testGetInstanceAccuracy()

    /**
     *<p>
     * Tests accuracy of the method addCreditCardValidator(CreditCardValidator validator). 
     * Add the validtor MasterCardValidtor with the default identifier</p>
     *
     * @throws NullPointerException to JUnit
     */
    public void testAddCreditCardValidatorAccuracy() throws NullPointerException {
        CreditCardValidator vd = new MasterCardValidator();
        this.reg1.addCreditCardValidator(vd);
        assertSame("two validtors should be the same.", vd, 
                this.reg1.getCreditCardValidator(vd.getDefaultIdentifier()));
    } // end testAddCreditCardValidatorAccuracy()

    /**
     *<p>
     * Tests accuracy of the method addCreditCardValidator(String identifier, CreditCardValidator validator). 
     * Add the validtor MasterCardValidtor with the default identifier 'master_accruacyTests'</p>
     *
     */
    public void testAddCreditCardValidatorTwoAccuracy() {
        CreditCardValidator vd = new MasterCardValidator();
        this.reg1.addCreditCardValidator("master_accruacyTests", vd);
        assertSame("two validtors should be the same.", vd, 
                this.reg1.getCreditCardValidator("master_accruacyTests"));
    } // end testAddCreditCardValidatorTwoAccuracy()

    /**
     *<p>
     * Tests accuracy of the method getCreditCardValidators(). Check the validators 
     * created from the configuration file</p>
     *
     * @throws Exception to JUnit
     */
    public void testGetCreditCardValidatorsAccuracy() throws Exception {
        assertTrue(CreditCardValidatorRegistry.getInstance().getCreditCardValidators().
                get("Visa") instanceof VisaValidator);
        assertTrue(CreditCardValidatorRegistry.getInstance().getCreditCardValidators().
                get("Discover") instanceof DiscoverValidator);
    } // end testGetCreditCardValidatorsAccuracy()

    /**
     *<p>
     * Tests accuracy of the method getCreditCardValidator(String identifier). 
     * get the 'AmericanExpress' card type from the getInstance()</p>
     *
     * @throws Exception to JUnit
     */
    public void testGetCreditCardValidatorAccuracy() throws Exception {
        assertTrue(CreditCardValidatorRegistry.getInstance().getCreditCardValidator("AmericanExpress") 
                instanceof AmericanExpressValidator);
    } // end testGetCreditCardValidatorAccuracy()

    /**
     *<p>
     * Tests accuracy of the method removeCreditCardValidator(String identifier)</p>
     *
     */
    public void testRemoveCreditCardValidatorAccuracy() {
        CreditCardValidator vd = new VisaValidator();
        this.reg1.clearCreditCardValidators();
        this.reg1.addCreditCardValidator(vd);
        assertTrue(this.reg1.getCreditCardValidators().size() == 1);
        this.reg1.removeCreditCardValidator(vd.getDefaultIdentifier());
        assertTrue(this.reg1.getCreditCardValidators().size() == 0);
    } // end testRemoveCreditCardValidatorAccuracy()

    /**
     *<p>
     * Tests accuracy of the method clearCreditCardValidators()</p>
     *
     */
    public void testClearCreditCardValidatorsAccuracy() {
        // trivial testcase
        assertNotNull("Should not be null", this.reg2.getCreditCardValidator("Visa"));
        this.reg2.clearCreditCardValidators();
        assertNull("Should be null", this.reg2.getCreditCardValidator("Visa"));
    } // end testClearCreditCardValidatorsAccuracy()

    /**
     *<p>
     * Tests accuracy of the method validate(String creditCardText)</p>
     *
     * @throws Exception to JUnit
     */
    public void testValidateAccuracy1() throws Exception {
        CreditCardValidatorRegistry reg = CreditCardValidatorRegistry.getInstance();
        
        // validate Visa card with good card#
        assertTrue(reg.validate("4515310023788980").size() == 1);
        assertTrue(reg.validate("4930761787963").get(0).equals("Visa"));
        
        // with bad card#
        assertTrue(reg.validate("4250047578210079").size() == 0);
    } // end testValidateAccuracy()
    
    /**
     *<p>
     * Tests accuracy of the method validate(String creditCardText)</p>
     *
     * @throws Exception to JUnit
     */
    public void testValidateAccuracy2() throws Exception {
        CreditCardValidatorRegistry reg = CreditCardValidatorRegistry.getInstance();
        
        // validate Discover card with good card#
        assertTrue(reg.validate("6011371229724264").size() == 1);
        assertTrue(reg.validate("6011128301084375").get(0).equals("Discover"));
        
        // with bad card#
        assertTrue(reg.validate("6011112393877224").size() == 0);
    } // end testValidateAccuracy()
    
    /**
     *<p>
     * Tests accuracy of the method validate(String creditCardText)</p>
     *
     * @throws Exception to JUnit
     */
    public void testValidateAccuracy3() throws Exception {
        CreditCardValidatorRegistry reg = CreditCardValidatorRegistry.getInstance();
        
        // validate DinersClub card with good card#
        assertTrue(reg.validate("38992483364638").size() == 1);
        assertTrue(reg.validate("36561040405242").get(0).equals("DinersClub"));
        
        // bad card#
        assertTrue(reg.validate("36380314448492").size() == 0);
    } // end testValidateAccuracy()
    
    /**
     *<p>
     * Tests accuracy of the method validate(String creditCardText)</p>
     *
     * @throws Exception to JUnit
     */
    public void testValidateAccuracy4() throws Exception {
        CreditCardValidatorRegistry reg = CreditCardValidatorRegistry.getInstance();
        
        // validate Master card with good card#
        assertTrue(reg.validate("5153454098838082").size() == 1);
        assertTrue(reg.validate("5578408056312883").get(0).equals("MasterCard"));
        
        // with bad card#
        assertTrue(reg.validate("5520853468563153").size() == 0);
    } // end testValidateAccuracy()
    
    /**
     *<p>
     * Tests accuracy of the method validate(String creditCardText)</p>
     *
     * @throws Exception to JUnit
     */
    public void testValidateAccuracy5() throws Exception {
        CreditCardValidatorRegistry reg = CreditCardValidatorRegistry.getInstance();
        
        // validate JCB card with good card# 
        assertTrue(reg.validate("3645805137405582").size() == 1);
        assertTrue(reg.validate("213118003771402").get(0).equals("JCB"));
        
        // with bad card#
        assertTrue(reg.validate("5520853468563153").size() == 0);
    } // end testValidateAccuracy()
    
    /**
     *<p>
     * Tests accuracy of the method validate(String creditCardText)</p>
     *
     * @throws Exception to JUnit
     */
    public void testValidateAccuracy6() throws Exception {
        CreditCardValidatorRegistry reg = CreditCardValidatorRegistry.getInstance();
        
        // validate AmericanExpress card with good card#
        assertTrue(reg.validate("344648673015039").size() == 1);
        assertTrue(reg.validate("379152978702498").get(0).equals("AmericanExpress"));
        
        // bad card#
        assertTrue(reg.validate("372411110507234").size() == 0);
    } // end testValidateAccuracy()

} // end CreditCardValidatorRegistryTest
