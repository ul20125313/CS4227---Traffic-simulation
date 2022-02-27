package Draw_Map;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import Driver.Driver;
import Driver.IrritableDriver;
import Driver.NormalDriver;
import Observer.Speed_Monitor;
import Observer.Track1_Ob;
import Observer.Track2_Ob;
import Observer.Track3_Ob;
import Observer.Track4_Ob;
import Road.Lane;
import Vehicle.Vehicle;





public class Draw_map implements I_Draw_map{
	private int Map_size_x;
	private int Map_size_y;
	private IDisplay display;
	private Graphics2D graphics;
	private BufferStrategy buffer;
	private BufferedImage background;
	private String BACKGROUND_PATH;
	private Point center;
	private ArrayList<Driver>drivers;

	private ArrayList<Lane>lanes;
	private Speed_Monitor m ;
	private Track1_Ob t1; 
	private Track2_Ob t2; 
	private Track3_Ob t3; 
	private Track4_Ob t4; 
	
	
	
	public Draw_map(IDisplay idis, double map_wi, double map_he, ArrayList<Driver>drivers, ArrayList<Lane> lanes)
	{
		
		this.Map_size_x = (int)map_wi;
		this.Map_size_y = (int)map_he;   			    
	    this.center = new Point((Map_size_x), (Map_size_y));
        this.lanes = lanes;   
	    this.drivers = drivers;		    
		this.display = idis;	
		setmorningbackground();
		this.set_map();
		print_important_info();
		Observer_init();
	
	}

	public void a()
	{
		System.out.println(this.BACKGROUND_PATH);
	}
	private void print_important_info()
	{
		System.out.println("Map size: " + Map_size_x + " " + Map_size_y);

	}
	
	private void Observer_init()
	{
		this.m = new Speed_Monitor();
		this.t1 = new Track1_Ob(m);
		this.t2 = new Track2_Ob(m);
		this.t3 = new Track3_Ob(m);
		this.t4 = new Track4_Ob(m);
		
	}
	
	public void set_map() //create the graphics of map
	{
		
		this.display.getCanvas().createBufferStrategy(1);	
		this.buffer = display.getCanvas().getBufferStrategy();		
        this.graphics = (Graphics2D) buffer.getDrawGraphics();      
        this.graphics.clearRect(0, 0, 700, 700);
    
	}
	

	//this function can draw the vehicles on the window.
	private void drawVehicle(Vehicle vehicle)
	{
		
		Point pos = vehicle.getPosition();
        Point p2 = new Point((int)(pos.x - (vehicle.getVehicleWidth() / 2)), (int)(pos.y - (vehicle.getVehicleLength() / 2)));

        AffineTransform at = new AffineTransform();
        at.rotate(vehicle.getAngle(), p2.x + (vehicle.getVehicleWidth() / 2), p2.y +( vehicle.getVehicleLength() / 2));
        at.translate(p2.x + (vehicle.getVehicleWidth() / 8), p2.y + (vehicle.getVehicleWidth() / 4));

        this.graphics.drawImage(vehicle.getCarImage(), at, null);
	}
	
	private void drawTitle()// the title drawing will be implemented in this function
	{
		this.graphics.setColor(Color.RED);
		this.graphics.setFont(new Font("Calibri", Font.BOLD, 13));
		this.graphics.drawString("-------" + "Driver" + "-------" + "CarName" + "-----" + "Speed", 0, 490);
		
	}
	
	// this function can draw the infomation of all cars 
	private void draw_updateinfo_in_all_tracks(double speed, String drivername, String carName, String driverTemperType, int height)
	{

		String speed_str = "" + speed;
		//System.out.println(speed_str);
		this.graphics.setColor(Color.RED);
		this.graphics.setFont(new Font("Calibri", Font.BOLD, 13));
		this.graphics.drawString(newDriverName(drivername) + "   " + driverTemperType + "      " + newCarName(carName) + "        " + speed_str + "  " + " km/h", 0, height);
	 
	}
	
	//method newDriverName() and newCarName() for looking better when showing the info on GUI
	private String newDriverName(String drivername) {
		if(drivername.equals("J.J"))
			return drivername + "    ";
		else if(drivername.equals("Sam"))
			return drivername + " ";
		else if(drivername.equals("Tom"))
			return drivername + " ";
		else
			return drivername + " ";
			
	}
	private String newCarName(String carName) {
		if(carName.equals("Ferrari"))
			return carName + "";
		else if(carName.equals("Benz"))
			return carName + "   ";
		else if(carName.equals("Mazda"))
			return carName + "  ";
		else
			return carName + "";
			
	}
	
	// this function will draw all of lanes on the window
	private void drawLane(Lane lane)
	{
		this.graphics.setColor(lane.getLaneColor());
		this.graphics.setStroke(new BasicStroke(lane.getline_width()));
		this.graphics.draw(new Ellipse2D.Double(lane.getX(), lane.getY(), lane.getWi(), lane.getHe()));
		
	}
	
	public void setnightbackground()
	{
		this.BACKGROUND_PATH = "nightbackground.png";
		this.background =  create_background();
		
	}
	public void setmorningbackground()
	{
		this.BACKGROUND_PATH = "background.png";
		this.background =  create_background();
		
	}
	
	private void drawbackground() {
		this.graphics.drawImage(this.background, 0,0,null);
	}
	
	
	public void render() 
	{
		

		//System.out.println(this.BACKGROUND_PATH);
		this.drawbackground();
		for (Lane l : this.lanes) 
		{
            this.drawLane(l);
        }
		for (Driver driver : this.drivers)
		{
			
			this.drawVehicle(driver.getVehilce());

		}	
		
		this.drawTitle();
		Observe_Distribute(drivers);
		
		this.buffer.show();
    }
	
	
	private void Observe_Distribute(ArrayList<Driver>ds)
	{
		ArrayList<Double>speeds = new ArrayList<>();
		speeds.add(ds.get(0).getVehilce().getSpeed());
		speeds.add(ds.get(1).getVehilce().getSpeed());
		speeds.add(ds.get(2).getVehilce().getSpeed());
		speeds.add(ds.get(3).getVehilce().getSpeed());
		
		ArrayList<String>driverNames = new ArrayList<>();
		driverNames.add(ds.get(0).getName());
		driverNames.add(ds.get(1).getName());
		driverNames.add(ds.get(2).getName());
		driverNames.add(ds.get(3).getName());
		
		ArrayList<String>carNames = new ArrayList<>();
		carNames.add(ds.get(0).getVehilce().getCarName());
		carNames.add(ds.get(1).getVehilce().getCarName());
		carNames.add(ds.get(2).getVehilce().getCarName());
		carNames.add(ds.get(3).getVehilce().getCarName());
		
		ArrayList<String>driverTempers = new ArrayList<>();
		driverTempers.add(ds.get(0).getDriverTemperType());
		driverTempers.add(ds.get(1).getDriverTemperType());
		driverTempers.add(ds.get(2).getDriverTemperType());
		driverTempers.add(ds.get(3).getDriverTemperType());
				
		
		this.m.set_info(driverNames, speeds, carNames, driverTempers);	// deliver the information to the concrete subject class
		
        this.draw_updateinfo_in_all_tracks(this.t1.Track1_speed(), this.t1.Track1_drivernames(), this.t1.Track1_carnames(), this.t1.Track1_driverTempers(), 510);
        this.draw_updateinfo_in_all_tracks(this.t2.Track2_speed(), this.t2.Track2_drivernames(), this.t2.Track2_carnames(), this.t2.Track2_driverTempers(), 530);
        this.draw_updateinfo_in_all_tracks(this.t3.Track3_speed(), this.t3.Track3_drivernames(), this.t3.Track3_carnames(), this.t3.Track3_driverTempers(), 550);
        this.draw_updateinfo_in_all_tracks(this.t4.Track4_speed(), this.t4.Track4_drivernames(), this.t4.Track4_carnames(), this.t4.Track4_driverTempers(), 570);
	}

	
	private BufferedImage create_background()
	{
		
		try 
		{
			return ImageIO.read(new File(this.BACKGROUND_PATH));// read the picture that will decorate the background
			            
		} 

		catch (Exception e) 
		{	
			System.out.print(e);
            return null;
        }
		
	}
		
	
	

}
