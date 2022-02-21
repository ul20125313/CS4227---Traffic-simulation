package Vehicle;

public abstract class VehicleEngineDecorator implements VehicleType{// this class will be extended by the decorated car that has different engines.
	protected VehicleType decoratedVehicleType;
	
	public VehicleEngineDecorator(VehicleType decoratedVehicleType) {// the constructor function
		this.decoratedVehicleType = decoratedVehicleType;
	
	}
	
	public abstract double getAcceleration();
	
}
