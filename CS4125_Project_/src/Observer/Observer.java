package Observer;
import java.util.ArrayList;

//this is the interface for observer pattern
public interface Observer {
	
	public void update(ArrayList<Double>speeds, ArrayList<String>drivernames, ArrayList<String>carNames, ArrayList<String>driverTempers);
}


