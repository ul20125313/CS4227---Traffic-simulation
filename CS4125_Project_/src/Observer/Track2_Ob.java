package Observer;

import java.util.ArrayList;

//this class will observe all of the imfomation about the driver in lane 2
public class Track2_Ob implements Observer{// this is one of observer classes that implements observer interface
	
    private Subject S_monitor;
    ArrayList<Double>speeds;
    ArrayList<String>drivernames;
    ArrayList<String>carNames;
    ArrayList<String>driverTempers;
    
	public Track2_Ob(Subject Speed_monitor)//constructor class
	{
		this.S_monitor = S_monitor;
		Speed_monitor.registerOb(this);
		
	}
	@Override
	public void update(ArrayList<Double>speeds, ArrayList<String>drivernames, ArrayList<String>carNames, ArrayList<String>driverTempers) {
		this.speeds = speeds;
		this.drivernames = drivernames;
		this.carNames = carNames;
		this.driverTempers = driverTempers;
	
	}
	
	// the functions below will return the corresponding information, when they are called
	public double Track2_speed()
	{
		return this.speeds.get(1);
	}
	
	public String Track2_drivernames()
	{
		return this.drivernames.get(1);
	}
	public String Track2_carnames()
	{
		return this.carNames.get(1);
	}
	public String Track2_driverTempers()
	{
		return this.driverTempers.get(1);
	}
}
