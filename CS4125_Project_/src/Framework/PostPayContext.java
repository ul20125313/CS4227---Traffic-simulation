package Framework;

import Adapter.Payment;
import Driver.Driver;

public class PostPayContext extends Context{
	private Payment payment;
	private Driver driver;
	public PostPayContext(int ContextCode, Payment p, Driver driver)
	{
		super(ContextCode);
		this.payment = p;
		this.driver = driver;
	}
	
	public Payment getpayment()
	{
		return this.payment;
	}
	
	public Driver getDriver()
	{
		return this.driver;
	}

}
