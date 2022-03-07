package Builder;

public class SteelBody extends carBody{

	private int CrashLevel;
	private double Loss;
	public SteelBody() 
	{
		setAttribute();
		
	}
	private void setAttribute()
	{
		this.CrashLevel = 3;
		this.Loss = 1;
	}
	@Override
	public String getExteriorName() {
		return "Exterior"+" SteelBody";
		
	}
	
	
	
}
