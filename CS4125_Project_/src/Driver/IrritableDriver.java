/**
 * 
 */
package Driver;

import CollisionDetection.CollisionDetection;
import Thread.Threadprocess;
import Vehicle.Vehicle;
import Strategy.*;


public class IrritableDriver extends Driver {// the irriable driver extends the driver class
	
//	private String DriverTemperType;
	
	private double max_limitedSpeed;
	private double min_limitedSpeed;
	private double currentspeed;
	private boolean isDecelerate;
		
	public IrritableDriver() {}
	
    // every kind of driver has different driving style
	public IrritableDriver(String name, Vehicle vehicle, String driverTemperType, int balance) {// the constructor function of this class
		super(name, vehicle, driverTemperType, balance);
//		this.DriverTemperType = "Irritable";
		this.max_limitedSpeed = 4 * 30; // the max limit speed for iterative driver
		this.min_limitedSpeed = 2 * 30; //the minimum of speed for iterative driver 
		//this.Drive();
		
		this.isDecelerate = false;
		// TODO Auto-generated constructor stub
	}
	
//	public String getDriverTemperType() {
//		return this.DriverTemperType;
//	}
	
	public double getMaxLimitedSpeed() {
		return this.max_limitedSpeed; // return the maximum of driving speed
	}
	
	public double getMinLimitedSpeed() {
		return this.min_limitedSpeed;// return the minimun of driving speed
	}
	
	public void Drive() {// the driving style for iterative driver
		currentspeed = vehicle.getSpeed();
		if(!isDecelerate) {//if the speed doesn't decrease, it will start increasing
			super.vehicle.speed_increase();// whether the speed increases depends on whether it exceeds the maximum of speed
			if(currentspeed >= max_limitedSpeed)
				isDecelerate = true;
		}
		else if(isDecelerate) {
			super.vehicle.speed_decrease();// whether the speed decreases depends on whether it is below the minimum of speed
			if(currentspeed <= min_limitedSpeed)
				isDecelerate = false;
		}
	}
	
	public void Drive_Safe() {//取消加速度和减速度，匀速行驶
		currentspeed = vehicle.getSpeed();
	}
	
	public void Drive_Racer() {// 取消减速度，提高加速度，让车保持加速行驶
		currentspeed = vehicle.getSpeed();
		if(!isDecelerate) {//if the speed doesn't decrease, it will start increasing
			super.vehicle.speed_increase_plus();// whether the speed increases depends on whether it exceeds the maximum of speed
			if(currentspeed >= max_limitedSpeed)
				isDecelerate = true;
		}
		else if(isDecelerate) {
			//super.vehicle.speed_decrease();// whether the speed decreases depends on whether it is below the minimum of speed
			if(currentspeed <= min_limitedSpeed)
				isDecelerate = false;
		}
	}
	
	
	// this function is used to inspect the output the results, in our final version, it won't be called
	public void pri() 
	{
		System.out.println(vehicle.getCarName() + "--" + getDriverTemperType() + "--" + vehicle.getSpeed());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Threadprocess t = new Threadprocess(Threadprocess.DEFAULT_FRAMERATE);
		t.setMessage("Driver");
		
		while(!super.is_Collision)
		{
			t.start();
			DrivingMode_IrritableDriver did = new DrivingMode_IrritableDriver(); 
			did.changeDrivingMode_Irr(super.mode_code, this);	
			
//			if(super.getVehilce().getLane().getLaneNumber() == 1&&!super.getName().equals("Jack"))//modify
//			{
//				check_if_collision();
//			}
//			if(super.getVehilce().getLane().getLaneNumber() == 2&&!super.getName().equals("Jim"))//modify
//			{
//				check_if_collision();//detectcollision
//			}
//			check_if_collision();
			t.end();		
		}

//		if(DrivingMode == 1) {//DrivingMode_Racer
//		while(!super.is_Collision) 
//		{
//		t.start();
//		disdetect();
//		this.drive();
//		this.Drive_Racer();
//		t.end();
//		}
//	}
//	else if(DrivingMode == 2) {//DrivingMode_Safe 取消加速度和减速度，保持匀速行驶
//		while(!super.is_Collision) 
//		{
//			t.start();
//			disdetect();
//			this.drive();
//			this.Drive_Safe();
//			t.end();
//		}
//	}else {//DrivingMode_Default
//		while(!super.is_Collision)
//		{
//			t.start();
//			disdetect();
//			this.drive();//路程+速度
//			this.Drive();//速度+加速度
//			t.end();
//		}
//	}
		
		
	}
	
	
	
	
	
	
	
//	public void check_if_collision ()
//	{
//		super.c.set_my_loc(super.getVehilce().getPosition().getX(), super.getVehilce().getPosition().getY());
//		super.c.work(this);
//	}

}

