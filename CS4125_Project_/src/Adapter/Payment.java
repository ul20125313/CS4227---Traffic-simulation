package Adapter;
public class Payment {
	public enum State
	{
		CREATE, FINISHED
	}
	
	private int pay_money;
	private State state;
	public void set_pay_money(int money)
	{
		this.pay_money = money;
		this.state = State.CREATE;
		
	}
	
	public int get_pay_money()
	{
		return this.pay_money;
	}
	
	public void finsh_payment()
	{
		this.state = State.FINISHED;
	}

}
