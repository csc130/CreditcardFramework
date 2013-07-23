package creditcard.utils;

import java.math.BigDecimal;

public class CreditCard {
	String ccNum;
	String ccName;
	CreditCardType ccType;
	int ccv;
	String ccExpDate;
	BigDecimal amount;
	String ccZip;
	
	public CreditCard(String ccNum, String ccName, CreditCardType ccType, int ccv,
			String ccExpDate, BigDecimal amount, String ccZip) {
		super();
		this.ccNum = ccNum;
		this.ccName = ccName;
		this.ccType = ccType;
		this.ccv = ccv;
		this.ccExpDate = ccExpDate;
		this.amount = amount;
		this.ccZip = ccZip;
	}
	public String getCcNum() {
		return ccNum;
	}
	public void setCcNum(String ccNum) {
		this.ccNum = ccNum;
	}
	public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public CreditCardType getCcType() {
		return ccType;
	}
	public void setCcType(CreditCardType ccType) {
		this.ccType = ccType;
	}
	public int getCcv() {
		return ccv;
	}
	public void setCcv(int ccv) {
		this.ccv = ccv;
	}
	public String getCcExpDate() {
		return ccExpDate;
	}
	public void setCcExpDate(String ccExpDate) {
		this.ccExpDate = ccExpDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCcZip() {
		return ccZip;
	}
	public void setCcZip(String ccZip) {
		this.ccZip = ccZip;
	}
	
	@Override
	public String toString() {
		return "CreditCard [ccNum=" + ccNum + ", ccName=" + ccName
				+ ", ccType=" + ccType + ", ccv=" + ccv + ", ccExpDate="
				+ ccExpDate + ", amount=" + amount + ", ccZip=" + ccZip + "]";
	}
	
	
}
