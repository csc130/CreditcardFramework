package creditcard.utils;

import CreditCardProcessor.utils.Authentication;

public class Amex implements CreditCardProcessor {

	CreditCard theCC;
	/**
	 * <p>
	 * <strong>Purpose: </strong>provide the default identifier for this
	 * validator.&nbsp; This value is a constant and thus - non-null, non-empty
	 * and immutable
	 * </p>
	 */
	public static final String IDENTIFIER = "AmericanExpress";

	/**
	 * <p>
	 * <strong>Purpose: </strong>the prefixes of AmericanExpress issued credit
	 * card number
	 * </p>
	 */
	private static final String PREFIX_1 = "34";
	private static final String PREFIX_2 = "37";

	/**
	 * <p>
	 * <strong>Purpose: </strong>the length of AmericanExpress issued credit
	 * card number
	 * </p>
	 */
	private static final int LENGTH = 15;

	public Amex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Amex(CreditCard theCC) {
		super();
		this.theCC = theCC;
		// TODO Auto-generated constructor stub
	}

	public boolean ccValidate() {
		boolean valid = false;
		String prefix = theCC.getCcNum().substring(0, 2);

		if ((prefix.equals(PREFIX_1)) || (prefix.equals(PREFIX_2))) {
			if (theCC.getCcNum().length() == LENGTH) {
				valid = true;
			}
		}
		return valid;
	}

	@Override
	public String paymentAuthentication() {
		// TODO Auto-generated method stub
		String status;
		Authentication authen = new Authentication(theCC);
		status = authen.toAuthenticate();
		return status;
	}

}
