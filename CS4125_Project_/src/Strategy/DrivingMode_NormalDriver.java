package Strategy;

import Driver.*;

public class DrivingMode_NormalDriver implements Strategy{
	
//	public void changeDrivingMode_Nor_Default(NormalDriver nor) {
//		nor.drive();
//	    nor.Drive();
//	}
//	
//	public void changeDrivingMode_Nor_Safe(NormalDriver nor) {
//		nor.drive();
//	    nor.Drive_Safe();
//	}
//	
//	public void changeDrivingMode_Nor_Racer(NormalDriver nor) {
//		nor.drive();
//		nor.Drive_Racer();
//	}
//	
//	public void changeDrivingMode_Irr_Default(IrritableDriver irr) {}
//	
//	public void changeDrivingMode_Irr_Safe(IrritableDriver irr) {}
//	
//	public void changeDrivingMode_Irr_Racer(IrritableDriver irr) {}
	
	public void changeDrivingMode_Irr(int code, IrritableDriver irr) {
		//keep empty
	}
	
	public void changeDrivingMode_Nor(int code, NormalDriver nor) {
		if(code == 1)//DefaultMode
		{	    
		    nor.drive();
		    nor.Drive();	
		}
		else if(code == 2)//SafeMode
		{
		    nor.drive();
		    nor.Drive_Safe();
			
		}
		else if(code == 3)//RacerMode
		{
			nor.drive();
			nor.Drive_Racer();
		}
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private double FerrariSpeed_Racer;
//	private double BenzSpeed_Racer;
//	private double MazdaSpeed_Racer;
//	private double SantanaSpeed_Racer;
//	private double V3Engine_Racer;
//	private double V4Engine_Racer;
//	private double V6Engine_Racer;
//	private double V8Engine_Racer;
	
//	@Override
//	public void changeDrivingMode() {
//		//Change the initial speed of all four vehicles to 125% of the default speed
//		DrivingStyle_Default dsd = new DrivingStyle_Default();
//		this.FerrariSpeed_Racer = dsd.getFerrariSpeed() * 1.25;
//		this.BenzSpeed_Racer = dsd.getBenzSpeed() * 1.25;
//		this.MazdaSpeed_Racer = dsd.getMazdaSpeed() * 1.25;
//		this.SantanaSpeed_Racer = dsd.getSantanaSpeed() * 1.25; 
//		//Set the acceleration of the four vehicles to 2 times the default acceleration
//		this.V3Engine_Racer = dsd.getV3Engine() * 2;
//		this.V4Engine_Racer = dsd.getV4Engine() * 2;
//		this.V6Engine_Racer = dsd.getV6Engine() * 2;
//		this.V8Engine_Racer = dsd.getV8Engine() * 2;
//	}
	
//	public double getFerrariSpeed() {
//		return this.FerrariSpeed_Racer;
//	}
//	
//	public double getBenzSpeed() {
//		return this.BenzSpeed_Racer;
//	}
//	
//	public double getMazdaSpeed() {
//		return this.MazdaSpeed_Racer;
//	}
//	
//	public double getSantanaSpeed() {
//		return this.SantanaSpeed_Racer;
//	}
//
//	public double getV3Engine() {
//		return this.V3Engine_Racer;
//	}
//	
//	public double getV4Engine() {
//		return this.V4Engine_Racer;
//	}
//	
//	public double getV6Engine() {
//		return this.V6Engine_Racer;
//	}
//	
//	public double getV8Engine() {
//		return this.V8Engine_Racer;
//	}
	
	
	


