package Driver;

import CollisionDetection.CollisionDetection;
import Thread.Threadprocess;
import Vehicle.Vehicle;

public class NormalDriver extends Driver{
	
//	private String DriverTemperType;
	
	private double max_limitedSpeed;
	private double min_limitedSpeed;
	private double currentspeed;
	
	private boolean isDecelerate;
	

	public NormalDriver(String name, Vehicle vehicle, String driverTemperType) {
		super(name, vehicle, driverTemperType);
//		this.DriverTemperType = "Normal";
		this.max_limitedSpeed = 2 * 30;// normal driver always has lower minimum speed
		this.min_limitedSpeed = 1 * 30;// normal driver always has higher maximum speed
		//this.Drive();
		
		this.isDecelerate = false;
		// TODO Auto-generated constructor stub
	}
	
//	public String getDriverTemperType() {
//		return this.DriverTemperType;
//	}
	
	public double getMaxLimitedSpeed() { 
		return this.max_limitedSpeed;//return the maximum of the speed of normal driver
	}
	
	public double getMinLimitedSpeed() {
		return this.min_limitedSpeed;//return the minimum of the speed of normal driver
	}
	
	public void Drive() {//the driving method for normal driver
		//System.out.println("B");
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
	// this function is used to inspect the output the results, in our final version, it won't be called
	public void pri() {
		System.out.println(vehicle.getCarName() + "--" + getDriverTemperType() + "--" + vehicle.getSpeed());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Threadprocess t = new Threadprocess(Threadprocess.DEFAULT_FRAMERATE);
		t.setMessage("Driver");
		while(true)
		{
			t.start();
			this.drive();
			this.Drive();
			t.end();
		}
		
	}

}
