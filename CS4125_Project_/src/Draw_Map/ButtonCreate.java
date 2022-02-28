package Draw_Map;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Command.ChangeBackgroundToMorning;
import Command.ChangeBackgroundToNight;
import Command.RemoteControl;

public class ButtonCreate {
	private JFrame f;
	private JButton button;
	private Draw_map d_m;
	private static final int Night = 1;
	private static final int morning = 2;
	
	public ButtonCreate(JFrame f)
	{
		this.f = f;
	}
	public void setMap(Draw_map d_m)
	{
		this.d_m = d_m;
		
		
	}
	public void createButton(int left, int top, int width, int height, int Command_code)
	{   
		button = new JButton(String.valueOf(Command_code));
		button.setBounds(left, top, width, height);
        Container content = f.getContentPane();
        content.setLayout(null);
        content.add(button);	
        switch(Command_code)
        {
        	case(Night):
        		this.createNightButtonListener();
        	case(morning):
        		this.createMorningButtonListener();
        	default:
        		System.out.print("add new button listener");
        
        }
        	
       
	}
	public void createNightButtonListener()
	{
		 button.addActionListener(new ActionListener()
 		{
 	           public void actionPerformed(ActionEvent e)
 	           {
 	        	   ChangeBackgroundToNight cn = new ChangeBackgroundToNight(d_m);
 	        	   RemoteControl rc = new RemoteControl(cn);
 	        	   rc.ButtonPressed();
 	           }
 		});
	}
	
	public void createMorningButtonListener()
	{
		 button.addActionListener(new ActionListener()
 		{
 	           public void actionPerformed(ActionEvent e)
 	           {
 	        	   ChangeBackgroundToMorning cn = new ChangeBackgroundToMorning(d_m);
 	        	   RemoteControl rc = new RemoteControl(cn);
 	        	   rc.ButtonPressed();
 	           }
 		});
	}
	public JButton getButton()
	{
		
		return this.button;
	}

}