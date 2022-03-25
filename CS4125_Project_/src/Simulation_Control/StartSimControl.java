package Simulation_Control;

import StartVisual.StartFrame;

public class StartSimControl {
	public static void main(String[] args)  {
		Sim_Controller sim = new Sim_Controller();
		//the main function, it will start the whole program.
		while(true)
		{
			System.out.println(StartFrame.getInstance().get_whether_start());
			if(StartFrame.getInstance().get_whether_start() == 1)
			{
				
				sim.begin();
				break;
			}
				
		}
		
		
		 
		//sim.begin();
		
	}
}
