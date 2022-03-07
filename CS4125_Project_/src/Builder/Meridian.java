package Builder;

public class Meridian extends Sterieo{
	private double SoundQuality;
	private double Loss;
	public Meridian() 
	{
		setAttribute();
		
	}
	private void setAttribute()
	{
		this.SoundQuality = 5;
		this.Loss = 0;
		
	}
	@Override
	public String getInteriorName() {
		// TODO Auto-generated method stub
		return "Interior"+" Meridian";
	}


}
