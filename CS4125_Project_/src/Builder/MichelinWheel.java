package Builder;

import Vehicle.Vehicle;

public class MichelinWheel extends Wheel{
	
	
	private double Friction;
	private double Loss;
	public MichelinWheel() 
	{
		setAttribute();
		
	}
	private void setAttribute()
	{
		this.Friction = 1;
		this.Loss = 0;
	}
	public String getExteriorName() {
		return "Exterior"+" MichelinWheel";
		
	}
	
	

}
