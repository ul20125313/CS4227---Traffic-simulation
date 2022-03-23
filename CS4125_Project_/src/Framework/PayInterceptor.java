package Framework;

import Adapter.Payment;
import Driver.Driver;

public class PayInterceptor implements Interceptor
{

	
	@Override
	public void prepay(PrePayContext context) 
	{
		System.out.println(context.getDriver().getName()+" Start the payment");
		Framework.getInstance().prePay(context);
		// TODO Auto-generated method stub	
	}

	@Override
	public void postpay(Context context)
	{
		
		if(context.getMessage().equals("postpay"))
		{
			PostPayContext c= (PostPayContext)context;
			Payment p;
			p=c.getpayment();
			Driver d;
			d = c.getDriver();
			d.balanceDecrease(p.get_pay_money());
			p.finsh_payment();
			Framework.getInstance().postPay(context);
		}

		else if(context.getMessage().equals("error"))
		{
			try
			{
				System.out.println("this is something wrong with the payment");
				
				Framework.getInstance().postPay(context);
				
			}
			catch(Exception e)
			{
				
			}
			
		}
		

		// TODO Auto-generated method stub	
	}

}
