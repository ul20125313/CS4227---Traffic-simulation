package Framework;

import java.util.ArrayList;

public class Paydispatcher {
	private static Paydispatcher paydis;
	ArrayList<Interceptor>payinters;
	
	public Paydispatcher()
	{
		this.payinters = new ArrayList<>();
	}
	
	public static Paydispatcher geInstance()
	{
		if(paydis == null)
		{
			paydis = new Paydispatcher();
		}
		return paydis;
	}
	
	public void registerPayinterceptor(Interceptor p)
	{
	
		this.payinters.add(p);
	}
	
	public void removePayinterceptor(int index)
	{
		this.payinters.remove(index);
	}
	
	public void prePay(PrePayContext context)
	{
		for(Interceptor payinterceptor : payinters)
		{
			payinterceptor.prepay(context);
		}
		
		
	}
	
	public void postPay(PostPayContext context)
	{
		for(Interceptor payinterceptor : payinters)
		{
			payinterceptor.postpay(context);
		}
		
		
	}

}
