package Framework;

public class Context {
	private String message;
	public Context(int i)
	{
		switch(i)
		{
		case(1):
			this.message = "prepay";
		    break;
		case(2):
			this.message = "postpay";
		    break;
		case(3):
			this.message = "error";
		    break;
		default:
			break;
		}
		
		
		
	}
	public String getMessage()
	{
		return this.message;
	}

}
