package Builder;

public class CarBuilder {
	private Car c;
	public void prepare_expensive_car()
	{
		this.c = new Car();
		c.add_Exterior(new MichelinWheel());
		c.add_Exterior(new AluminiumBody());
		c.add_Interior(new Meridian());
		c.add_Interior(new Leather_chair());
		
	}
	
	public void prepare_cheap_car()
	{
		this.c = new Car();
		c.add_Exterior(new CheapWheel());
		c.add_Exterior(new SteelBody());
		c.add_Interior(new FOCAL());
		c.add_Interior(new Man_made_chair());
	}
	public Car getCar()
	{
		return this.c;
	}

}
