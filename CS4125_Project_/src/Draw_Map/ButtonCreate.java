package Draw_Map;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Command.ButtonRemoteControl;
import Command.ChangeBackgroundToAutumn;
import Command.ChangeBackgroundToMorning;
import Command.ChangeBackgroundToNight;
import Command.ChangeBackgroundToWinter;
import Command.RemoteControl;
import Driver.Driver;

public class ButtonCreate {
	private JFrame f;
	private JButton button;
	private Draw_map d_m;
	private static final int Night = 1;
	private static final int morning = 2;
	private static final int Autumn = 3;
	private static final int Winter = 4;
	private static final int Default = 5;
	private static final int Safe = 6;
	private static final int Racer = 7;
	
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
        	break;
        	case(morning):
        		this.createMorningButtonListener();
        	break;
        	case(Autumn):
        		this.createAutumnButtonListener();
        	break;
        	case(Winter):
        		this.createWinterButtonListener();
        	break;
        	case(Default):
        		this.createDefaultButtonListener();
        	break;
        	case(Safe):
        		this.createSafeButtonListener();
        	break;
        	case(Racer):
        		this.createRacerButtonListener();
        	break;
        		
        	default:
        		System.out.print("add new button listener");
        
        }
        	
       
	}
	public void createDefaultButtonListener()
	{
		 button.addActionListener(new ActionListener()
	 		{
	 	           public void actionPerformed(ActionEvent e)
	 	           {
	 	        	  Driver.setCode_1();
	 	           }
	 		});
		
	}
	
	public void createSafeButtonListener()
	{
		 button.addActionListener(new ActionListener()
	 		{
	 	           public void actionPerformed(ActionEvent e)
	 	           {
	 	        	  Driver.setCode_2();
	 	           }
	 		});
		
	}
	public void createRacerButtonListener()
	{
		 button.addActionListener(new ActionListener()
	 		{
	 	           public void actionPerformed(ActionEvent e)
	 	           {
	 	        	  Driver.setCode_3();
	 	           }
	 		});
		
	}
	
	public void createNightButtonListener()
	{
		 button.addActionListener(new ActionListener()
 		{
 	           public void actionPerformed(ActionEvent e)
 	           {
 	        	   ChangeBackgroundToNight cn = new ChangeBackgroundToNight(d_m);
 	        	   RemoteControl brc = new ButtonRemoteControl(cn);
 	        	   brc.UseRemote();
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
 	        	   RemoteControl brc = new ButtonRemoteControl(cn);
 	        	   brc.UseRemote();
 	           }
 		});
	}
	
	public void createAutumnButtonListener()
	{
		 button.addActionListener(new ActionListener()
 		{
 	           public void actionPerformed(ActionEvent e)
 	           {
 	        	   ChangeBackgroundToAutumn cn = new ChangeBackgroundToAutumn(d_m);
 	        	   RemoteControl brc = new ButtonRemoteControl(cn);
 	        	   brc.UseRemote();
 	           }
 		});
	}
	
	public void createWinterButtonListener()
	{
		 button.addActionListener(new ActionListener()
 		{
 	           public void actionPerformed(ActionEvent e)
 	           {
 	        	   ChangeBackgroundToWinter cn = new ChangeBackgroundToWinter(d_m);
 	        	   RemoteControl brc = new ButtonRemoteControl(cn);
 	        	   brc.UseRemote();
 	           }
 		});
	}
	
	public JButton getButton()
	{
		
		return this.button;
	}

}
