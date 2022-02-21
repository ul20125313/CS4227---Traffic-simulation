package Vehicle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
	
	private Vehicle v1 = new Vehicle(330, 20);
	private Vehicle v2 = new Vehicle(350, 20);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		v1.Sum_angle();
		v2.Sum_angle();
		assertEquals(350, v1.Get_sum_angle(), 1);
		assertEquals(10, v2.Get_sum_angle(), 1);
		//fail("Not yet implemented");
	}

}
