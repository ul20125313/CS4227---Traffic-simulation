package Simulation_Control;
import Thread.Threadprocess;

import java.util.ArrayList;

import Draw_Map.Display;
import Draw_Map.Draw_map;
import Draw_Map.IDisplay;
import Driver.Driver;
import Road.Lane;

public class Gra_Controller extends Thread_source{
	private double map_wi, map_he;
	public Draw_map d_map;
	private IDisplay idisplay;
	
	
	
	public Gra_Controller(double ui_wi, double ui_he, ArrayList<Driver>drivers, ArrayList<Lane> lanes)
	{
	this.map_he = ui_he;
	this.map_wi = ui_wi;
	this.initDisplay();
	this.d_map = new Draw_map(idisplay, map_wi, map_he, drivers, lanes);
//	System.out.println("Gra_Control map_width "+map_wi+" Map_height "+map_he);
	
	}
	
	@Override
	public void run()//use the run function in Control_thread
	{
		Threadprocess t = new Threadprocess(Threadprocess.DEFAULT_FRAMERATE);
    	t.setMessage("Map");
		
		boolean success = true;
    	while(success) {
        	t.start();
        	this.d_map.render();
        	//System.out.print("run ");
        	t.end();
        }
		
	}
	
	public void initDisplay()
	{
		
		idisplay = new Display(map_wi, map_he );
		idisplay.createDisplay();
		
	}
	

}
