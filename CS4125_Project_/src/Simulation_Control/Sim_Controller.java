package Simulation_Control;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;

import Adapter.CHYPayment;
import Adapter.Picture;
import Builder.Car;
import Builder.CarBuilder;
import Builder.CheapWheel;
import Builder.Exterior;
import Builder.FOCAL;
import Builder.Interior;
import Builder.Man_made_chair;
import Builder.SteelBody;
import CollisionDetection.CollisionMonitor;
import CollisionDetection.Monitor;
import CollisionDetection.OvertakeMonitor;
import CollisionDetection.DetectionMethod_v1;
import CollisionDetection.DetectionMethod_v2;
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
	private static ArrayList<Lane> lanes;
	private ArrayList<Driver>drivers;
	private static ArrayList<Monitor>Monitors;

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
	
	
	
	private static Monitor c2;
	private static Monitor c3;
	private static Monitor c4;
	private static Monitor o2;
	private static Monitor o3;
	private static Monitor o4;
	//protected CollisionDetectionAlgorithm c4;
	
	
	public Sim_Controller()
	{
		this.showCar_Parts();
	
		this.drivers = new ArrayList<>();
		this.Monitors = new ArrayList<>();
		System.out.println("[Sim_Control]");
		System.out.println("----------------------------");
		this.map_wi = 1000;
		this.map_he = 606; // need change
		this.init_lanes();
		
		this.create_Drivers();
		this.init_Monitor();
		this.graphics = new Gra_Controller(this.map_wi, this.map_he, drivers, this.lanes, this);
		this.speedchanged_key = new SpeedChangedKey(jf);
		
		
	}
	
	public void showCar_Parts()
	{
		CarBuilder cb1 = new CarBuilder();
		cb1.buildCar();
		SteelBody steelbody = new SteelBody();
		CheapWheel cheapwheel = new CheapWheel();
		FOCAL focal = new FOCAL();
		Man_made_chair manmadechair = new Man_made_chair();
		cb1.buildcarBody(steelbody);
		cb1.buildChair(manmadechair);
		cb1.buildSterieo(focal);
		cb1.buidWheel(cheapwheel);
		Car c =cb1.getCar();
		ArrayList<Exterior>exs = new ArrayList<>();
		exs = c.getExlist();
		
		ArrayList<Interior>ins = new ArrayList<>();
		ins = c.getInlist();
		for(Exterior ex: exs)
		{
			System.out.println(ex.getExteriorName());
		}
		for(Interior in:ins)
		{
			System.out.println(in.getInteriorName());
		}

		
	}
	
	public void setJframe(JFrame jf)
	{
		this.jf = jf;
	}
	
	public void create_Drivers()
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
	
		
		this.c2= new CollisionMonitor(new DetectionMethod_v1());
		this.c3= new CollisionMonitor( new DetectionMethod_v1());
		this.c4 = new CollisionMonitor( new DetectionMethod_v1());
		
		DriverFactory d_fac = new DriverFactory();
		// the code fragment below will distribute temper to every driver randomly.
		int DriverTemperJudge;
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive1 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Firstcar_loc, this.lanes.get(0), v8EngineCar), "J.J", "Normal", 8);
			this.drivers.add(Drive1);
			
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive1 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Firstcar_loc, this.lanes.get(0), v8EngineCar), "J.J", "Irritable", 8);
			this.drivers.add(Drive1);
			
		}
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive2 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Secondcar_loc, this.lanes.get(1), v6EngineCar), "Sam", "Normal", 8);
			this.drivers.add(Drive2);
		
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive2 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Secondcar_loc, this.lanes.get(1), v6EngineCar), "Sam", "Irritable", 8);
			this.drivers.add(Drive2);
		
		}
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive3 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Thirdcar_loc, this.lanes.get(2), v4EngineCar), "Tom", "Normal", 8);
			this.drivers.add(Drive3);
		
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive3 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Thirdcar_loc, this.lanes.get(2), v4EngineCar), "Tom", "Irritable", 8);
			this.drivers.add(Drive3);
			
		}
		DriverTemperJudge = (int)(Math.random()*2);
		if(DriverTemperJudge == 0) {
			Driver Drive4 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Fourthcar_loc, this.lanes.get(0), v3EngineCar), "Jack", "Normal", 8);
			this.drivers.add(Drive4);
			
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive4 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Fourthcar_loc, this.lanes.get(0), v3EngineCar), "Jack", "Irritable", 8);
			this.drivers.add(Drive4);
			
		}

		if(DriverTemperJudge == 0) {
			Driver Drive5 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Fifthcar_loc, this.lanes.get(1), v3EngineCar), "Jim", "Normal", 1);
			this.drivers.add(Drive5);
			
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive5 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Fifthcar_loc, this.lanes.get(1), v3EngineCar), "Jim", "Irritable", 1);
			this.drivers.add(Drive5);
		

		}	
		if(DriverTemperJudge == 0) {
			Driver Drive6 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Sixthcar_loc, this.lanes.get(2), v3EngineCar), "Nik", "Normal", 8);
			this.drivers.add(Drive6);
			
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive6 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Sixthcar_loc, this.lanes.get(2), v3EngineCar), "Nik", "Irritable", 8);
			this.drivers.add(Drive6);
			
		}	
		if(DriverTemperJudge == 0) {
			Driver Drive7 = d_fac.createDriver(DriverFactory.DriverTemper.NORMAL, new Vehicle(3, this.Seventhcar_loc, this.lanes.get(2), v4EngineCar), "Dan", "Normal", 8);
			this.drivers.add(Drive7);
			
		}
		else if(DriverTemperJudge == 1) {
			Driver Drive7 = d_fac.createDriver(DriverFactory.DriverTemper.IRRITABLE, new Vehicle(3, this.Seventhcar_loc, this.lanes.get(2), v4EngineCar), "Dan", "Irritable", 8);
			this.drivers.add(Drive7);
	

		}


	}
	public void init_Monitor()
	{
		c2= new CollisionMonitor(new DetectionMethod_v1());
		c3= new CollisionMonitor( new DetectionMethod_v1());
		c4 = new CollisionMonitor( new DetectionMethod_v1());
		
		o2= new OvertakeMonitor(new DetectionMethod_v1());
		o3= new OvertakeMonitor( new DetectionMethod_v1());
		o4 = new OvertakeMonitor( new DetectionMethod_v1());
		
		for(Driver d : drivers)
		{
			switch(d.getVehilce().getLane().getLaneNumber())
			{
			case(4):
				c4.addTargetDriver(d);
			o4.addTargetDriver(d);

			break;
			case(3):
				c3.addTargetDriver(d);
			o3.addTargetDriver(d);

			break;
			case(2):
				c2.addTargetDriver(d);
			o2.addTargetDriver(d);

			break;
			default:
				System.out.println("Some vehicles appear in the unknown track.");
			}
			
		}
		Monitors.add(c2);
		Monitors.add(c3);
		Monitors.add(c4);	
		Monitors.add(o2);
		Monitors.add(o3);
		Monitors.add(o4);
	}
	
	public static void update_monitor(Driver d, int index, int old_index)
	{
		switch(old_index)
		{
		case(4):
		{	
			c4.removeTargetDriver(d);
			break;
		}
		case(3):
		{
			c3.removeTargetDriver(d);
			break;
		}
		case(2):
		{
			c2.removeTargetDriver(d);
			break;
		}
		default:
			System.out.println("input the wrong old_lane_index");	
		}
		
		switch(index)
		{
		case(4):
		{
			
			o4.addTargetDriver(d);
			c4.addTargetDriver(d);
			break;
		}
		case(3):
		{
			o3.addTargetDriver(d);
			c3.addTargetDriver(d);
			break;
		}
		case(2):
		{
			o2.addTargetDriver(d);
			c2.addTargetDriver(d);
			break;
		}
		default:
			System.out.println("input the wrong lane_index");
		
		}
	
	}

	
	public void init_lanes()//the outside lane' number is 4
	{
		//create the arraylist for lanes
		lanes = new ArrayList<>();		
		Lane1 lane1 = new Lane1();//will use the arraylist
		lane1.setLaneNumber(4);
		lanes.add(lane1);
		
		Lane2 lane2 = new Lane2();//will use the arraylist  
		lanes.add(lane2);
		lane2.setLaneNumber(3);
		
		Lane3 lane3 = new Lane3();
		lanes.add(lane3);
		lane3.setLaneNumber(2);
		
		Lane4 lane4 = new Lane4();
		lanes.add(lane4);
		lane4.setLaneNumber(1);
		 
	}
	public static Lane getLane(int index)
	{
		switch(index)
		{
		case(1):
			return lanes.get(3);
		case(2):
			return lanes.get(2);
		case(3):
			return lanes.get(1);
		case(4):
			return lanes.get(0);
		default:
			System.out.println("no lane");
		
		}
		return null;
	}
	
	public void begin()
	{
		//boolean driver_has_enough_money = true;
		Picture pic = new Picture(1);
		CHYPayment chypay = new CHYPayment(pic);
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

				NormalDriver NormalDriver = (NormalDriver)d;//downward transition, convert driver class to normalDriver class
				new Thread(NormalDriver).start();		
		    }
			
		     else if(d.getClass().toString().equals("class Driver.IrritableDriver")) 
		    {		    
		    	 
		    	 IrritableDriver IrritableDriver = (IrritableDriver)d;//downward transition, convert driver class to irritableDriver class
		    	 new Thread(IrritableDriver).start();
		    }			
			
		}
		
		for(Monitor cd :Monitors)
		{
			new Thread(cd).start();
		}
	    graphics.run();
		
		
	}
	
	

}
