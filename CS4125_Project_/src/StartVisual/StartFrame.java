package StartVisual;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Driver.Driver;
import Simulation_Control.Sim_Controller;

public class StartFrame extends JFrame {
	private static StartFrame sf;
	private int whether_start;
	private ArrayList<Driver>drivers;
 	private JPanel jp;
 	private int selectedIndex;
	public static StartFrame getInstance()
	{
		if(sf == null)
			sf = new StartFrame();
		return sf;
	}
	
	public StartFrame()
	{
		super("StartWindow");
		this.whether_start = 0;
		
		
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	    this.setSize(400, 400);
        jp = new JPanel();
        jp.setLayout(null);
        
		JButton start = new JButton("start");
		start.setBounds(160, 10, 70, 30);
		
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				whether_start = 1;
				
				
			}
		});
		jp.add(start);

//       JPanel panel = new JPanel();


	}
	public void setDrivers(ArrayList<Driver>drivers)
	{
		this.drivers =drivers;
	}
	
	public int get_whether_start()
	{
		return this.whether_start;
	}
	
	public void createComboBox()
	{
		 JComboBox<String> cmb=new JComboBox<String>();  
		    
		 cmb.addItem("--choose--");   
		 for(Driver d :this.drivers)
		 {
		    cmb.addItem(d.getName());
		 }
		 cmb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					selectedIndex = cmb.getSelectedIndex();
				}
				System.out.println(selectedIndex);
				
			}
		 });
		 cmb.setBounds(150, 100, 100, 30); 
		 jp.add(cmb);
		
	}
	public void createtextandButton()
	{
		JTextField text = new JTextField();
		text.setBounds(150, 140, 100, 30);
		jp.add(text);
		JButton b2 = new JButton("Charge");
		b2.setBounds(270,140, 80, 30);
		jp.add(b2);
		b2.addActionListener(new ActionListener()
				{
						  
					@Override
					public void actionPerformed(ActionEvent e) {
						int num = 0;
						try {

						    num = Integer.parseInt(text.getText());

						} catch (NumberFormatException exception) {

						    exception.printStackTrace();

						}
						drivers.get(selectedIndex-1).balanceIncrease(num);
						
					}
			
				});
	}
	
	public void createtextandButton_2()
	{
		JTextField text_2 = new JTextField();
		text_2.setBounds(150, 180, 100, 30);
		jp.add(text_2);
		JButton b3 = new JButton("search");
		b3.setBounds(270,180, 80, 30);
		jp.add(b3);
		b3.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						text_2.setText(String.valueOf(drivers.get(selectedIndex-1).getBalance()));
						// TODO Auto-generated method stub
						
					}

				});
		
	}

	public void completeFrame()
	{
		 this.setContentPane(jp);
		 this.setVisible(true);
	}
	



	

}
