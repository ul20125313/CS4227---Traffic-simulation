package Builder;

public class Leather_chair extends Chair{

	private String seatMaterial;
	private int Comfort;
	public Leather_chair() 
	{
		setAttribute();
	}

	
	private void setAttribute()
	{
		this.seatMaterial = "Artificial leather";
		this.Comfort = 0;
	}
	
	protected void SeatAdjustment()
	{	
		Comfort+=1;
	}
	public String getInteriorName()
	{
		return "Interior"+" Leather_chair";
	}

}
