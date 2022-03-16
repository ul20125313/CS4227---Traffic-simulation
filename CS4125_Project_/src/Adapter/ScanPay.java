package Adapter;

import Driver.Driver;

public interface ScanPay {
	public void open_camera(Driver d, Picture pic);

	public void scan_picture(Driver d, Picture pic);

}