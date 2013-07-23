/*
 * ComponentName: CreditCardValidation
 * FileName: ValidationRangeTest.java
 * Version: 1.0
 * Date: 10/28/2004
 *
 * <p>Copyright (c) 2004, TopCoder, Inc. All rights reserved</p>
 */

package com.topcoder.ecommerce.creditcard.validation.accuracytests.algorithms;

import com.topcoder.ecommerce.creditcard.validation.algorithms.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This class contains the accuracy unit tests for ValidationRange.java</p>
 *
 * @author woodjhon
 * @version 1.0
 */
public class ValidationRangeTest extends TestCase {

    /**
     * <p>
     * Represents an instance of ValidationRange to be used for testing.</p>
     */
    private ValidationRange rand1 = new ValidationRange("9559", "9569", 1);
    
    /**
     * <p>
     * Represents an instance of ValidationRange to be used for testing.</p>
     */
    private ValidationRange rand3 = new ValidationRange("9559", "9569", 3);
    
    /**
     * <p>
     * Represents an instance of ValidationRange to be used for testing.</p>
     */
    private ValidationRange randChar = new ValidationRange("aaaa", "cccc", 1);

    /**
     * <p>
     * Creates an instance for the Test.</p>
     *
     * @param name the name of the TestCase.
     */
    public ValidationRangeTest(String name) {
        super(name);
    }

    /**
     *<p>
     * Creates a test suite of the tests contained in this class.</p>
     *
     * @return a test suite of the tests contained in this class.
     */
    public static Test suite() {
        return new TestSuite(ValidationRangeTest.class);
    } // end suite()

    /**
     *<p>
     * Tests accuracy of the 
     * constructor ValidationRange(String startPrefix, String endPrefix, int position) 
     * Simply check if we create two instances successfully.</p>
     *
     */
    public void testConstructorAccuracy() {
        assertNotNull("should not be null", this.rand1);
        assertNotNull("should not be null", this.rand3);
    } // end testConstructorAccuracy()

    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * Tests true case for this.rand1</p>
     *
     */
    public void testIsValidAccuracy1() {
        assertTrue(this.rand1.isValid("9559"));
        assertTrue(this.rand1.isValid("9569"));
        assertTrue(this.rand1.isValid("9567"));
        
        assertTrue(this.rand1.isValid("9567758963dd"));
    } // end testIsValidAccuracy1()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * Tests true case for this.rand1</p>
     *
     */
    public void testIsValidAccuracy2() {
        assertTrue(this.rand3.isValid("129559"));
        assertTrue(this.rand3.isValid("459569"));
        assertTrue(this.rand3.isValid("789567"));
        
        assertTrue(this.rand3.isValid("349567758963"));
    } // end testIsValidAccuracy2()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * Test false case for this.rand1</p>
     *
     */
    public void testIsValidAccuracy3() {
        assertFalse(this.rand1.isValid("9449"));
        assertFalse(this.rand1.isValid("9949"));
        assertFalse(this.rand1.isValid("19949"));
    } // end testIsValidAccuracy3()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * Test false case for this.rand3</p>
     *
     */
    public void testIsValidAccuracy4() {
        assertFalse(this.rand3.isValid("19449gg"));
        assertFalse(this.rand3.isValid("1119560g"));
        assertFalse(this.rand3.isValid("19949gg"));
    } // end testIsValidAccuracy4()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * Test false and true case for this.randChar</p>
     *
     */
    public void testIsValidAccuracy5() {
        assertFalse(this.randChar.isValid("DDDDDD"));
        assertFalse(this.randChar.isValid("00000"));
        
        assertTrue(this.randChar.isValid("bbbb"));
    } // end testIsValidAccuracy4()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * Test null creditCardTest for this.rand1 and this.rand3</p>
     *
     */
    public void testIsValidAccuracy6_null() {
        assertFalse(this.rand1.isValid(null));
        assertFalse(this.rand3.isValid(null));
    } // end testIsValidAccuracy4()
    
    /**
     *<p>
     * Tests accuracy of the method isValid(String creditCardText). 
     * Test empty creditCardTest for this.rand1 and this.rand3</p>
     *
     */
    public void testIsValidAccuracy7_empty() {
        assertFalse(this.rand1.isValid(""));
        assertFalse(this.rand3.isValid(""));
    } // end testIsValidAccuracy4()

    /**
     *<p>
     * Tests accuracy of the method getPosition(). Get the position of 
     * this.rand1 and this.rand3.</p>
     *
     */
    public void testGetPositionAccuracy() {
        assertTrue(this.rand1.getPosition() == 1);
        assertTrue(this.rand3.getPosition() == 3);
    } // end testGetPositionAccuracy()

    /**
     *<p>
     * Tests accuracy of the method getStartPrefix(). Get the sart prefix 
     * of this.rand1 and this.rand3. "9559" is are expected</p>
     *
     */
    public void testGetStartPrefixAccuracy() {
        assertTrue("9559".equals(this.rand1.getStartPrefix()));
        assertTrue("9559".equals(this.rand1.getStartPrefix()));
    } // end testGetStartPrefixAccuracy()

    /**
     *<p>
     * Tests accuracy of the method getEndPrefix(). Get the end prefix 
     * of this.rand1 and this.rand3. "9569" is expected</p>
     *
     */
    public void testGetEndPrefixAccuracy() {
        assertTrue("9569".equals(this.rand1.getEndPrefix()));
        assertTrue("9569".equals(this.rand3.getEndPrefix()));
    } // end testGetEndPrefixAccuracy()

} // end ValidationRangeTest
