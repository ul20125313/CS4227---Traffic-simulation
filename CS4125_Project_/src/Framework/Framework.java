package Framework;

public class Framework {
	private static Framework f;
	
	private Paydispatcher pd;
	
	public Framework()
	{
		this.pd = Paydispatcher.geInstance();
	}
	public static Framework getInstance()
	{
		if(f == null)
		{
			f = new Framework();
		}
		return f;
	}
	
	public void registerPayInterceptor(Interceptor p)
	{
		this.pd.registerPayinterceptor(p);
	}
	
	public void removePayInterceptor(int index)
	{
		this.pd.removePayinterceptor(index);
	}
	
	public void prePay(PrePayContext context)
	{
		pd.prePay(context);
	}
	
	public void postPay(Context context)
	{
		pd.postPay(context);
		
	}
}
