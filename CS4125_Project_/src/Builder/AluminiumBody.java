package Builder;

public class AluminiumBody extends carBody{

	private int CrashLevel;
	private double Loss;
	public AluminiumBody() 
	{
		setAttribute();
		
	}
	private void setAttribute()
	{
		this.CrashLevel = 6;
		this.Loss = 0;
	}
	@Override
	public String getExteriorName() {
		return "Exterior"+" AluminiumBody";
		
	}

}
