package Simulation_Control;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;

import Adapter.CHYPayment;
import Builder.CarBuilder;
import Builder.Exterior;
import Builder.Interior;
import CollisionDetection.CollisionDetection;
import CollisionDetection.cd_Algorithm1;
import CollisionDetection.cd_Algorithm2;
import Command.SpeedChangedKey;
import Command.VehicleAccelerationCommand;
import Command.VehicleDecelerationCommand;
import Draw_Map.ButtonCreate;
import Driver.Driver;
import Driver.DriverFactory;
import Driver.IrritableDriver;
import Driver.NormalDriver;
import Road.Lane;
import Road.Lane1;
import Road.Lane2;
import Road.Lane3;
import Road.Lane4;
import Vehicle.V6EngineDecorator;
import Vehicle.V8EngineDecorator;
import Vehicle.V3EngineDecorator;
import Vehicle.V4EngineDecorator;
import Vehicle.Vehicle;
import Vehicle.VehicleEngineDecorator;
import Vehicle.VehicleType;
import Vehicle.VehicleTypeFactory;

import Simulation_Control.Thread_source;


public class Sim_Controller extends Thread_source{
	private double map_wi, map_he;
	private Thread_source graphics; //the Gra_Controller
	private ArrayList<Lane> lanes;
	private ArrayList<Driver>drivers;
	private ArrayList<CollisionDetection>Detections;

	private Point Firstcar_loc;
	private Point Secondcar_loc;
	private Point Thirdcar_loc;
	private Point Fourthcar_loc;
	private Point Fifthcar_loc;
	private Point Sixthcar_loc;
	private Point Seventhcar_loc;
	private Point Eighthcar_loc;
	private Point Ninthcar_loc;
	private JFrame jf;
	private SpeedChangedKey speedchanged_key;
	
	public VehicleAccelerationCommand vehicleAccelerationCommand;
	public VehicleDecelerationCommand vehicleDecelerationCommand;
	
	
	
	protected CollisionDetection c1;
	protected CollisionDetection c2;
	protected CollisionDetection c3;
	protected CollisionDetection c4;
	
	private CarBuilder cb1;
	

	
	public Sim_Controller()
	{
		this.cb1 = new CarBuilder();
		this.cb1.prepare_cheap_car();
		this.showCheapCar_Parts();
	
		this.drivers = new ArrayList<>();
		this.Detections = new ArrayList<>();
		System.out.println("[Sim_Control]");
		System.out.println("----------------------------");
		this.map_wi = 1000;
		this.map_he = 606; // need change
		this.init_lanes();
		
		this.create_Driver();
		this.graphics = new Gra_Controller(this.map_wi, this.map_he, drivers, this.lanes, this);
		this.speedchanged_key = new SpeedChangedKey(jf);
		
		
	}
	public void showCheapCar_Parts()
	{
		
		System.out.println("Cheap car's parts list:");
		ArrayList<Exterior>exs;
		exs = this.cb1.getCar().getExlist();
		for(Exterior ex : exs)
		{
			System.out.println(ex.getExteriorName());
		}
		
		
		ArrayList<Interior>ins;
		ins = this.cb1.getCar().getInlist();
		for(Interior in : ins)
		{
			System.out.println(in.getInteriorName());
		}
		System.out.println();
	}
	
	public void setJframe(JFrame jf)
	{
		this.jf = jf;
	}
	
	public void create_Driver()
	{
		VehicleTypeFactory v_fac = new VehicleTypeFactory();
		VehicleType Ferrari = v_fac.createVehicle(VehicleTypeFactory.Vehicle_Type.Ferrari);	// the factory will return the corresponding instance
		VehicleType Benz = v_fac.createVehicle(VehicleTypeFactory.Vehicle_Type.Benz);
		VehicleType Mazda = v_fac.createVehicle(VehicleTypeFactory.Vehicle_Type.Mazda);
		VehicleType Santana = v_fac.createVehicle(VehicleTypeFactory.Vehicle_Type.Santana);
		
		//the codes below uses the decorated pattern
		VehicleEngineDecorator v8EngineCar = new V8EngineDecorator(Ferrari);//for example, v8Engine will be equipped with Ferrari here
		VehicleEngineDecorator v6EngineCar = new V6EngineDecorator(Benz);
		VehicleEngineDecorator v4EngineCar = new V4EngineDecorator(Mazda);
		VehicleEngineDecorator v3EngineCar = new V3EngineDecorator(Santana);
		
		
		this.Firstcar_loc = new Point((500), (25));	
		this.Secondcar_loc = new Point((500),(50));
		this.Thirdcar_loc = new Point((500),(75));
		this.Fourthcar_loc = new Point((500),(506));
		this.Fifthcar_loc = new Point((500),(481));
		this.Sixthcar_loc = new Point((500),(456));
		this.Seventhcar_loc = new Point((728),(303));
	
		
		this.c1= new CollisionDetection(new cd_Algorithm1());
		this.c2= new CollisionDetection( new cd_Algorithm1());
		this.c3 = new CollisionDetection( new cd_Algorithm2());
		
		DriverFactory d_fac = new DriverFactory();
		// the code fragment below will distribute temper to every driver randomly.
		int DriverTemperJudge;
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive1 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Firstcar_loc, this.lanes.get(0), v8EngineCar), "J.J", "Normal", 1);
			this.drivers.add(Drive1);
			this.c1.addTargetDriver(Drive1);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive1 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Firstcar_loc, this.lanes.get(0), v8EngineCar), "J.J", "Irritable", 1);
			this.drivers.add(Drive1);
			this.c1.addTargetDriver(Drive1);
		}
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive2 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Secondcar_loc, this.lanes.get(1), v6EngineCar), "Sam", "Normal", 8);
			this.drivers.add(Drive2);
			this.c2.addTargetDriver(Drive2);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive2 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Secondcar_loc, this.lanes.get(1), v6EngineCar), "Sam", "Irritable", 8);
			this.drivers.add(Drive2);
			this.c2.addTargetDriver(Drive2);
		}
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive3 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Thirdcar_loc, this.lanes.get(2), v4EngineCar), "Tom", "Normal", 8);
			this.drivers.add(Drive3);
			this.c3.addTargetDriver(Drive3);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive3 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Thirdcar_loc, this.lanes.get(2), v4EngineCar), "Tom", "Irritable", 8);
			this.drivers.add(Drive3);
			this.c3.addTargetDriver(Drive3);
		}
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive4 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Fourthcar_loc, this.lanes.get(0), v3EngineCar), "Jack", "Normal", 8);
			this.drivers.add(Drive4);
			this.c1.addTargetDriver(Drive4);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive4 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Fourthcar_loc, this.lanes.get(0), v3EngineCar), "Jack", "Irritable", 8);
			this.drivers.add(Drive4);
			this.c1.addTargetDriver(Drive4);
		}

		if(DriverTemperJudge == 0) {
			Driver Drive5 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Fifthcar_loc, this.lanes.get(1), v3EngineCar), "Jim", "Normal", 8);
			this.drivers.add(Drive5);
			this.c2.addTargetDriver(Drive5);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive5 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Fifthcar_loc, this.lanes.get(1), v3EngineCar), "Jim", "Irritable", 8);
			this.drivers.add(Drive5);
			this.c2.addTargetDriver(Drive5);

		}	
		if(DriverTemperJudge == 0) {
			Driver Drive6 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Sixthcar_loc, this.lanes.get(2), v3EngineCar), "Nik", "Normal", 8);
			this.drivers.add(Drive6);
			this.c3.addTargetDriver(Drive6);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive6 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Sixthcar_loc, this.lanes.get(2), v3EngineCar), "Nik", "Irritable", 8);
			this.drivers.add(Drive6);
			this.c3.addTargetDriver(Drive6);
		}	
		if(DriverTemperJudge == 0) {
			Driver Drive7 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Seventhcar_loc, this.lanes.get(2), v4EngineCar), "Dan", "Normal", 8);
			this.drivers.add(Drive7);
			this.c3.addTargetDriver(Drive7);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive7 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Seventhcar_loc, this.lanes.get(2), v4EngineCar), "Dan", "Irritable", 8);
			this.drivers.add(Drive7);
			this.c3.addTargetDriver(Drive7);

		}
		this.Detections.add(c1);
		this.Detections.add(c2);
		this.Detections.add(c3);
		
		

	}
	
	public void init_lanes()
	{
		//create the arraylist for lanes
		this.lanes = new ArrayList<>();		
		Lane1 lane1 = new Lane1();//will use the arraylist
		lane1.setLaneNumber(1);
		this.lanes.add(lane1);
		
		Lane2 lane2 = new Lane2();//will use the arraylist  
		this.lanes.add(lane2);
		lane2.setLaneNumber(2);
		
		Lane3 lane3 = new Lane3();
		this.lanes.add(lane3);
		lane3.setLaneNumber(3);
		
		Lane4 lane4 = new Lane4();
		this.lanes.add(lane4);
		lane4.setLaneNumber(4);
		 
	}
	
	public void begin()
	{
		boolean driver_has_enough_money = true;
		CHYPayment chypay = new CHYPayment();
		for(Driver d : drivers)//every driver is thread, so here, it starts every thread
		{
			
            chypay.setDriverInformation(d);
			if(!chypay.check_whether_can_afford())
			{
				continue;
			}
			if(d.getName().equals("J.J")) {
				this.speedchanged_key.setDriver(d);
				
				this.vehicleAccelerationCommand = new VehicleAccelerationCommand(d);
				this.speedchanged_key.getvehicleAccelerationCommand(vehicleAccelerationCommand);
				this.vehicleDecelerationCommand = new VehicleDecelerationCommand(d);
				this.speedchanged_key.getvehicleDecelerationCommand(vehicleDecelerationCommand);
				
				this.speedchanged_key.setKeyEvent();
			}
			if(d.getClass().toString().equals("class Driver.NormalDriver")) 
			{
//				if(d.getVehilce().getLane().getLaneNumber() == 1)
//				{
//					if(!this.c1.getTargetDriver().getName().equals(d.getName()))
//					{
//						
//						d.setColl(this.c1);
//					}
//					
//				}
//				else if(d.getVehilce().getLane().getLaneNumber() == 2)
//				{
//					if(!this.c2.getTargetDriver().getName().equals(d.getName()))
//					{
//						d.setColl(this.c2);//detectcollision
//					}
//					
//				}
//				else if(d.getVehilce().getLane().getLaneNumber() == 3)
//				{
//					if(!this.c3.getTargetDriver().getName().equals(d.getName()))
//					{
//						System.out.println(d.getName());
//						d.setColl(this.c3);
//					}
//					
//				}

				NormalDriver NormalDriver = (NormalDriver)d;//downward transition, convert driver class to normalDriver class
				new Thread(NormalDriver).start();		
		    }
			
		     else if(d.getClass().toString().equals("class Driver.IrritableDriver")) 
		    {
		    
//		    	 if(d.getVehilce().getLane().getLaneNumber() == 1)
//		    	 {
//		    		 if(!this.c1.getTargetDriver().getName().equals(d.getName()))
//		    		 {
//		    			 System.out.println(d.getName());
//		    			 d.setColl(this.c1);
//		    		 }
//					
//		    	 }
//		    	 else if(d.getVehilce().getLane().getLaneNumber() == 2)
//		    	 {
//						if(!this.c2.getTargetDriver().getName().equals(d.getName()))
//						{						
//							d.setColl(this.c2);
//						}
//						
//				}
//		    	 else if(d.getVehilce().getLane().getLaneNumber() == 3)
//					{
//						if(!this.c3.getTargetDriver().getName().equals(d.getName()))
//						{
//							System.out.println(d.getName());
//							d.setColl(this.c3);
//						}
//						
//					}
		    	 
		    	 IrritableDriver IrritableDriver = (IrritableDriver)d;//downward transition, convert driver class to irritableDriver class
		    	 new Thread(IrritableDriver).start();

		    }			
			
		}
		for(CollisionDetection cd :Detections)
		{
			new Thread(cd).start();
		}
	
		graphics.run();
		
	}
	
	

}
