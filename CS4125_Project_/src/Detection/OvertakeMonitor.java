package Detection;

import Driver.Driver;
import Simulation_Control.Sim_Controller;
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
		super.a.detectOvertake(target_drivers, this);
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
		int old_lane_num = d1.getVehilce().getLane().getLaneNumber();
		//System.out.println(d1.getVehilce().getLane().getLaneNumber());
		if(d1.getVehilce().getLane().getLaneNumber()!=2)
		{
			d1.getVehilce().turn_to_inside_lane();
			
		}
		else 
			d1.getVehilce().turn_to_outside_lane();
		
		this.removeTargetDriver(d1);
		
		//System.out.println(d1.getName()+" "+d1.getVehilce().getLane().getLaneNumber());
		Sim_Controller.update_monitor(d1, d1.getVehilce().getLane().getLaneNumber(),old_lane_num);
		
	}

}
