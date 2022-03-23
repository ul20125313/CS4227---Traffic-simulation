package Framework;

import java.util.ArrayList;

public class Paydispatcher {
	private static Paydispatcher paydis;
	private int index_1;
	private int index_2;
	ArrayList<Interceptor>payinters;
	
	public Paydispatcher()
	{
		this.payinters = new ArrayList<>();
		this.index_1 = 0;
		this.index_2 = 0;
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
		if(index_1 == payinters.size())
		{
			index_1 =0;
		}
		else
		{
			//index_1 ++;
			payinters.get(index_1++).prepay(context);
			
		}
		
		
	}
	
	public void postPay(Context context)
	{
	
		if(index_2 == payinters.size())
		{
			index_2 = 0;
		}
		else
		{
			//index_2 ++;
			payinters.get(index_2++).postpay(context);
			
		}
		
		
	}

}
