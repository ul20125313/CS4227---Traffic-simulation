package Command;

import Driver.Driver;

public class VehicleDecelerationCommand implements Command{
	protected Driver driver;
	
	public VehicleDecelerationCommand(Driver driver) {
		this.driver = driver;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		driver.getVehilce().decelerate();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		driver.getVehilce().accelerate();
	}

}
