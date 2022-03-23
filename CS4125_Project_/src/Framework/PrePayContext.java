package Framework;

import Driver.Driver;

public class PrePayContext extends Context
{
	private Driver d;	

	public PrePayContext(int contextCode, Driver d)
	{
		super(contextCode);
		this.d = d;

	}
	
	public Driver getDriver()
	{
		return this.d;
	}

	

}
