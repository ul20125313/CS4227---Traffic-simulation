package Observer;

import java.util.ArrayList;

//this class will observe all of the imfomation about the driver in lane 1
public class Track1_Ob implements Observer{// this is one of observer classes that implements observer interface
	
    private Subject S_monitor;
    ArrayList<Double>speeds;
    ArrayList<String>drivernames;
    ArrayList<String>carNames;
    ArrayList<String>driverTempers;
    
	public Track1_Ob(Subject Speed_monitor)//constructor class
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
	public double Track1_speed()
	{
		return this.speeds.get(0);
	}
	
	public String Track1_drivernames()
	{
		return this.drivernames.get(0);
	}
	public String Track1_carnames()
	{
		return this.carNames.get(0);
	}
	public String Track1_driverTempers()
	{
		return this.driverTempers.get(0);
	}

}
