package Builder;

public class FOCAL extends Sterieo{
	private double SoundQuality;
	private double Loss;
	public FOCAL() 
	{
		setAttribute();
		
	}
	private void setAttribute()
	{
		this.SoundQuality = 1;
		this.Loss = 3;
		
	}
	@Override
	public String getInteriorName() {
		// TODO Auto-generated method stub
		return "Interior"+"FOCAL ";
	}

}
