package Strategy;

import Driver.*;

public interface Strategy {
	
	public void changeDrivingMode_Irr_Default(IrritableDriver irr);
	
	public void changeDrivingMode_Irr_Safe(IrritableDriver irr);
	
	public void changeDrivingMode_Irr_Racer(IrritableDriver irr);
	
	public void changeDrivingMode_Nor_Default(NormalDriver nor);
	
	public void changeDrivingMode_Nor_Safe(NormalDriver nor);
	
	public void changeDrivingMode_Nor_Racer(NormalDriver nor);

}
