package Builder;

public class CarBuilder {
	public void prepare_expensive_car()
	{
		Car c = new Car();
		c.add_Exterior(new Michelin());
		c.add_Exterior(new AluminiumBody());
		c.add_Interior(new Meridian());
		c.add_Interior(new Leather_chair());
		
	}
	
	public void prepare_cheap_car()
	{
		Car c = new Car();
		c.add_Exterior(new CheapWheel());
		c.add_Exterior(new SteelBody());
		c.add_Interior(new FOCAL());
		c.add_Interior(new Man_made_Chair());
	}

}
