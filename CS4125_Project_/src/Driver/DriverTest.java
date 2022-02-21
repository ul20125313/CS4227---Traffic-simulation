package Driver;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Vehicle.Vehicle;

public class DriverTest {//This class can be used to test the function in the driver class
	
	private IrritableDriver IrritableDr = new IrritableDriver("Tom", new Vehicle(), "Irritable");
	private NormalDriver NormalDr = new NormalDriver("J.J", new Vehicle(), "Normal");
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testgetDriverTemperType() {
		
		assertEquals("Irritable", IrritableDr.getDriverTemperType());
		assertEquals("Normal", NormalDr.getDriverTemperType());
		
		//fail("Not yet implemented");
	}

	@Test
	public void testgetLimitedSpeed() {
		assertEquals(4.0 * 30, IrritableDr.getMaxLimitedSpeed(), 1);
		assertEquals(2.0 * 30, IrritableDr.getMinLimitedSpeed(), 1);
		assertEquals(2.0 * 30, NormalDr.getMaxLimitedSpeed(), 1);
		assertEquals(1.0 * 30, NormalDr.getMinLimitedSpeed(), 1);
	}


}


