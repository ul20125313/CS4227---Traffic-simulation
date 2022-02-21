/**
 * 
 */
package Driver;

import Thread.Threadprocess;
import Vehicle.Vehicle;


public class IrritableDriver extends Driver {// the irriable driver extends the driver class
	
//	private String DriverTemperType;
	
	private double max_limitedSpeed;
	private double min_limitedSpeed;
	private double currentspeed;
	
	private boolean isDecelerate;
		
    // every kind of driver has different driving style
	public IrritableDriver(String name, Vehicle vehicle, String driverTemperType) {// the constructor function of this class
		super(name, vehicle, driverTemperType);
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
		while(true)
		{
			t.start();
			this.drive();
			this.Drive();
			t.end();
		}
		
	}

}
