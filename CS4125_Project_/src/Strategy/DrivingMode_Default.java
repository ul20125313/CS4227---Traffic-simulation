package Strategy;

public class DrivingMode_Default implements Strategy{//Set the default speed for all four vehicles
	
	private double FerrariSpeed_Default;
	private double BenzSpeed_Default;
	private double MazdaSpeed_Default;
	private double SantanaSpeed_Default;
	private double V3Engine_Default;
	private double V4Engine_Default;
	private double V6Engine_Default;
	private double V8Engine_Default;
	
	public DrivingMode_Default() {
		// Set the default initial speed of the four vehicles
		this.FerrariSpeed_Default = 1;
		this.BenzSpeed_Default = 0.5;
		this.MazdaSpeed_Default = 0.3;
		this.SantanaSpeed_Default = 0.2;
		// Set the default acceleration for the four engines
		this.V3Engine_Default = 0.0014;
		this.V4Engine_Default = 0.002;
		this.V6Engine_Default = 0.008;
		this.V8Engine_Default = 0.016;
	}
	
	public double getFerrariSpeed() {
		return this.FerrariSpeed_Default;
	}
	
	public double getBenzSpeed() {
		return this.BenzSpeed_Default;
	}
	
	public double getMazdaSpeed() {
		return this.MazdaSpeed_Default;
	}
	
	public double getSantanaSpeed() {
		return this.SantanaSpeed_Default;
	}
	
	public double getV3Engine() {
		return this.V3Engine_Default;
	}
	
	public double getV4Engine() {
		return this.V4Engine_Default;
	}
	
	public double getV6Engine() {
		return this.V6Engine_Default;
	}
	
	public double getV8Engine() {
		return this.V8Engine_Default;
	}
	@Override
	public void changeDrivingMode_Irr() {}
	
	public void changeDrivingMode_Nor() {}

}

