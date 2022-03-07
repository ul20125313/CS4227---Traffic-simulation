package Builder;

public class Man_made_chair extends Chair{


	private String seatMaterial;
	private int Comfort;
	public Man_made_chair() 
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
		return "Interior"+" Man_made_chair";
	}
	
	
	
}