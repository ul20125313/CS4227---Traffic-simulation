package Adapter;

import java.awt.Point;

import Driver.Driver;
import Vehicle.Vehicle;

public class CHYPayment {
	
	

	private Driver driver;
	private int ticket_fee;
	private OnlinePay cp;
	private ScanPayAdapter sp;
	private int driver_balance;
	private String driver_name;
	private Vehicle driver_vehicle;
	private Point cant_move_cars_loc;
	
	
	public CHYPayment()
	{
		this.ticket_fee =  7;		
		this.cp = new OnlinePay();
		this.sp = new ScanPayAdapter();
		this.cant_move_cars_loc = new Point((40),(40));
	}
	
	public void setDriverInformation(Driver d)
	{
		this.driver = d;
		this.driver_name = d.getName();
		this.driver_balance = d.getBalance();
		this.driver_vehicle = d.getVehilce();

	}
	
	public boolean check_whether_can_afford() 
	{
		if(this.sp.paySystem(this.driver, this.ticket_fee))
		{
			System.out.println(this.driver.getName()+" has enough money, so he can drive in this road.\n");
			return true;
		}
		
		else 
		{
			System.out.println(this.driver.getName()+" doesn't have enough money, so he can't drive in this road.\n");
			this.driver.getVehilce().setPosition(this.cant_move_cars_loc);
			return false;
		
		}
		//return false;

	}
	
	
	
	
}


