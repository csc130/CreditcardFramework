/**
 *
 * Copyright (c) 2004, TopCoder, Inc. All rights reserved
 */
package com.topcoder.ecommerce.creditcard.validation.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.TestResult;

import com.topcoder.ecommerce.creditcard.validation.*;
import com.topcoder.ecommerce.creditcard.validation.algorithms.*;
import com.topcoder.util.config.*;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

/**
 * <p>This class contains the stress test cases for all classes in the Credit Card Validation component.</p>
 *
 * @author georgepf
 * @version 1.0
 */
public class CreditCardValidationStressTests extends TestCase {
	// number of iterations for each pass to verify linearity of algorithms
	static final int[] ITERATIONS = new int[] {10, 100, 1000};
	static final int N = ITERATIONS.length;
	// number of threads to run for multi-threaded testing
	static final int THREAD_COUNT = 5;
	// configuration properties
    private final static ConfigManager config = ConfigManager.getInstance();
	private final static String CONFIG_FILE = "test_files/stress_tests_config.xml";
	private final static String CONFIG_FILE_COPY = "test_files/stress_tests_config_copy.xml";
	// base credit card numbers
	private final static String[] creditCardTemplates = new String[] {"1234567890123456",
																	  "201412345678901",
																	  "205912345678901",
																	  "214912345678901",
																	  "7000123456",
																	  "7123123456",
																	  "7173123456",
																	  "7599123456",
																	  "30012345678901",
																	  "30212345678901",
																	  "30512345678901",
																	  "36123456789012",
																	  "38123456789012",
																	  "341234567890123",
																	  "371234567890123",
																	  "4123456789012345",
																	  "4123456789012",
																	  "5112345678901234",
																	  "5312345678901234",
																	  "5512345678901234",
																	  "6011123456789012",
																	  "3123456789012345",
																	  "213112345678901",
																	  "180012345678901",
																	  "4408041234567890",
																	  "4408041234567893",
																	  "4417123456789112",
																	  "4417123456789113",
																	  "4111111111111111",
																	  "4111111111111191"};
	private final static Random random = new Random(0);
	// number of mutations to generate from each base credit card number
	private final static int MUTATIONS = 3;
	private final static String[] creditCardNumbers = new String[creditCardTemplates.length * (1 + MUTATIONS)];
	static {
		for (int i = 0, j = 0; i < creditCardTemplates.length; i++) {
			String cc = creditCardTemplates[i];
			creditCardNumbers[j++] = cc;
			for (int k = 0; k < MUTATIONS; k++) {
				// modify the last 6 digits
				creditCardNumbers[j] = cc.substring(0, cc.length() - 6);
				for (int l = 0; l < 6; l++)
					creditCardNumbers[j] = creditCardNumbers[j] + random.nextInt(10);
				j++;
			}
		}
	}

	/**
	 * Returns a test suite containing all test methods in this class
	 */
    public static Test suite() {
        return new TestSuite(CreditCardValidationStressTests.class);
    }

    /**
     * Set up the testing environment
     */
    protected void setUp() throws Exception {
		// clean up all config data
		String namespace = "com.topcoder.ecommerce.creditcard.validation.CreditCardValidatorRegistry";
		if (config.existsNamespace(namespace))
			config.removeNamespace(namespace);
		// load properties from the stress test config file
		// (copy the config file so that the original stays unmodified)
		BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE));
		BufferedWriter writer = new BufferedWriter(new FileWriter(CONFIG_FILE_COPY));
		for (String s = reader.readLine(); s != null; writer.write(s + "\n"), s = reader.readLine());
		reader.close();
		writer.close();
		config.add(new File(CONFIG_FILE_COPY).getAbsolutePath());
		// create one instance of each of the AbstractCreditCardValidator implementations to avoid initial penalty
		AmericanExpressValidator aev = new AmericanExpressValidator();
		DinersClubValidator dcv = new DinersClubValidator();
		DiscoverValidator dv = new DiscoverValidator();
		JCBValidator jcbv = new JCBValidator();
		MasterCardValidator mcv = new MasterCardValidator();
		VisaValidator vv = new VisaValidator();
	}

    /**
     * Tear down the testing environment
     */
    protected void tearDown() {
		// remove the file containing the config copy
		new File(CONFIG_FILE_COPY).delete();
    }

	/**
	 * Tests the AmericanExpressValidator class
	 */
	public void testAmericanExpressValidator() {
		abstractCreditCardValidatorTest(AmericanExpressValidator.class);
	}

	/**
	 * Tests the DinersClubValidator class
	 */
	public void testDinersClubValidator() {
		abstractCreditCardValidatorTest(DinersClubValidator.class);
	}

	/**
	 * Tests the DiscoverValidator class
	 */
	public void testDiscoverValidator() {
		abstractCreditCardValidatorTest(DiscoverValidator.class);
	}

	/**
	 * Tests the JCBValidator class
	 */
	public void testJCBValidator() {
		abstractCreditCardValidatorTest(JCBValidator.class);
	}

	/**
	 * Tests the MasterCardValidator class
	 */
	public void testMasterCardValidator() {
		abstractCreditCardValidatorTest(MasterCardValidator.class);
	}

	/**
	 * Tests the VisaValidator class
	 */
	public void testVisaValidator() {
		abstractCreditCardValidatorTest(VisaValidator.class);
	}

	/**
	 * Tests the CustomValidator class
	 */
	public void testCustomValidator() {
		abstractCreditCardValidatorTest(CustomValidator.class);
	}

	/**
	 * Tests the CreditCardValidatorRegistry class
	 */
	public void testCreditCardValidatorRegistry() throws Exception {
		Long[] time = new Long[N];

		CreditCardValidator ccv = new DummyCreditCardValidator();

		// test class constructors and methods
		for (int i = 0; i < N; i++) {
			long start = System.currentTimeMillis();
			for (int j = 0; j < ITERATIONS[i]; j++) {
				// test constructors and factory method
				ccvr_ = new CreditCardValidatorRegistry();
				ccvr_ = new CreditCardValidatorRegistry(false);
				ccvr_ = CreditCardValidatorRegistry.getInstance();
				// test methods
				ccvr_.addCreditCardValidator(ccv);
				ccv_ = ccvr_.getCreditCardValidator(ccv.getDefaultIdentifier());
				map_ = ccvr_.getCreditCardValidators();
				for (int k = 0; k < creditCardNumbers.length; k++)
					col_ = ccvr_.validate(creditCardNumbers[k]);
				ccvr_.removeCreditCardValidator(ccv.getDefaultIdentifier());
				ccvr_.addCreditCardValidator("FooBar", ccv);
				ccv_ = ccvr_.getCreditCardValidator(ccv.getDefaultIdentifier());
				for (int k = 0; k < creditCardNumbers.length; k++)
					col_ = ccvr_.validate(creditCardNumbers[k]);
				map_ = ccvr_.getCreditCardValidators();
				ccvr_.clearCreditCardValidators();
				for (int k = 0; k < creditCardNumbers.length; k++)
					col_ = ccvr_.validate(creditCardNumbers[k]);
			}
			time[i] = new Long(System.currentTimeMillis() - start);
		}
		System.out.println("times for class " + CreditCardValidatorRegistry.class.getName() + ": " + Arrays.asList(time));
	}

	/**
	 * Tests the ValidationFormatAllDigits class
	 */
	public void testValidationFormatAllDigits() {
		abstractValidationAlgorithmTest(ValidationFormatAllDigits.class);
	}

	/**
	 * Tests the ValidationFormatLength class
	 */
	public void testValidationFormatLength() {
		abstractValidationAlgorithmTest(ValidationFormatLength.class);
	}

	/**
	 * Tests the ValidationLUHN class
	 */
	public void testValidationLUHN() {
		abstractValidationAlgorithmTest(ValidationLUHN.class);
	}

	/**
	 * Tests the ValidationPrefix class
	 */
	public void testValidationPrefix() {
		abstractValidationAlgorithmTest(ValidationPrefix.class);
	}

	/**
	 * Tests the ValidationRange class
	 */
	public void testValidationRange() {
		abstractValidationAlgorithmTest(ValidationRange.class);
	}

	/**
	 * Tests an AbstractCreditCardValidator implementation
	 */
	void abstractCreditCardValidatorTest(Class accvClass) {
		Long[] time = new Long[N];

		// single-threaded testing
		for (int i = 0; i < N; i++) {
			ACCVTester tester = new ACCVTester(accvClass, ITERATIONS[i]);
			long start = System.currentTimeMillis();
			tester.run();
			time[i] = new Long(System.currentTimeMillis() - start);
		}
		System.out.println("single-threaded times for class " + accvClass.getName() + ": " + Arrays.asList(time));

		// multi-threaded testing
		for (int i = 0; i < N; i++) {
			ACCVTester[] tester = new ACCVTester[THREAD_COUNT];
			for (int j = 0; j < N; j++)
				tester[j] = new ACCVTester(accvClass, ITERATIONS[i]);
			long start = System.currentTimeMillis();
			for (int j = 0; j < N; j++)
				tester[j].start();
			try {
				for (int j = 0; j < N; j++)
					tester[j].join();
			} catch (InterruptedException e) {}
			time[i] = new Long(System.currentTimeMillis() - start);
		}

		System.out.println("multi-threaded times for class " + accvClass.getName() + ":  " + Arrays.asList(time));
	}

	/**
	 * Tests an AbstractValidationAlgorithm implementation
	 */
	void abstractValidationAlgorithmTest(Class avaClass) {
		Long[] time = new Long[N];

		// single-threaded testing
		for (int i = 0; i < N; i++) {
			AVATester tester = new AVATester(avaClass, ITERATIONS[i]);
			long start = System.currentTimeMillis();
			tester.run();
			time[i] = new Long(System.currentTimeMillis() - start);
		}
		System.out.println("single-threaded times for class " + avaClass.getName() + ": " + Arrays.asList(time));

		// multi-threaded testing
		for (int i = 0; i < N; i++) {
			AVATester[] tester = new AVATester[THREAD_COUNT];
			for (int j = 0; j < N; j++)
				tester[j] = new AVATester(avaClass, ITERATIONS[i]);
			long start = System.currentTimeMillis();
			for (int j = 0; j < N; j++)
				tester[j].start();
			try {
				for (int j = 0; j < N; j++)
					tester[j].join();
			} catch (InterruptedException e) {}
			time[i] = new Long(System.currentTimeMillis() - start);
		}

		System.out.println("multi-threaded times for class " + avaClass.getName() + ":  " + Arrays.asList(time));
	}

	// used to hold result from method calls (concurrently written by all threads)
	private static volatile boolean b_;
	private static volatile String s_;
	private static volatile Map map_;
	private static volatile Collection col_;
	private static volatile ValidationAlgorithm va_;
	private static volatile CreditCardValidatorRegistry ccvr_;
	private static volatile CreditCardValidator ccv_;

	// a dummy credit card validator
	private static class DummyCreditCardValidator implements CreditCardValidator {
		public boolean isValid(String creditCardText) {return (random.nextInt(10) == 0);}
		public String getDefaultIdentifier() {return "Dummy";}
	}

	// a dummy validation algorithm
	private static class DummyValidationAlgorithm implements ValidationAlgorithm {
		public DummyValidationAlgorithm(boolean result) {
			result_ = result;
		}
		public boolean isValid(String creditCardText) {
			return result_;
		}
		private final boolean result_;
	}

	// AbstractCreditCardValidator tester thread class
	private static class ACCVTester extends Thread {
		// internal variables
		private final String id_ = "FooBar";
		private final int iterations_;
		private final Class accvClass_;
		// several dummy objects used during instantiation and method calls
		private final static ValidationAlgorithm[] val_ = new ValidationAlgorithm[] {new DummyValidationAlgorithm(true),
																					 new DummyValidationAlgorithm(false)};
		private final static CreditCardValidator ccv_ = new DummyCreditCardValidator();

		ACCVTester(Class accvClass, int iterations) {
			accvClass_ = accvClass;
			iterations_ = iterations;
		}

		public void run() {
			for (int j = 0; j < iterations_; j++) {
				// create a new instance of class
				AbstractCreditCardValidator accv = null;
				if (accvClass_ == CustomValidator.class) {
					// this class has different constructors
					accv = new CustomValidator(id_);
					accv = new CustomValidator(id_, val_[0]);
				} else {
					try {
						accv = (AbstractCreditCardValidator) accvClass_.newInstance();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
				// test the AbstractCreditCardValidator methods
				accv.setValidation(val_[j % val_.length]);
				va_ = accv.getValidation();
				AbstractCreditCardValidator orAccv = accv.or(ccv_);
				for (int k = 0; k < creditCardNumbers.length; k++) {
					// test the CreditCardValidator methods
					b_ = accv.isValid(creditCardNumbers[k]);
					s_ = accv.getDefaultIdentifier();
					// test the resulting or-ed validator
					b_ = orAccv.isValid(creditCardNumbers[k]);
					s_ = orAccv.getDefaultIdentifier();
				}
			}
		}
	}

	// AbstractValidationAlgorithm tester thread class
	private static class AVATester extends Thread {
		// internal variables
		private final String id_ = "FooBar";
		private final int iterations_;
		private final Class avaClass_;
		// several dummy objects used during instantiation and method calls
		private final static ValidationAlgorithm[] val_ = new ValidationAlgorithm[] {new DummyValidationAlgorithm(true),
																					 new DummyValidationAlgorithm(false)};

		AVATester(Class avaClass, int iterations) {
			avaClass_ = avaClass;
			iterations_ = iterations;
		}

		public void run() {
			for (int j = 0; j < iterations_; j++) {
				// create a new instance of class
				AbstractValidationAlgorithm ava = null;
				Class[][] paramClasses;
				Object[][] params;
				if ((avaClass_ == ValidationFormatAllDigits.class) ||
					(avaClass_ == ValidationLUHN.class)) {
					// single constructor with no parameters
					paramClasses = new Class[][] {new Class[] {}};
					params = new Object[][] {new Object[] {}};
				} else if (avaClass_ == ValidationFormatLength.class) {
					// single constructor with an int parameter
					paramClasses = new Class[][] {new Class[] {int.class}};
					params = new Object[][] {new Object[] {new Integer(16)}};
				} else if (avaClass_ == ValidationRange.class) {
					// single constructor with two string and one int parameters
					paramClasses = new Class[][] {new Class[] {String.class, String.class, int.class}};
					params = new Object[][] {new Object[] {"3", "8", new Integer(6)}};
				} else if (avaClass_ == ValidationPrefix.class) {
					// two constructors with string parameters
					paramClasses = new Class[][] {new Class[] {String.class}, new Class[] {String.class, String.class}};
					params = new Object[][] {new Object[] {"44"}, new Object[] {"44", "46"}};
				} else {
					throw new RuntimeException("unknown AbstractValidationAlgorithm class: " + avaClass_.getName());
				}
				// test all constructors
				for (int i = 0; i < paramClasses.length; i++)
					try {
						ava = (AbstractValidationAlgorithm) avaClass_.getConstructor(paramClasses[i]).newInstance(params[i]);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				// test the AbstractValidationAlgorithm methods
				AbstractValidationAlgorithm avaAnd = ava.and(val_[0]);
				avaAnd = ava.and(val_[1]);
				AbstractValidationAlgorithm avaOr = ava.or(val_[0]);
				avaOr = ava.or(val_[1]);
				AbstractValidationAlgorithm avaNot = ava.not();
				for (int k = 0; k < creditCardNumbers.length; k++)
					b_ = ava.isValid(creditCardNumbers[k]);
			}
		}
	}
}

