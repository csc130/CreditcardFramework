import java.math.BigDecimal;

import creditcard.utils.CreditCard;
import creditcard.utils.CreditCardProcessor;
import creditcard.utils.CreditCardType;
import creditcard.utils.Master;



public class MasterTest {
	
	public static CreditCard swipe() {
		BigDecimal amount = new BigDecimal("500");
		CreditCard swipedCC = new CreditCard("5112345678901255" , "John Doe", CreditCardType.MASTER, 123,
			"12/13", amount, "12345");
		return swipedCC;
	}
	
	public static void main(String [] args) {
		CreditCard cc;
		//Step1: customer swipe cc.
		cc = swipe();
		System.out.println(cc);
		String prefixStart = cc.getCcNum().substring(0, 2);
		System.out.println(prefixStart);
		System.out.println("Length: "+ cc.getCcNum().length());
		String prefixEnd = cc.getCcNum().substring(
				cc.getCcNum().length() - 2, cc.getCcNum().length());
		System.out.println(prefixEnd);
		//Master mc = new Master(cc);
	}

}
