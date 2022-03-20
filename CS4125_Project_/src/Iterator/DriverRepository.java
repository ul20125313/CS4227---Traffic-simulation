package Iterator;

import java.util.ArrayList;

import Driver.Driver;

public class DriverRepository implements Container{
	
	public ArrayList<Driver>drivers;
	
	public void getDrivers(ArrayList<Driver>drivers) {
		this.drivers = drivers;
	}

	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new DriverIterator();
	}
	
	private class DriverIterator implements Iterator {
		
		int index;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(index < drivers.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(this.hasNext()) {
				return drivers.get(index++);
			}
			return null;
		}
		
	}

}
