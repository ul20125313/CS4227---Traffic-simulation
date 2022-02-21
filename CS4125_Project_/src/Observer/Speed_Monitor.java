package Observer;
import java.util.ArrayList;

//this is the subject concrete class
public class Speed_Monitor implements Subject{
	
	ArrayList<Double>speeds_in_all_tracks;
	ArrayList<String>drivernames_in_all_tracks;
	ArrayList<String>carNames_in_all_tracks;
	ArrayList<String>driverTempers_in_all_tracks;

	
	private ArrayList<Observer>observers;
	public Speed_Monitor() // this is the constructor of speed 
	{
		this.observers = new ArrayList();

	}

	@Override
	public void registerOb(Observer o) {// this function is used to create new observer instance
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removerOb(Observer o) {// this function is used to remove the observer instance
		// TODO Auto-generated method stub
		int index = observers.indexOf(o);// get the index of corresponding instance
		if(index >= 0)
			observers.remove(index);
	}

	@Override
	public void notifyOb() {// send the data to all of the observers
		// TODO Auto-generated method stub
		for(int i = 0; i < this.observers.size(); i++)
		{
			Observer o = (Observer)this.observers.get(i);
			o.update(this.speeds_in_all_tracks, this.drivernames_in_all_tracks, this.carNames_in_all_tracks, this.driverTempers_in_all_tracks);
			// call the update function in the corresponding observer class.
		}
		
	}
	

	public void set_info(ArrayList<String>drivernames, ArrayList<Double>speeds, ArrayList<String>carNames, ArrayList<String>driverTempers)
	{
		//when this function is called, it means the data in this subject is updated.
		this.speeds_in_all_tracks = speeds;
		this.drivernames_in_all_tracks  = drivernames;
		this.carNames_in_all_tracks = carNames;
		this.driverTempers_in_all_tracks = driverTempers;
		this.infoChanged();		
	}

	private void infoChanged() // if data is changed, notify function will be called 
	{
		notifyOb();
	
	}

}
