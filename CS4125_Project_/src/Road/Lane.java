package Road;

import java.awt.Color;
import java.awt.Point;

public abstract class Lane {// an abstract class will be extended by 4 lane classes
	private int laneNumber;
	
	public abstract int getX();

	public abstract int getY();

	public abstract int getWi();

	public abstract int getHe();
	
	public abstract int getline_width();

	public abstract int getNumCells();
	
	public abstract Color getLaneColor();
	
	public abstract Point get_Position(int cell_index);
	
	public abstract int get_Radius();
	
	public void setLaneNumber(int n)
	{
		this.laneNumber = n;
		
	}
	public int getLaneNumber()
	{
		return this.laneNumber;
	}

}
