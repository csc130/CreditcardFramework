package CreditCardProcessor.utils;

public class CreditCardProcess extends Thread {
	
	private CreditCardProcess ccProcess;
	private CreditCardInfo theCCInfo;
	private Object processLock = CreditCardProcess.class;
	
	public CreditCardProcess(CreditCardInfo theCCInfo) {
		this.theCCInfo = theCCInfo;
	}
	
	public CreditCardInfo getTheCCInfo() {
		return theCCInfo;
	}

	public void setTheCCInfo(CreditCardInfo theCCIn) {
			theCCInfo = theCCIn;
	}

	public CreditCardProcess getCcProcess() {
		synchronized(processLock){ 
		if (ccProcess == null) {
			ccProcess = new CreditCardProcess(getTheCCInfo());
		}
		return ccProcess;
		}
	}


	
	
}
