package Vehicle;

import Strategy.DrivingMode_Default;

public class V3EngineDecorator extends VehicleEngineDecorator{
	
	private double acceleration;
	
	public V3EngineDecorator() {
		DrivingMode_Default dsd = new DrivingMode_Default();
		this.acceleration = dsd.getV3Engine();
	}
	
	public V3EngineDecorator(VehicleType decoratedV) {// the constructor function 
		super(decoratedV);// send this variable to the father class
		setAcceleration();// set the acceleration
	}

	//return the corresponding information of the car that is equipped with v3 
	@Override
	public double getspeed() {
		// TODO Auto-generated method stub
		return super.decoratedVehicleType.getspeed();
	}

	
	public double getVehicleLength() {
		// TODO Auto-generated method stub
		return super.decoratedVehicleType.getVehicleLength();
	}

	
	public double getVehicleWidth() {
		// TODO Auto-generated method stub
		return super.decoratedVehicleType.getVehicleWidth();
	}

	
	public String getVehicleImagePath() {
		// TODO Auto-generated method stub
		return super.decoratedVehicleType.getVehicleImagePath();
	}

	public double getacceleration() {
		// TODO Auto-generated method stub
		return this.acceleration;
	}
	
	//this function can set the acceleration
	private void setAcceleration() {
		this.acceleration = 0.0007 * 2;
	}
	
	public double getAcceleration() {
		return this.acceleration;
	}

	@Override
	public String getCarName() {
		// TODO Auto-generated method stub
		return super.decoratedVehicleType.getCarName();
	}

}
