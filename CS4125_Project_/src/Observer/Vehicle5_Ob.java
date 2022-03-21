package Observer;

import java.util.ArrayList;

//this class will observe all of the imfomation about the driver in lane 1
public class Vehicle5_Ob implements Observer{// this is one of observer classes that implements observer interface
	
    private Subject S_monitor;
    ArrayList<Double>speeds;
    ArrayList<String>drivernames;
    ArrayList<String>carNames;
    ArrayList<String>driverTempers;
    
	public Vehicle5_Ob(Subject Speed_monitor)//constructor class
	{
		this.S_monitor = S_monitor;
		Speed_monitor.registerOb(this);
		
	}
	@Override
	public void update(ArrayList<Double>speeds, ArrayList<String>drivernames, ArrayList<String>carNames, ArrayList<String>driverTempers) {
		//this will be always called by the notify function in subject concrete class
		this.speeds = speeds;
		this.drivernames = drivernames;
		this.carNames = carNames;
		this.driverTempers = driverTempers;

	}
	// the functions below will return the corresponding information, when they are called
	public double Vehicle5_speed()
	{
		return this.speeds.get(4);
	}
	
	public String Vehicle5_drivernames()
	{
		return this.drivernames.get(4);
	}
	public String Vehicle5_carnames()
	{
		return this.carNames.get(4);
	}
	public String Vehicle5_driverTempers()
	{
		return this.driverTempers.get(4);
	}

}
