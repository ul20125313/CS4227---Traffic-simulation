package Iterator;

import java.util.ArrayList;

import Detection.Monitor;

public class MonitorRepository implements Container{
	
	public static ArrayList<Monitor>Monitors;
	
	public void getMonitors(ArrayList<Monitor>Monitors) {
		this.Monitors = Monitors;
	}

	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new MonitorIterator();
	}
	
	private class MonitorIterator implements Iterator {
		
		int index;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(index < Monitors.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(this.hasNext()) {
				return Monitors.get(index++);
			}
			return null;
		}
		
	}

}
