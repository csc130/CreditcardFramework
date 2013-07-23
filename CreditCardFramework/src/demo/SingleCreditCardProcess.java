package demo;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

import creditcard.db.utils.CreditCardPool;
import creditcard.utils.CreditCard;
import creditcard.utils.CreditCardFactory;
import creditcard.utils.CreditCardProcessor;
import creditcard.utils.CreditCardType;
import creditcard.utils.SingletonCC;
import CreditCardProcessor.utils.CreditCardProcess;

public class SingleCreditCardProcess {
	
	public static CreditCard swipe(String ccNum, String ccName, CreditCardType ccType, int ccv,
			String ccExpDate, BigDecimal amount, String ccZip) {
		CreditCard swipedCC = new CreditCard(ccNum,ccName,ccType,ccv,
				ccExpDate,amount,ccZip);
		SingletonCC.setTheCCInfo(swipedCC);
		return SingletonCC.getTheCCInfo();
	}
	public static void main(String [] args) {
		String result="";
		CreditCard masterCC, amexCC;
		CreditCardProcessor processedCC, amexProcessedCC;
		
		//Invalid Master Card Test
		BigDecimal charge = new BigDecimal("500");
		//Step1: customer swipe cc.
		masterCC = swipe("5112345678901254" , "John Doe", CreditCardType.MASTER, 123,"12/13", charge , "12345");
		System.out.println("Swiped CC information \n" + masterCC);
		//Step2: Process the CC
		CreditCardFactory ccFact = new CreditCardFactory(masterCC);
		processedCC = ccFact.processCreditCard(masterCC.getCcType());
		
		//Step2.1: Validate 
		if(processedCC.ccValidate()) {
			//Step2.2: Authenticate 
			result=processedCC.paymentAuthentication();
			System.out.println("Result: " + result);
			//JOptionPane.showMessageDialog(null, result);
		} else {
			System.out.println("Invalid CC");
			//JOptionPane.showMessageDialog(null, "Invalid CC");
		}
		//Check the pool list
		CreditCardPool ccPool = new CreditCardPool();
		System.out.println("List of Credit Card on the DB:\n " +ccPool);
	}
}




/*
//Amex Card Test
BigDecimal amexCharge = new BigDecimal("50");
//Step1: customer swipe cc.
amexCC = swipe("341234567890123" , "Susan Doe", CreditCardType.AMEX, 321,"12/15", amexCharge , "54321");
System.out.println("Swiped CC information \n" + amexCC);
//Step2: Process the CC
CreditCardFactory amexCCFact = new CreditCardFactory(amexCC);
amexProcessedCC = amexCCFact.processCreditCard(amexCC.getCcType());

//Step2.1: Validate 
if(amexProcessedCC.ccValidate()) {
	//Step2.2: Authenticate 
	result=amexProcessedCC.paymentAuthentication();
	System.out.println("Result: " + result);
	//JOptionPane.showMessageDialog(null, result);
} else {
	System.out.println("Invalid CC");
	//JOptionPane.showMessageDialog(null, "Invalid CC");
}*/



/*		//Master Card Test
		BigDecimal charge = new BigDecimal("500");
		//Step1: customer swipe cc.
		masterCC = swipe("5112345678901255" , "John Doe", CreditCardType.MASTER, 123,"12/13", charge , "12345");
		System.out.println("Swiped CC information \n" + masterCC);
		//Step2: Process the CC
		CreditCardFactory ccFact = new CreditCardFactory(masterCC);
		processedCC = ccFact.processCreditCard(masterCC.getCcType());
		
		//Step2.1: Validate 
		if(processedCC.ccValidate()) {
			//Step2.2: Authenticate 
			result=processedCC.paymentAuthentication();
			System.out.println("Result: " + result);
			//JOptionPane.showMessageDialog(null, result);
		} else {
			System.out.println("Invalid CC");
			//JOptionPane.showMessageDialog(null, "Invalid CC");
		}
		*/
		

/*		
//Amex Card Test
//BigDecimal amexCharge = new BigDecimal("50");
//Step1: customer swipe cc.
amexCC = swipe("341234567890123" , "Susan Doe", CreditCardType.AMEX, 321,"12/15", amexCharge , "54321");
System.out.println("Swiped CC information \n" + amexCC);
//Step2: Process the CC
CreditCardFactory amexCCFact2 = new CreditCardFactory(amexCC);
amexProcessedCC = amexCCFact2.processCreditCard(amexCC.getCcType());

//Step2.1: Validate 
if(amexProcessedCC.ccValidate()) {
	//Step2.2: Authenticate 
	result=amexProcessedCC.paymentAuthentication();
	System.out.println("Result: " + result);
	//JOptionPane.showMessageDialog(null, result);
} else {
	System.out.println("Invalid CC");
	//JOptionPane.showMessageDialog(null, "Invalid CC");
}
*/
