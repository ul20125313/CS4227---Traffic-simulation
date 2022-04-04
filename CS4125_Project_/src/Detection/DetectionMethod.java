package Detection;

import java.util.ArrayList;

import Driver.Driver;

public interface DetectionMethod {
	public void detectCollision(ArrayList<Driver>target_drivers, CollisionMonitor c); 
	public void detectOvertake(ArrayList<Driver> target_drivers, OvertakeMonitor c);

}
