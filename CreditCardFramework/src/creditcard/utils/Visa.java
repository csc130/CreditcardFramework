package creditcard.utils;

import CreditCardProcessor.utils.Authentication;

public class Visa implements CreditCardProcessor {

	CreditCard theCC;
	 /**
     * <p>
     * <strong>Purpose: </strong>the prefixes of Visa issued credit card number
     * </p>
     */
    private static final String PREFIX = "4";

    /**
     * <p>
     * <strong>Purpose: </strong>the length of Visa issued credit card number
     * </p>
     */
    private static final int LENGTH_1 = 13;
    private static final int LENGTH_2 = 16;

    /**
     * <p>
     * <strong>Purpose: </strong>provide the default identifier for this validator.&nbsp; This value is a constant and
     * thus - non-null, non-empty and immutable
     * </p>
     */
    public static final String IDENTIFIER = "Visa";

	
	public Visa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Visa(CreditCard theCC) {
		super();
		this.theCC = theCC;
		// TODO Auto-generated constructor stub
	}

	public boolean ccValidate() {
		boolean valid = false;
		String prefix = theCC.getCcNum().substring(0,1);
			if(prefix.equals(PREFIX)) {
				if ((theCC.getCcNum().length() == LENGTH_1) || (theCC.getCcNum().length() == LENGTH_2)) {
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
