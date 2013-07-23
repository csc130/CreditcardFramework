package creditcard.utils;

import javax.swing.JOptionPane;

import creditcard.utils.*;

public class CreditCardFactory {

	private static CreditCard theCC;
	
	public CreditCardFactory(CreditCard theCC) {
		this.theCC = theCC;
	}
	
	public static CreditCardProcessor processCreditCard(CreditCardType ccType) {
		switch (ccType) {
		case VISA:
			return new Visa(theCC);
			
		case MASTER:
			return new Master(theCC);
			
		case AMEX:
			return new Amex(theCC);
			
		case DISCOVER:
			return new Discover(theCC);
			
		default:
			JOptionPane.showMessageDialog(null, "Not a Valid Credit Card Type!");
			return null;
			
			
			
		}
		//return null; 
	}

}
