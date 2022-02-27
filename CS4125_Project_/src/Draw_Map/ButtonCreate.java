package Draw_Map;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Command.ChangeBackgroundToNight;
import Command.RemoteControl;

public class ButtonCreate {
	private JFrame f;
	private JButton button;
	private Draw_map d_m;
	public ButtonCreate(JFrame f)
	{
		this.f = f;
	}
	public void setMap(Draw_map d_m)
	{
		this.d_m = d_m;
		createButtonListener();
		
	}
	public void createButton()
	{   
		button = new JButton("1");
		button.setBounds(1140, 40, 60, 30);
        Container content = f.getContentPane();
        content.setLayout(null);
        content.add(button);	
        
       
	}
	public void createButtonListener()
	{
		 button.addActionListener(new ActionListener()
 		{
 	           public void actionPerformed(ActionEvent e)
 	           {
 	        	   ChangeBackgroundToNight cn = new ChangeBackgroundToNight(d_m);
 	        	   RemoteControl rc = new RemoteControl(cn);
 	        	   rc.ButtonPressed();
 	           }
 		}
 
 		
 );
	}
	public JButton getButton()
	{
		return this.button;
	}

}
