package CollisionDetection;

import java.util.ArrayList;

import Driver.Driver;

public class cd_Algorithm2 implements CollisionDetectionAlgorithm{

	private int model_width;
	private int model_height;
	public cd_Algorithm2()
	{
		this.model_width = 10;
		this.model_height = 10;
	}
	@Override
	public void detectCollision(ArrayList<Driver>target_drivers, CollisionDetection c) 
	{
		// TODO Auto-generated method stub
		for(int i=0;i<target_drivers.size();i++)
		{
			for(int j= i+1;j<target_drivers.size();j++)
			{
				Driver d1 = target_drivers.get(i);
				Driver d2 = target_drivers.get(j);
				if(d1.getIs_Collosion() == true && d2.getIs_Collosion() == true)
				{
					continue;
				}
				if(Is_Collision(d1,d2))
				{
					c.if_Collision_occurs(d1,d2);
//					d1.set_cant_work_state();
//					d2.set_cant_work_state();
				}
			}
		}
		
		
	}
	public boolean Is_Collision(Driver d1, Driver d2)
	{
		double t1_car_right;
		double t1_car_left;
		double t1_car_top;
		double t1_car_bottom;
		
		double t2_car_right;
		double t2_car_left;
		double t2_car_top;
		double t2_car_bottom;
		
		double t1_x = d1.getVehilce().getPosition().getX();
		double t1_y = d1.getVehilce().getPosition().getY();
		double t2_x = d2.getVehilce().getPosition().getX();
		double t2_y = d2.getVehilce().getPosition().getY();
		
		t1_car_right = t1_x + this.model_width/2;
		t1_car_left = t1_x - this.model_width/2;
		t1_car_top = t1_y + this.model_height/2;
		t1_car_bottom = t1_y - this.model_height/2;
		
		t2_car_right = t2_x + this.model_width/2;
		t2_car_left = t2_x - this.model_width/2;
		t2_car_top = t2_y + this.model_height/2;
		t2_car_bottom = t2_y - this.model_height/2;
		
		
		int is_horizon_collision = 0;
		int is_longitude_collision = 0;
		if(t1_car_right <  t2_car_left)
		{
			
			is_horizon_collision = 0;
		}
		
		else if(t2_car_right < t1_car_left)
		{
			is_horizon_collision = 0;
		}
		else 
		{
			is_horizon_collision = 1;
		}
		
		
		if(t1_car_bottom > t2_car_top)
		{
			is_longitude_collision = 0;
			
		}			
		else if(t2_car_bottom > t1_car_top)
		{
			is_longitude_collision = 0;
		}
		else 
		{
			is_longitude_collision = 1;
		}	
		//System.out.println(is_horizon_collision+" "+is_longitude_collision);
		
		if(is_horizon_collision == 1&&is_longitude_collision == 1)
		{
			
			return true;
		}
		return false;
	}

	

}
