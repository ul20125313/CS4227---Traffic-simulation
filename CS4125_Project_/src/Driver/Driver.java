package Driver;
import CollisionDetection.CollisionMonitor;
import Thread.Threadprocess;
import Vehicle.Vehicle;

public abstract class Driver implements Runnable{
	
	private String name;
    protected Vehicle vehicle;
    protected String driverTemperType;
    protected CollisionMonitor c;
    //protected static boolean is_Collision;
    protected boolean is_Collision;
    protected boolean cant_work_state;
    public static int mode_code;
    protected int balance;
    private int col;
    public Driver() {}
    

 
	public Driver(String name, Vehicle vehicle, String driverTemperType, int balance)//the constructor of class driver
	{
		this.name = name;
		this.vehicle = vehicle;
		this.driverTemperType = driverTemperType;
		this.is_Collision = false;
		this.cant_work_state = false;
		this.mode_code = 1;
		this.balance = balance;	
		this.col = 0;
	}

	public int getBalance()
	{
		return this.balance;
	}
	public boolean getIs_Collosion() {
		return is_Collision;
	}
	
	public static void setCode_1()
	{
		mode_code = 1;
	}
	public static void setCode_2()
	{
		mode_code = 2;
	}
	public static void setCode_3()
	{
		mode_code = 3;
	}

	public void setColl(CollisionMonitor c)
	{
		this.c = c;
	}
	public String getName()// return the name
	{
		return this.name;
	}
	
	public Vehicle getVehilce()// return the object driver
	{
		return this.vehicle;
	}
	
	public void drive()// call the move function in instance vehicle
	{
		//it seems that driver is driving his car
		
		this.vehicle.move();
	}
	
	@Override
	 public abstract void run();
	
	public String getDriverTemperType() {// return the driverTemperTpe
		return this.driverTemperType;
	}
	
	public void pri() {
		
	}
	
	public void stop()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print("error for driver stop");
		}
	}
	
	public void Drive() {
		
	}
	
	public void driver_cant_work()// callback
	{
		this.is_Collision = true;
	}


}
