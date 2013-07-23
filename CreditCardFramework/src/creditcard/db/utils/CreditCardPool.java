package creditcard.db.utils;

import java.math.BigDecimal;
import java.util.ArrayList;

import CreditCardProcessor.utils.CreditCardInfo;
import CreditCardProcessor.utils.CreditCardProcess;

public class CreditCardPool {
	ArrayList <CreditCardProcess> ccPool = new ArrayList();
	BigDecimal limit1,limit2;
	BigDecimal available1,available2;
	CreditCardInfo cc1, cc2;
	CreditCardProcess cProcess1,cProcess2;
	
	public CreditCardPool() {
		//Simulating cc data from database.
		//MASTER
		limit1 = new BigDecimal(1000);
		available1 = new BigDecimal(1000);
		cc1 = new CreditCardInfo("5112345678901255",limit1,available1);
		cProcess1 = new CreditCardProcess(cc1);
		//CreditCardProcess.setTheCCInfo(cc1);
		//System.out.println(CreditCardProcess.getTheCCInfo());
		ccPool.add(cProcess1);
		
		//AMEX
		limit2 = new BigDecimal(2000);
		available2 = new BigDecimal(2000);
		cc2 = new CreditCardInfo("341234567890123",limit2,available2);
		cProcess2 = new CreditCardProcess(cc2);
		ccPool.add(cProcess2);
	}
	
	
	public CreditCardInfo getCCinfo(String ccNum) {
		CreditCardInfo theCC=null;
			theCC = searchCCPool(ccNum);
		return theCC;
	}
	public CreditCardInfo searchCCPool(String ccNum) {
		CreditCardProcess ccProcess=null;
		/*System.out.println(ccPool.size());
		System.out.println(ccPool.get(0));
		ccProcess = ccPool.get(0);
		System.out.println(ccProcess.getTheCCInfo());*/
		for(int i=0; i<ccPool.size();i++) {
			ccProcess = ccPool.get(i);
			if(ccProcess.getTheCCInfo().getCcNum().equals(ccNum)) {
				System.out.println("Found CC in the Pool");
				System.out.println(ccProcess.getTheCCInfo());
				return ccProcess.getTheCCInfo();
			}
		}
		return null;
	}
	
	public String toString() {
		String list="";
		for(int i=0; i<ccPool.size();i++) {
			list += ccPool.get(i).getTheCCInfo()+"\n";
		}
		return list;
	}
}
