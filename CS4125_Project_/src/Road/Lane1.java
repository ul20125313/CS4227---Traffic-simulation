package Road;
import java.awt.*;
import java.util.HashMap;

public class Lane1 extends Lane{
	private Point center;
	private int wi;
	private int he;
	private int lane_width;
	private Color lane_Color;
	private int number_of_cells;
	private int radius;
	
	
	public Lane1()//constructor function and the variables below are all the private information about lane 1
	{
	
		this.center = new Point();
		center.x = 500;
		center.y = 25;
		this.wi = 556;
		this.he = 556;
		this.lane_width = 25;
		this.number_of_cells = 1000;
		this.lane_Color =  new Color(71, 73, 76);
		this.radius = this.wi/2;//this.wi/2;
		
		

	}
	
	//return the information about lane 1.
	public int getX() {
		return this.center.x / 2;
	}

	public int getY() {
		return this.center.y / 2;
	}

	public int getWi() {
		return this.wi;
	}

	public int getHe() {
		return this.he;
	}
	
	public int getline_width()
	{
		return this.lane_width;
	}

	public int getNumCells() {
		return this.number_of_cells;
	}
	
	public Color getLaneColor() {
		return lane_Color;
	}
	
	public Point get_Position(int cell_index)// need to be modified
	{
		Point p = new Point();
		return p;
	
	}
	@Override
	public int get_Radius() {
		// TODO Auto-generated method stub
		return radius;
	}

}
