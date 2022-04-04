package Detection;

import java.util.ArrayList;

import Driver.Driver;

public abstract class Monitor implements Runnable{
	protected DetectionMethod a;
	protected ArrayList<Driver>target_drivers;
	public Monitor( DetectionMethod a)
	{
		//this.target = d;
		this.target_drivers = new ArrayList<>();
		this.a = a;
	}
	public abstract void addTargetDriver(Driver d);
	public abstract void removeTargetDriver(Driver d1);

}
