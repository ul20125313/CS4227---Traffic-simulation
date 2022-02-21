package Observer;

import java.util.ArrayList;

//this class will observe all of the imfomation about the driver in lane 3
public class Track3_Ob implements Observer{// this is one of observer classes that implements observer interface
	
    private Subject S_monitor;
    ArrayList<Double>speeds;
    ArrayList<String>drivernames;
    ArrayList<String>carNames;
    ArrayList<String>driverTempers;
    
	public Track3_Ob(Subject Speed_monitor)//constructor class
	{
		this.S_monitor = S_monitor;
		Speed_monitor.registerOb(this);
		
	}
	@Override
	public void update(ArrayList<Double>speeds, ArrayList<String>drivernames,ArrayList<String>carNames, ArrayList<String>driverTempers) {
		this.speeds = speeds;
		this.drivernames = drivernames;
		this.carNames = carNames;
		this.driverTempers = driverTempers;
	}
	
	// the functions below will return the corresponding information, when they are called
	public double Track3_speed()
	{
		return this.speeds.get(2);
	}
	
	public String Track3_drivernames()
	{
		return this.drivernames.get(2);
	}
	public String Track3_carnames()
	{
		return this.carNames.get(2);
	}
	public String Track3_driverTempers()
	{
		return this.driverTempers.get(2);
	}

}
