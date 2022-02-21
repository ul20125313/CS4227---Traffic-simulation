package Road;

import java.awt.Color;
import java.awt.Point;

public class Lane3 extends Lane{
	private Point center;
	private int wi;
	private int he;
	private int lane_width;
	private Color lane_Color;
	private double angle_per_cell;// every single space has a specified angle
	private int number_of_cells;
	private int radius;
	
	public Lane3()//constructor function and the variables below are all the private information about lane 1
	{
		this.center = new Point();
		center.x = 600;
		center.y = 125;
		this.wi = 456;
		this.he = 456;
		this.lane_width = 26;
		this.number_of_cells = 1000;
		this.angle_per_cell = 360/this.number_of_cells;
		this.lane_Color =  new Color(85, 50, 23);
		this.radius = this.wi/2;
		

	}
	
	//return the information about lane 3.
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.center.x / 2;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.center.y / 2;
	}

	@Override
	public int getWi() {
		// TODO Auto-generated method stub
		return this.wi;
	}

	@Override
	public int getHe() {
		// TODO Auto-generated method stub
		return this.he;
	}

	@Override
	public int getline_width() {
		// TODO Auto-generated method stub
		return this.lane_width;
	}

	@Override
	public int getNumCells() {
		// TODO Auto-generated method stub
		return this.number_of_cells;
	}

	@Override
	public Color getLaneColor() {
		// TODO Auto-generated method stub
		return lane_Color;
	}

	@Override
	public Point get_Position(int cell_index) {
		// TODO Auto-generated method stub
		Point p = new Point();
		return p;
	}

	@Override
	public int get_Radius() {
		// TODO Auto-generated method stub
		return radius;
	}

}
