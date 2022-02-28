package Driver;
import CollisionDetection.CollisionDetection;
import Thread.Threadprocess;
import Vehicle.Vehicle;

public abstract class Driver implements Runnable{
	
	private String name;
    protected Vehicle vehicle;
    protected String driverTemperType;
    protected CollisionDetection c;

	public Driver(String name, Vehicle vehicle, String driverTemperType)//the constructor of class driver
	{
		this.name = name;
		this.vehicle = vehicle;
		this.driverTemperType = driverTemperType;
		
	}
	public void setColl(CollisionDetection c)
	{
		this.c = c;
	}
	public String getName()// return the name
	{
		return this.name;
	}
	
	public Vehicle getVehilce()// return the object driver
	{
		return this.vehicle;
	}
	
	public void drive()// call the move function in instance vehicle
	{
		//it seems that driver is driving his car
		
		this.vehicle.move();
	}
	
	@Override
	 public abstract void run();
	
	public String getDriverTemperType() {// return the driverTemperTpe
		return this.driverTemperType;
	}
	
	public void pri() {
		
	}
	
	public void Drive() {
		
	}


}
