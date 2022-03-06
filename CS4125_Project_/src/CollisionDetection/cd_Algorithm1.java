package CollisionDetection;

import java.util.ArrayList;

import Driver.Driver;

public class cd_Algorithm1 implements CollisionDetectionAlgorithm{


	@Override
	public void detectCollision(ArrayList<Driver>target_drivers, CollisionDetection c) 
	{
		double dis;
		 
		for(int i=0;i<target_drivers.size();i++)
		{
			for(int j= i+1;j<target_drivers.size();j++)
			{
				
				Driver d1 = target_drivers.get(i);
				Driver d2 = target_drivers.get(j);
				if(d1.get_cant_work_state() == true && d2.get_cant_work_state() == true)
				{
					continue;
				}
				double t1_x = d1.getVehilce().getPosition().getX();
				double t1_y = d1.getVehilce().getPosition().getY();
				double t2_x = d2.getVehilce().getPosition().getX();
				double t2_y = d2.getVehilce().getPosition().getY();
				dis = Math.sqrt((t1_x - t2_x)*(t1_x - t2_x) +(t1_y - t2_y)*(t1_y - t2_y));
				if(dis<10)
				{
					c.if_Collision_occurs(d1,d2);
					d1.set_cant_work_state();
					d2.set_cant_work_state();
				}
				
			}
		}
		
		
	
		
	}
	

}
