package CollisionDetection;

import java.util.ArrayList;

import Driver.Driver;

public abstract class GeneralCollisionDetection implements Runnable{
	protected CollisionDetectionAlgorithm a;
	protected ArrayList<Driver>target_drivers;
	public GeneralCollisionDetection( CollisionDetectionAlgorithm a)
	{
		//this.target = d;
		this.target_drivers = new ArrayList<>();
		this.a = a;
	}
	public abstract void addTargetDriver(Driver d);

}
