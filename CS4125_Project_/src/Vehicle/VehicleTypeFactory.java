package Vehicle;

public class VehicleTypeFactory {
	public static enum Vehicle_Type// there are at total four kinds of cars.
	{
		Ferrari,
		Benz,
		Mazda,
		Santana
	};

	public VehicleType createVehicle(Vehicle_Type type) 
	{
		//return which cars depends on the inputting enum type
			
		switch(type)
		{
		case Ferrari:
			return new Ferrari();
			
		case Benz:
			return new Benz();
		
		case Mazda:
			return new Mazda();
		
		case Santana:
			return new Santana();
			
		default:
			return null;
		
		}
	}

}
