package Detection;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import Driver.Driver;
import Driver.DriverFactory;
import Vehicle.Vehicle;


public class DetectionMethod_v2_test {
	DetectionMethod_v2 v2_test = new DetectionMethod_v2();
	DriverFactory d_f = new DriverFactory();
	Point p1 = new Point((500), (25));	
	Point p2 = new Point((470),(30));
	Vehicle v1 = new Vehicle(p1);
	Vehicle v2 = new Vehicle(p2);
	Driver d1  = d_f.createDriver(DriverFactory.DriverTemper.NORMAL, v1, "Tom", "Normal", 8);
	Driver d2  = d_f.createDriver(DriverFactory.DriverTemper.NORMAL, v2, "Sam", "Normal", 8);


	@Test
	public void test() {
		
		boolean Wether_Overtake = v2_test.Wether_Overtake(d1, d2);
		boolean Wether_Collision = v2_test.Wether_Collision(d1, d2);
		assertEquals(Wether_Collision, false);
		
		//fail("Not yet implemented");
	}

}
