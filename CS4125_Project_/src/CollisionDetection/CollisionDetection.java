package CollisionDetection;

import Driver.Driver;

public class CollisionDetection {
	private Driver target;
	private double my_x;
	private double my_y;
	public CollisionDetection(Driver d)
	{
		this.target = d;
	}
	public void set_my_loc(double x, double y)
	{
		this.my_x = x;
		this.my_y =y;
	}
	public Driver getTargetDriver()
	{
		return target;
	}
	public double Cal_Distence_Between_Twocars()
	{
		double dis;
		double t_x = this.target.getVehilce().getPosition().getX();
		double t_y = this.target.getVehilce().getPosition().getY();
		dis = Math.sqrt((t_x - my_x)*(t_x - my_x) +(t_y - my_y)*(t_y - my_y));
		
		return dis;
	}

}
