package Strategy;

import Driver.*;
import Thread.Threadprocess;

public class DrivingMode_IrritableDriver implements Strategy{
	//Safe mode: all cars will remain in uniform motion and the acceleration of all vehicles will be cancelled.
	
	@Override
	public void changeDrivingMode_Irr_Default(IrritableDriver irr) {
		irr.drive();
	    irr.Drive();
	}
	
	public void changeDrivingMode_Irr_Safe(IrritableDriver irr) {
		irr.drive();
	    irr.Drive_Safe();
	}
	
	public void changeDrivingMode_Irr_Racer(IrritableDriver irr) {
		irr.drive();
		irr.Drive_Racer();
	}
	
	public void changeDrivingMode_Nor_Default(NormalDriver nor) {}
	
	public void changeDrivingMode_Nor_Safe(NormalDriver nor) {}
	
	public void changeDrivingMode_Nor_Racer(NormalDriver nor) {}
	
	
	
	
	}
	
//	private double FerrariSpeed_Safe;
//	private double BenzSpeed_Safe;
//	private double MazdaSpeed_Safe;
//	private double SantanaSpeed_Safe;
//	private double V3Engine_Safe;
//	private double V4Engine_Safe;
//	private double V6Engine_Safe;
//	private double V8Engine_Safe;
//	
//	@Override
//	public void changeDrivingMode() {
//		//Change the initial speed of all four vehicles to 75% of the default speed
//		DrivingMode_Default dsd = new DrivingMode_Default();
//		this.FerrariSpeed_Safe = dsd.getFerrariSpeed() * 0.75;
//		this.BenzSpeed_Safe = dsd.getBenzSpeed() * 0.75;
//		this.MazdaSpeed_Safe = dsd.getMazdaSpeed() * 0.75;
//		this.SantanaSpeed_Safe = dsd.getSantanaSpeed() * 0.75;
//		//Set the acceleration to 0 for all four vehicles
//		this.V3Engine_Safe = dsd.getV3Engine() * 0;
//		this.V4Engine_Safe = dsd.getV4Engine() * 0;
//		this.V6Engine_Safe = dsd.getV6Engine() * 0;
//		this.V8Engine_Safe = dsd.getV8Engine() * 0;
//	}
//	
//	public double getFerrariSpeed() {
//		return this.FerrariSpeed_Safe;
//	}
//	
//	public double getBenzSpeed() {
//		return this.BenzSpeed_Safe;
//	}
//	
//	public double getMazdaSpeed() {
//		return this.MazdaSpeed_Safe;
//	}
//	
//	public double getSantanaSpeed() {
//		return this.SantanaSpeed_Safe;
//	}
//	
//	public double getV3Engine() {
//		return this.V3Engine_Safe;
//	}
//	
//	public double getV4Engine() {
//		return this.V4Engine_Safe;
//	}
//	
//	public double getV6Engine() {
//		return this.V6Engine_Safe;
//	}
//	
//	public double getV8Engine() {
//		return this.V8Engine_Safe;
//	}
	
	

