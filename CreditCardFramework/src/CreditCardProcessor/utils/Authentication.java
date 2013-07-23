package CreditCardProcessor.utils;

import creditcard.db.utils.CreditCardPool;
import creditcard.utils.CreditCard;

public class Authentication {
	CreditCardPool pool;
	CreditCard authenCC;
	CreditCardInfo poolCC;
	public Authentication(CreditCard authenCC) {
		//CC info from merchant
		this.authenCC = authenCC;
		//CC info from CC Pool
		pool = new CreditCardPool();
		this.poolCC = pool.getCCinfo(authenCC.getCcNum());

	}
	
	public String toAuthenticate() {
		String status;
		//This method returns -1 if the BigDecimal is less than val, 
		//1 if the BigDecimal is greater than val and 0 if the BigDecimal is equal to val
		if (this.poolCC == null) {
			status = "Cannot find CC.";
		} else if(this.poolCC.getCcAvailableBalance().compareTo(this.authenCC.getAmount())>0) {
			status = "Approved";
		} else {
			status = "Denied";
		}
		return status;
	}

}
