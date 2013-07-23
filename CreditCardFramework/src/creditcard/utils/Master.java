package creditcard.utils;

import CreditCardProcessor.utils.Authentication;

public class Master implements CreditCardProcessor {
	CreditCard theCC;

	/**
	 * <p>
	 * <strong>Purpose: </strong>the prefixes of MasterCard issued credit card
	 * number
	 * </p>
	 */
	private static final String PREFIX_START = "51";
	private static final String PREFIX_END = "55";

	/**
	 * <p>
	 * <strong>Purpose: </strong>the length of MasterCard issued credit card
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
	public static final String IDENTIFIER = "MasterCard";

	public Master() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Master(CreditCard theCC) {
		super();
		this.theCC = theCC;
		// TODO Auto-generated constructor stub
	}

	public boolean ccValidate() {
		boolean valid = false;
		String prefixStart = theCC.getCcNum().substring(0, 2);
		String prefixEnd = theCC.getCcNum().substring(
				theCC.getCcNum().length() - 2, theCC.getCcNum().length());
		if (prefixStart.equals(PREFIX_START)) {
			if (prefixEnd.equals(PREFIX_END)) {
				if (theCC.getCcNum().length() == LENGTH) {
					valid = true;
				}
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
