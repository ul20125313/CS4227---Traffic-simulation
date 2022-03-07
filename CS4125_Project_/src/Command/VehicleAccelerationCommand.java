package Command;

import Driver.Driver;

public class VehicleAccelerationCommand implements Command{
	protected Driver driver;
	
	public VehicleAccelerationCommand(Driver driver) {
		this.driver = driver;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		driver.getVehilce().accelerate();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		driver.getVehilce().decelerate();
	}

}

	
