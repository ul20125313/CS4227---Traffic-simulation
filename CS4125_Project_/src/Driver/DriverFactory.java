package Driver;


import CollisionDetection.CollisionDetection;
import Vehicle.Vehicle;
//this class takes use of the factory pattern
public class DriverFactory  {
	public enum DriverTemper{ // two kinds of enum type helps return the corresponding class instance
		NORMAL,
		IRRITABLE
	}
	
	public Driver createDriver(DriverTemper temper, Vehicle vehicle, String name, String driverTemperType, int balance) {
		switch(temper) { // return the corressponding instance
			case NORMAL:{
				return new NormalDriver(name,vehicle, driverTemperType, balance);
			}
			case IRRITABLE:{
				return new IrritableDriver(name,vehicle, driverTemperType, balance);
			}
		}
		return null;                      
	}
}