package Simulation_Control;
import Thread.Threadprocess;

import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import Draw_Map.ButtonCreate;
import Draw_Map.Display;
import Draw_Map.Draw_map;
import Draw_Map.IDisplay;
import Driver.Driver;
import Road.Lane;

public class Gra_Controller extends Thread_source{
	private double map_wi, map_he;
	public Draw_map d_map;
	private IDisplay idisplay;
	private ButtonCreate b_c;

	
	public Gra_Controller(double ui_wi, double ui_he, ArrayList<Driver>drivers, ArrayList<Lane> lanes)
	{
		
	this.map_he = ui_he;
	this.map_wi = ui_wi;
	this.initDisplay();

	this.d_map = new Draw_map(idisplay, map_wi, map_he, drivers, lanes);
	this.b_c = this.idisplay.get_ButtonCreate();
	this.b_c.setMap(this.d_map);

	
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
        	t.end();
        }
		
	}
	
	public void initDisplay()
	{
		
		idisplay = new Display(map_wi, map_he );
		idisplay.createDisplay();
		
	}
	

}
