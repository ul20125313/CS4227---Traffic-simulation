package Command;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import Driver.Driver;

public class SpeedChangedKey {
	private JFrame frame;
	private JPanel panel;
	
	private Driver driver;
	protected VehicleAccelerationCommand vehicleAccelerationCommand;
	protected VehicleDecelerationCommand vehicleDecelerationCommand;
	

	public SpeedChangedKey(JFrame frame) {
		this.frame = frame;
		this.panel = new JPanel();
		this.frame.getContentPane().add(panel);

	}
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public void getvehicleAccelerationCommand(VehicleAccelerationCommand vehicleAccelerationCommand) {
		this.vehicleAccelerationCommand = vehicleAccelerationCommand;
	}
	public void getvehicleDecelerationCommand(VehicleDecelerationCommand vehicleDecelerationCommand) {
		this.vehicleDecelerationCommand = vehicleDecelerationCommand;
	}
	
	public void setKeyEvent() {
		
		CommandController commandController = new CommandController();
		commandController.setCommand(0, vehicleAccelerationCommand, vehicleDecelerationCommand);
//		System.out.println(remoteControl);
		
		Command[] TwiceAcceleration = {vehicleAccelerationCommand, vehicleAccelerationCommand};
		Command[] TwiceDeceleration = {vehicleDecelerationCommand, vehicleDecelerationCommand};
		
		MacroCommand TwiceAccelerationMacro = new MacroCommand(TwiceAcceleration);
		MacroCommand TwiceDecelerationMacro = new MacroCommand(TwiceDeceleration);
		
		commandController.setCommand(1, TwiceAccelerationMacro, TwiceDecelerationMacro);
		
		
		this.panel.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				
//				System.out.print(e.getKeyCode());
				if(e.getKeyCode() == 61) { // key '+' '=' 
					
					commandController.accelerationKeyPressed(0);
					
					//vehicleAccelerationCommand.execute();
					//driver.getVehilce().accelerate();
				}
				if(e.getKeyCode() == 45) { // key '-' '_'
					
					commandController.decelerationKeyPressed(0);
					
					//vehicleDecelerationCommand.execute();
					//driver.getVehilce().decelerate();
				}
				if(e.getKeyCode() == 8) { // backspace key
					
					commandController.undoKeyPressed();
				}
				
				if(e.getKeyCode() == 93) { // key ']' '}'
					commandController.accelerationKeyPressed(1);
				}
				if(e.getKeyCode() == 91) { // key '[' '{'
					commandController.decelerationKeyPressed(1);
				}		
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		panel.setFocusable(true);
	    panel.requestFocusInWindow();
	}
	
	
//	public void setJframe(JFrame frame) {
//		this.frame = frame;
//	}

}
