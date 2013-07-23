package creditcard.utils;

import CreditCardProcessor.utils.Authentication;

public class Discover implements CreditCardProcessor {

	CreditCard theCC;

	/**
	 * <p>
	 * <strong>Purpose: </strong>the prefixes of Discover issued credit card
	 * number
	 * </p>
	 */
	private static final String PREFIX = "6011";

	/**
	 * <p>
	 * <strong>Purpose: </strong>the length of Discover issued credit card
	 * number
	 * </p>
	 */
	private static final int LENGTH = 16;

	/**
	 * <p>
	 * <strong>Purpose: </strong>provide the default identifier for this
	 * validator.&nbsp; This value is a constant and thus - non-null, non-empty
	 * and immutable
	 * </p>
	 */
	public static final String IDENTIFIER = "Discover";

	public Discover() {
		super();
	}

	public Discover(CreditCard theCC) {
		super();
		this.theCC = theCC;
	}

	public boolean ccValidate() {
		boolean valid = false;
		String prefix = theCC.getCcNum().substring(0, 4);
		if (prefix.equals(PREFIX)) {
			if (theCC.getCcNum().length() == LENGTH) {
				valid = true;
			}
		}
		return valid;
	}

	@Override
	public String paymentAuthentication() {
		String status;
		Authentication authen = new Authentication(theCC);
		status = authen.toAuthenticate();
		return status;
	}
}
