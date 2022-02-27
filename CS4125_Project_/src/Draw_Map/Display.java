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
	private  ButtonCreate Night_Button_Set;
	private  ButtonCreate Morn_Button_Set;

	
	
	
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
        frame.setSize(1100,641);
        
        
        
        this.Night_Button_Set = new ButtonCreate(frame);
        this.Night_Button_Set.createButton(1000, 0, 60, 30, 1);
        this.Morn_Button_Set = new ButtonCreate(frame);
        this.Morn_Button_Set.createButton(1000, 30, 60, 30, 2);
       
        
        canvas = new Canvas();//it looks like a curtain and inside the frame
        canvas.setSize(1000 , 606 );
        canvas.setBackground(Color.GREEN);
        canvas.setVisible(true);
        frame.add(canvas);
        

     }

	@Override
	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return this.frame;
	}

	@Override
	public ButtonCreate get_ButtonCreate(int code) {
	
		switch(code)
		{
		case(1):
			return this.Night_Button_Set;
		case(2):
			return this.Morn_Button_Set;
		default:
			return new ButtonCreate(new JFrame());

		}
		
	}
	
}