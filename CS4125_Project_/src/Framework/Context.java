package Framework;

public class Context {
	private String message;
	public Context(int i)
	{
		switch(i)
		{
		case(1):
			this.message = "prepay";
		case(2):
			this.message = "postpay";
		case(3):
			this.message = "error";
		}		
		this.message = message;
		
	}
	public String getMessage()
	{
		return this.message;
	}

}
