package Builder;

public class CarBuilder {
	private Car c;
	public void buildCar()
	{
		this.c = new Car();
	}
	public void buidWheel(Wheel w)
	{
		this.c.add_Exterior(w);
		
	}

	public void buildSterieo(Sterieo s)
	{
		this.c.add_Interior(s);
	}
	public void buildcarBody(carBody cb)
	{
		this.c.add_Exterior(cb);
	}
	public void buildChair(Chair ch)
	{
		this.c.add_Interior(ch);
	}
	public Car getCar()
	{
		return this.c;
	}

}
