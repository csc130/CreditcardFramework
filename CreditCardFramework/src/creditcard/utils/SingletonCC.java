package creditcard.utils;

import CreditCardProcessor.utils.CreditCardInfo;
import CreditCardProcessor.utils.CreditCardProcess;

public class SingletonCC {
	private static SingletonCC ccProcess;
	private static CreditCard theCCInfo;
	private static boolean process_flag;
	private static Object processLock = CreditCardProcess.class;
	
	private SingletonCC(CreditCard theCCInfo) {
		this.theCCInfo = theCCInfo;
	}
	
	public static CreditCard getTheCCInfo() {
		return theCCInfo;
	}

	public static void setTheCCInfo(CreditCard theCCIn) {
			theCCInfo = theCCIn;
	}

	public static SingletonCC getCcProcess() {
		synchronized(processLock){ 
		if (ccProcess == null) {
			process_flag = true;
			ccProcess = new SingletonCC(getTheCCInfo());
		}
		return ccProcess;
		}
	}

}
