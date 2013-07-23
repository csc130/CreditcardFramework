package CreditCardProcessor.utils;

import java.math.BigDecimal;

public class CreditCardInfo {
	String ccNum;
	BigDecimal ccCreditLimit;
	BigDecimal ccAvailableBalance;
	
	public CreditCardInfo(String ccNum, BigDecimal ccCreditLimit,
			BigDecimal ccAvailableBalance) {
		super();
		this.ccNum = ccNum;
		this.ccCreditLimit = ccCreditLimit;
		this.ccAvailableBalance = ccAvailableBalance;
	}
	
	public String getCcNum() {
		return ccNum;
	}
	public void setCcNum(String ccNum) {
		this.ccNum = ccNum;
	}
	public BigDecimal getCcCreditLimit() {
		return ccCreditLimit;
	}
	public void setCcCreditLimit(BigDecimal ccCreditLimit) {
		this.ccCreditLimit = ccCreditLimit;
	}
	public BigDecimal getCcAvailableBalance() {
		return ccAvailableBalance;
	}
	public void setCcAvailableBalance(BigDecimal ccAvailableBalance) {
		this.ccAvailableBalance = ccAvailableBalance;
	}

	@Override
	public String toString() {
		return "CreditCardInfo [ccNum=" + ccNum + ", ccCreditLimit="
				+ ccCreditLimit + ", ccAvailableBalance=" + ccAvailableBalance
				+ "]";
	}

}
