package Builder;

import java.util.ArrayList;

public class Car {
	private ArrayList<Exterior>exs;
	private ArrayList<Interior>ins;
	public Car()
	{
		exs = new ArrayList<>();
		ins = new ArrayList<>();
	}
	public void add_Exterior(Exterior ex)
	{
		exs.add(ex);
		
	}
	public void add_Interior(Interior in)
	{
		ins.add(in);
	}
	

}

