package Adapter;

import Driver.Driver;
import Framework.Framework;
import Framework.PostPayContext;

public class OnlinePay {
	private int ticket_fee;

	public boolean paySystem(Driver d, int ticket_code) {
		System.out.println("this is the Online mehtod for payment");
		this.ticket_fee = getticketfee(ticket_code);
		if (d.getBalance() > ticket_fee) {
			//interception point(after pay)
			
			Payment payment = new Payment();
			payment.set_pay_money(ticket_fee);
			PostPayContext postpaycontext = new PostPayContext(2, payment, d );
			Framework.getInstance().postPay(postpaycontext);

			return true;
		}
		return false;
	}

	public int getticketfee(int ticket_code) {
		switch (ticket_code) {
		case (1):
			return 7;
		default:
			return 1;
		}
	}

}