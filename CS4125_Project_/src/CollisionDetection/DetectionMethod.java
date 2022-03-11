package CollisionDetection;

import java.util.ArrayList;

import Driver.Driver;

public interface DetectionMethod {
	public void detectCollision(ArrayList<Driver>target_drivers, CollisionMonitor c); 
	public void detect_whether_Overtake(ArrayList<Driver> target_drivers, OvertakeMonitor c);

}
