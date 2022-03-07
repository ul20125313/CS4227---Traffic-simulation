package Adapter;

import Driver.Driver;

public class OnlinePay {

	public boolean paySystem(Driver d, int ticket_fee)
	{
		System.out.println("this is the Online mehtod for payment\n");
		if(d.getBalance() >ticket_fee)
		{
			return true;
		}
		return false;
	}

}
