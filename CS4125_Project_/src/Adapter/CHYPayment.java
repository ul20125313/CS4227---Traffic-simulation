package Adapter;

import java.awt.Point;

import Driver.Driver;
import Framework.Framework;
import Framework.PrePayContext;
import Vehicle.Vehicle;

public class CHYPayment {

	private Driver driver;

	private OnlinePay cp;
	private ScanPayAdapter sp;
	private Point cant_move_cars_loc;
	private Picture pic;

	public CHYPayment(Picture pic) {
		this.pic = pic;
		this.sp = new ScanPayAdapter();
		this.cant_move_cars_loc = new Point((40), (40));
	}

	public CHYPayment(int code) {
		this.cp = new OnlinePay();
		this.cant_move_cars_loc = new Point((40), (40));
	}

	public void setDriverInformation(Driver d) {
		this.driver = d;

	}

	public boolean check_whether_can_afford() {
		
		//before pay()
		PrePayContext context = new PrePayContext(1, this.driver);
		Framework.getInstance().prePay(context);

		if (this.sp.paySystem(this.driver, this.pic)) {
			System.out.println(this.driver.getName() + " has enough money, so he can drive in this road.\n");
			return true;
		}

		else {
			System.out.println(this.driver.getName() + " doesn't have enough money, so he can't drive in this road.\n");
			this.driver.getVehilce().setPosition((int) this.cant_move_cars_loc.getX(),
					(int) this.cant_move_cars_loc.getY());
			return false;

		}

	}

}