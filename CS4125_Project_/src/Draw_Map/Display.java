package Draw_Map;

import javax.swing.*;

import Command.RemoteControl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class Display implements IDisplay{//this class is used to draw the frame of our interface like a window
	
	private int map_wi, map_he;
	private JFrame frame;
	private Canvas canvas;
	private Dimension screen;
	
	public Display(double map_wi, double map_he)
	{
		
		this.map_wi = (int)map_wi;
		this.map_he = (int)map_he;
		this.screen = new Dimension();
		screen.setSize(map_wi,map_he);// set the height and width of the window
		
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	

	public void createDisplay() {
		
		
        frame = new JFrame("Traffic simulation");// the titile of this window
        frame.setVisible(true);//make it visable
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);// set the default location of our window
        frame.setMinimumSize(new Dimension(this.map_wi, this.map_he));
        frame.setLocation(0, 0);
        frame.setSize(1500,1000);
        ButtonCreate b = new ButtonCreate(frame);
        b.addButton();


        
        canvas = new Canvas();//it looks like a curtain and inside the frame
        canvas.setSize(1000 , 606 );
        canvas.setBackground(Color.GREEN);
        canvas.setVisible(true);
        frame.add(canvas);
        
	    //frame.pack();//get a good size of the frame

     }

	@Override
	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return this.frame;
	}
	
}