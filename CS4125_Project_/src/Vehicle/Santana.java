package Vehicle;

import Strategy.DrivingMode_Default;

public class Santana implements VehicleType{

	private double speed;
	private double vehiclelength;
	private double vehiclewidth;
	private String vehiclepath;
	private String CarName;
	
	// the private variables below is related to the information about Santana
	public Santana()
	{
		DrivingMode_Default dsd = new DrivingMode_Default();
		this.speed = dsd.getSantanaSpeed();
		
		this.vehiclelength = 20;
		this.vehiclewidth = 20;
		this.vehiclepath = "Santana.png";//
		this.CarName = "Santana";
	}
	
	//the codes are used to return information about corresponding car
	@Override
	public double getspeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	@Override
	public double getVehicleLength() {
		// TODO Auto-generated method stub
		return vehiclelength;
	}

	@Override
	public double getVehicleWidth() {
		// TODO Auto-generated method stub
		return vehiclewidth;
	}

	@Override
	public String getVehicleImagePath() {
		// TODO Auto-generated method stub
		return vehiclepath;
	}
	@Override
	public String getCarName() {
		// TODO Auto-generated method stub
		return CarName;
	}
	
}
