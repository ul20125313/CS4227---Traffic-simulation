package Detection;

import java.util.ArrayList;

import Driver.Driver;
import Thread.Threadprocess;

public class CollisionMonitor extends Monitor  {
	public CollisionMonitor(DetectionMethod a) {
		super(a);
		// TODO Auto-generated constructor stub
	}


	public void addTargetDriver(Driver d)
	{
		super.target_drivers.add(d);
	}
	
	public void removeTargetDriver(Driver d1)
	{
		int index = super.target_drivers.indexOf(d1);// get the index of corresponding instance
		if(index >= 0)
			super.target_drivers.remove(index);
	}

	public void work()// callback
	{
		

		super.a.detectCollision(target_drivers, this);
		//super.a.detect_whether_Overtake(target_drivers, this);


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
		d1.getVehilce().Damage();
		d2.driver_cant_work();
		d2.getVehilce().Damage();
		
	}

}
