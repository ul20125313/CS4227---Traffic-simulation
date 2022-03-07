package Adapter;

import Driver.Driver;

public class ScanPayAdapter implements ScanPay{
	
	public boolean paySystem(Driver d, int ticket_fee)
	{
		OnlinePay cp = new OnlinePay();
		System.out.println("this is the scan mehtod for payment");
		return(cp.paySystem(d, ticket_fee));
	}
	
	
	

}
