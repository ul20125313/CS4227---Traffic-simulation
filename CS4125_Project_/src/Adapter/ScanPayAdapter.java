package Adapter;

import Driver.Driver;

public class ScanPayAdapter implements ScanPay {

	private OnlinePay cp;
	boolean Whether_successful_pay;

	public boolean paySystem(Driver d, Picture pic) {

		System.out.println("this is the scan mehtod for payment");
		open_camera(d, pic);
		return Whether_successful_pay;
	}

	@Override
	public void open_camera(Driver d, Picture pic) {
		scan_picture(d, pic);
		// TODO Auto-generated method stub

	}

	@Override
	public void scan_picture(Driver d, Picture pic) {
		this.cp = new OnlinePay();
		Whether_successful_pay = cp.paySystem(d, pic.getTicket_code());
		// TODO Auto-generated method stub

	}

}