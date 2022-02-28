package Simulation_Control;
import java.awt.*;
import java.util.ArrayList;

import CollisionDetection.CollisionDetection;
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

	private Point Firstcar_loc;
	private Point Secondcar_loc;
	private Point Thirdcar_loc;
	private Point Fourthcar_loc;
	private CollisionDetection c1;
	
	public Sim_Controller()
	{
		
		this.drivers = new ArrayList<>();
		System.out.println("[Sim_Control]");
		System.out.println("----------------------------");
		this.map_wi = 1000;
		this.map_he = 606; // need change
		this.init_lanes();
		this.create_Driver();
		this.graphics = new Gra_Controller(this.map_wi, this.map_he, drivers, this.lanes);
		
		
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
		
		
		DriverFactory d_fac = new DriverFactory();
		// the code fragment below will distribute temper to every driver randomly.
		int DriverTemperJudge;
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive1 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Firstcar_loc, this.lanes.get(0), v8EngineCar), "J.J", "Normal");
			this.drivers.add(Drive1);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive1 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Firstcar_loc, this.lanes.get(0), v8EngineCar), "J.J", "Irritable");
			this.drivers.add(Drive1);
		}
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive2 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Secondcar_loc, this.lanes.get(1), v6EngineCar), "Sam", "Normal");
			this.drivers.add(Drive2);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive2 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Secondcar_loc, this.lanes.get(1), v6EngineCar), "Sam", "Irritable");
			this.drivers.add(Drive2);
		}
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive3 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Thirdcar_loc, this.lanes.get(2), v4EngineCar), "Tom", "Normal");
			this.drivers.add(Drive3);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive3 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Thirdcar_loc, this.lanes.get(2), v4EngineCar), "Tom", "Irritable");
			this.drivers.add(Drive3);
		}
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive4 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Fourthcar_loc, this.lanes.get(0), v3EngineCar), "Jack", "Normal");
			this.drivers.add(Drive4);
			this.c1= new CollisionDetection(Drive4);
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive4 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Fourthcar_loc, this.lanes.get(0), v3EngineCar), "Jack", "Irritable");
			this.drivers.add(Drive4);
			this.c1= new CollisionDetection(Drive4);
		}

	}
	
	public void init_lanes()
	{
		//create the arraylist for lanes
		this.lanes = new ArrayList<>();		
		Lane1 lane1 = new Lane1();//will use the arraylist
		this.lanes.add(lane1);
		Lane2 lane2 = new Lane2();//will use the arraylist  
		this.lanes.add(lane2);
		Lane3 lane3 = new Lane3();
		this.lanes.add(lane3);
		Lane4 lane4 = new Lane4();
		this.lanes.add(lane4);
		 
	}
	
	public void begin()
	{
		for(Driver d : drivers)//every driver is thread, so here, it starts every thread
		{
				
			if(d.getClass().toString().equals("class Driver.NormalDriver")) 
			{
				d.setColl(this.c1);
				NormalDriver NormalDriver = (NormalDriver)d;//downward transition, convert driver class to normalDriver class
				new Thread(NormalDriver).start();		
		    }
		     else if(d.getClass().toString().equals("class Driver.IrritableDriver")) 
		    {
		    	 d.setColl(this.c1);
		    	 IrritableDriver IrritableDriver = (IrritableDriver)d;//downward transition, convert driver class to irritableDriver class
		    	 new Thread(IrritableDriver).start();
			
		    }
			
		}
		graphics.run();
		
	}
	
	

}
