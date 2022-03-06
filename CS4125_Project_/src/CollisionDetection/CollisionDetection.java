package CollisionDetection;

import java.util.ArrayList;

import Driver.Driver;
import Thread.Threadprocess;

public class CollisionDetection implements Runnable{
	private Driver target;
	private CollisionDetectionAlgorithm a;
	private ArrayList<Driver>target_drivers;
	private double my_x;
	private double my_y;
	public CollisionDetection( CollisionDetectionAlgorithm a)
	{
		//this.target = d;
		this.target_drivers = new ArrayList<>();
		this.a = a;
	}
	public void set_my_loc(double x, double y)
	{
		this.my_x = x;
		this.my_y =y;
	}
	public void addTargetDriver(Driver d)
	{
		this.target = d;
		this.target_drivers.add(this.target);
	}
	public Driver getTargetDriver()
	{
		return target;
	}
	
	public void work()// callback
	{
		
//		double t_x = this.target.getVehilce().getPosition().getX();
//		double t_y = this.target.getVehilce().getPosition().getY();
//		boolean is_Collision;
		this.a.detectCollision( this.target_drivers, this);
//		if(is_Collision)
//		{
//			System.out.println("collision occurs caused by "+this_d.getName() + " and "+ this.target.getName());
//	
//		}

	}
	@Override
	public void run() 
	{
		boolean process=true;
		Threadprocess t = new Threadprocess(Threadprocess.DEFAULT_FRAMERATE);
		t.setMessage("Collision Detection");
		while(process)
		{
			t.start();
			this.work();
			t.end();
		}
		
		// TODO Auto-generated method stub
		
	}
	public void if_Collision_occurs(Driver d1, Driver d2)//callback method
	{
		System.out.println("collision occurs caused by "+d1.getName() + " and "+ d2.getName());
		d1.driver_cant_work();
		d2.driver_cant_work();
		
	}

}
