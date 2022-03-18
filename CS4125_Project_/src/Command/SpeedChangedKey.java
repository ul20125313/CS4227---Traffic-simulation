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
	protected VehicleAccelerationCommand[] vehicleAccelerationCommands;
	protected VehicleDecelerationCommand[] vehicleDecelerationCommands;
	
	private int mode = 0; // for changing speedchanged driver object
	

	public SpeedChangedKey(JFrame frame) {
		this.frame = frame;
		this.panel = new JPanel();
		this.frame.getContentPane().add(panel);

	}
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public void getvehicleAccelerationCommands(VehicleAccelerationCommand[] vehicleAccelerationCommands) {
		this.vehicleAccelerationCommands = vehicleAccelerationCommands;
	}
	public void getvehicleDecelerationCommands(VehicleDecelerationCommand[] vehicleDecelerationCommands) {
		this.vehicleDecelerationCommands = vehicleDecelerationCommands;
	}
	
	public void setKeyEvent() {
		
		CommandController commandController = new CommandController();
		commandController.setCommand(0, vehicleAccelerationCommands[0], vehicleDecelerationCommands[0]);
		commandController.setCommand(1, vehicleAccelerationCommands[1], vehicleDecelerationCommands[1]);
		commandController.setCommand(2, vehicleAccelerationCommands[2], vehicleDecelerationCommands[2]);
		commandController.setCommand(3, vehicleAccelerationCommands[3], vehicleDecelerationCommands[3]);
		commandController.setCommand(4, vehicleAccelerationCommands[4], vehicleDecelerationCommands[4]);
		commandController.setCommand(5, vehicleAccelerationCommands[5], vehicleDecelerationCommands[5]);
		commandController.setCommand(6, vehicleAccelerationCommands[6], vehicleDecelerationCommands[6]);
		
		
		Command[] AllAcceleration = new Command[7];
		AllAcceleration[0] = vehicleAccelerationCommands[0];
		AllAcceleration[1] = vehicleAccelerationCommands[1];
		AllAcceleration[2] = vehicleAccelerationCommands[2];
		AllAcceleration[3] = vehicleAccelerationCommands[3];
		AllAcceleration[4] = vehicleAccelerationCommands[4];
		AllAcceleration[5] = vehicleAccelerationCommands[5];
		AllAcceleration[6] = vehicleAccelerationCommands[6];

		
		Command[] AllDeceleration = new Command[7];
		AllDeceleration[0] = vehicleDecelerationCommands[0];
		AllDeceleration[1] = vehicleDecelerationCommands[1];
		AllDeceleration[2] = vehicleDecelerationCommands[2];
		AllDeceleration[3] = vehicleDecelerationCommands[3];
		AllDeceleration[4] = vehicleDecelerationCommands[4];
		AllDeceleration[5] = vehicleDecelerationCommands[5];
		AllDeceleration[6] = vehicleDecelerationCommands[6];
		
//		Command[] AllAcceleration = {vehicleAccelerationCommands[0], vehicleAccelerationCommands[1], vehicleAccelerationCommands[2],
//				vehicleAccelerationCommands[3], vehicleAccelerationCommands[4],
//				vehicleAccelerationCommands[5], vehicleAccelerationCommands[6]};
//		
//		Command[] AllDeceleration = {vehicleDecelerationCommands[0], vehicleDecelerationCommands[1], vehicleDecelerationCommands[2],
//				vehicleDecelerationCommands[3], vehicleDecelerationCommands[4],
//				vehicleDecelerationCommands[5], vehicleDecelerationCommands[6]};
		
//		System.out.println(AllAcceleration.length);
//		System.out.println(AllDeceleration.length);
//		
//		System.out.println(AllAcceleration[0].getClass());
//		System.out.println(AllAcceleration[1].getClass());
//		System.out.println(AllAcceleration[2].getClass());
//		System.out.println(AllAcceleration[3].getClass());
//		System.out.println(AllAcceleration[4].getClass());
//		System.out.println(AllAcceleration[5].getClass());
//		System.out.println(AllAcceleration[6].getClass());
//		
//		System.out.println(AllDeceleration[0].getClass());
//		System.out.println(AllDeceleration[1].getClass());
//		System.out.println(AllDeceleration[2].getClass());
//		System.out.println(AllDeceleration[3].getClass());
//		System.out.println(AllDeceleration[4].getClass());
//		System.out.println(AllDeceleration[5].getClass());
//		System.out.println(AllDeceleration[6].getClass());
//		System.out.println(AllDeceleration.getClass().getName());
		
		MacroCommand AllAccelerationMacro = new MacroCommand(AllAcceleration);
		MacroCommand AllDecelerationMacro = new MacroCommand(AllDeceleration);
		
		commandController.setCommand(7, AllAccelerationMacro, AllDecelerationMacro);
		
		
		this.panel.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				
//				System.out.print(e.getKeyCode());
			   
				
				if(e.getKeyCode() == 49) { // key '1' for J.J.
					
					mode = 1;
					System.out.println("[J.J.] SpeedChanged Mode is ready!");
					
				}
				if(e.getKeyCode() == 50) { // key '2' for Sam
					
					mode = 2;
					System.out.println("[Sam] SpeedChanged Mode is ready!");
					
				}
				if(e.getKeyCode() == 51) { // key '3' for Tom
					
					mode = 3;
					System.out.println("[Tom] SpeedChanged Mode is ready!");
					
				}
				if(e.getKeyCode() == 52) { // key '4' for Jack
					
					mode = 4;
					System.out.println("[Jack] SpeedChanged Mode is ready!");
					
				}
				if(e.getKeyCode() == 53) { // key '5' for Jim
					
					mode = 5;
					System.out.println("[Jim] SpeedChanged Mode is ready!");
					
				}
				if(e.getKeyCode() == 54) { // key '6' for Nik
					
					mode = 6;
					System.out.println("[Nik] SpeedChanged Mode is ready!");
					
				}
				if(e.getKeyCode() == 55) { // key '7' for Dan
					
					mode = 7;
					System.out.println("[Dan] SpeedChanged Mode is ready!");
					
				}
				
//				------ Acceleration and deceleration operation ------
				
				if(e.getKeyCode() == 61) { // key '+' '=' 
					
					if(mode == 1)
						commandController.accelerationKeyPressed(0);
					if(mode == 2)
						commandController.accelerationKeyPressed(1);
					if(mode == 3)
						commandController.accelerationKeyPressed(2);
					if(mode == 4)
						commandController.accelerationKeyPressed(3);
					if(mode == 5)
						commandController.accelerationKeyPressed(4);
					if(mode == 6)
						commandController.accelerationKeyPressed(5);
					if(mode == 7)
						commandController.accelerationKeyPressed(6);
					
					//vehicleAccelerationCommand.execute();
					//driver.getVehilce().accelerate();
				}
				
				if(e.getKeyCode() == 45) { // key '-' '_'
					
					if(mode == 1)
						commandController.decelerationKeyPressed(0);
					if(mode == 2)
						commandController.decelerationKeyPressed(1);
					if(mode == 3)
						commandController.decelerationKeyPressed(2);
					if(mode == 4)
						commandController.decelerationKeyPressed(3);
					if(mode == 5)
						commandController.decelerationKeyPressed(4);
					if(mode == 6)
						commandController.decelerationKeyPressed(5);
					if(mode == 7)
						commandController.decelerationKeyPressed(6);
					
					//vehicleDecelerationCommand.execute();
					//driver.getVehilce().decelerate();
				}
				
				if(e.getKeyCode() == 8) { // backspace key
					commandController.undoKeyPressed();
				}
				
				if(e.getKeyCode() == 93) { // key ']' '}'
					commandController.accelerationKeyPressed(7);
				}
				
				if(e.getKeyCode() == 91) { // key '[' '{'
					commandController.decelerationKeyPressed(7);
				}
					
				
				
//				if(e.getKeyCode() == 49) { // key '1' for J.J
//					
//					mode = 1;
//					System.out.println("[J.J] SpeedChanged Mode is ready!");
//					
//					if(e.getKeyCode() == 61) { // key '+' '=' 
//						
//						commandController.accelerationKeyPressed(0);
//						
//						//vehicleAccelerationCommand.execute();
//						//driver.getVehilce().accelerate();
//					}
//					if(e.getKeyCode() == 45) { // key '-' '_'
//						
//						commandController.decelerationKeyPressed(0);
//						
//						//vehicleDecelerationCommand.execute();
//						//driver.getVehilce().decelerate();
//					}
//					if(e.getKeyCode() == 8) { // backspace key
//						commandController.undoKeyPressed();
//					}
//					
//					if(e.getKeyCode() == 93) { // key ']' '}'
//						commandController.accelerationKeyPressed(7);
//					}
//					
//					if(e.getKeyCode() == 91) { // key '[' '{'
//						commandController.decelerationKeyPressed(7);
//					}	
//				}
//				if(e.getKeyCode() == 50) { // key '2' for Sam
//					
//					System.out.println("[Sam] SpeedChanged Mode is ready!");
//					
//					if(e.getKeyCode() == 61) { // key '+' '=' 
//						
//						commandController.accelerationKeyPressed(1);
//						
//					}
//					if(e.getKeyCode() == 45) { // key '-' '_'
//						
//						commandController.decelerationKeyPressed(1);
//						
//					}
//					if(e.getKeyCode() == 8) { // backspace key
//						
//						commandController.undoKeyPressed();
//						
//					}
//					
//					if(e.getKeyCode() == 93) { // key ']' '}'
//						
//						commandController.accelerationKeyPressed(7);
//						
//					}
//					
//					if(e.getKeyCode() == 91) { // key '[' '{'
//						
//						commandController.decelerationKeyPressed(7);
//						
//					}	
//				}
//				if(e.getKeyCode() == 51) { // key '3' for Tom
//					
//					System.out.println("[Tom] SpeedChanged Mode is ready!");
//					
//					if(e.getKeyCode() == 61) { // key '+' '=' 
//						
//						commandController.accelerationKeyPressed(2);
//						
//					}
//					if(e.getKeyCode() == 45) { // key '-' '_'
//						
//						commandController.decelerationKeyPressed(2);
//						
//					}
//					if(e.getKeyCode() == 8) { // backspace key
//						
//						commandController.undoKeyPressed();
//						
//					}
//					
//					if(e.getKeyCode() == 93) { // key ']' '}'
//						
//						commandController.accelerationKeyPressed(7);
//						
//					}
//					
//					if(e.getKeyCode() == 91) { // key '[' '{'
//						
//						commandController.decelerationKeyPressed(7);
//						
//					}	
//				}
//				if(e.getKeyCode() == 52) { // key '4' for Jack
//					
//					System.out.println("[Jack] SpeedChanged Mode is ready!");
//					
//					if(e.getKeyCode() == 61) { // key '+' '=' 
//						
//						commandController.accelerationKeyPressed(3);
//						
//					}
//					if(e.getKeyCode() == 45) { // key '-' '_'
//						
//						commandController.decelerationKeyPressed(3);
//						
//					}
//					if(e.getKeyCode() == 8) { // backspace key
//						
//						commandController.undoKeyPressed();
//						
//					}
//					
//					if(e.getKeyCode() == 93) { // key ']' '}'
//						
//						commandController.accelerationKeyPressed(7);
//						
//					}
//					
//					if(e.getKeyCode() == 91) { // key '[' '{'
//						
//						commandController.decelerationKeyPressed(7);
//						
//					}	
//				}
//				if(e.getKeyCode() == 53) { // key '5' for Jim
//					
//					System.out.println("[Jim] SpeedChanged Mode is ready!");
//					
//					if(e.getKeyCode() == 61) { // key '+' '=' 
//						
//						commandController.accelerationKeyPressed(4);
//						
//					}
//					if(e.getKeyCode() == 45) { // key '-' '_'
//						
//						commandController.decelerationKeyPressed(4);
//						
//					}
//					if(e.getKeyCode() == 8) { // backspace key
//						
//						commandController.undoKeyPressed();
//						
//					}
//					
//					if(e.getKeyCode() == 93) { // key ']' '}'
//						
//						commandController.accelerationKeyPressed(7);
//						
//					}
//					
//					if(e.getKeyCode() == 91) { // key '[' '{'
//						
//						commandController.decelerationKeyPressed(7);
//						
//					}	
//				}
//				if(e.getKeyCode() == 54) { // key '6' for Nik
//					
//					System.out.println("[Nik] SpeedChanged Mode is ready!");
//					
//					if(e.getKeyCode() == 61) { // key '+' '=' 
//						
//						commandController.accelerationKeyPressed(5);
//						
//					}
//					if(e.getKeyCode() == 45) { // key '-' '_'
//						
//						commandController.decelerationKeyPressed(5);
//						
//					}
//					if(e.getKeyCode() == 8) { // backspace key
//						
//						commandController.undoKeyPressed();
//						
//					}
//					
//					if(e.getKeyCode() == 93) { // key ']' '}'
//						
//						commandController.accelerationKeyPressed(7);
//						
//					}
//					
//					if(e.getKeyCode() == 91) { // key '[' '{'
//						
//						commandController.decelerationKeyPressed(7);
//						
//					}	
//				}
//				if(e.getKeyCode() == 55) { // key '7' for Dan
//					
//					System.out.println("[Dan] SpeedChanged Mode is ready!");
//					
//					if(e.getKeyCode() == 61) { // key '+' '=' 
//						
//						commandController.accelerationKeyPressed(6);
//						
//					}
//					if(e.getKeyCode() == 45) { // key '-' '_'
//						
//						commandController.decelerationKeyPressed(6);
//						
//					}
//					if(e.getKeyCode() == 8) { // backspace key
//						
//						commandController.undoKeyPressed();
//						
//					}
//					
//					if(e.getKeyCode() == 93) { // key ']' '}'
//						
//						commandController.accelerationKeyPressed(7);
//						
//					}
//					
//					if(e.getKeyCode() == 91) { // key '[' '{'
//						
//						commandController.decelerationKeyPressed(7);
//						
//					}	
//				}
							
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
