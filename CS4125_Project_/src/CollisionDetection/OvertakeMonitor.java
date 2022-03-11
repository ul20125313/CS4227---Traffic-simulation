package CollisionDetection;

import Driver.Driver;
import Thread.Threadprocess;

public class OvertakeMonitor extends Monitor{

	public OvertakeMonitor(DetectionMethod a) {
		super(a);
		
	}




	@Override
	public void addTargetDriver(Driver d) {
		super.target_drivers.add(d);
		
		
	}
	public void work()
	{
		super.a.detect_whether_Overtake(target_drivers, this);
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

	@Override
	public void removeTargetDriver(Driver d1) {
		int index = super.target_drivers.indexOf(d1);// get the index of corresponding instance
		if(index >= 0)
			super.target_drivers.remove(index);
		
	}
	
	
	public void if_Overtake_occurs(Driver d1, Driver d2)
	{
		
	}

}
