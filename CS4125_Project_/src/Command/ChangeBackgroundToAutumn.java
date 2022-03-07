package Command;
import Draw_Map.Draw_map;

public class ChangeBackgroundToAutumn implements Command{
	private Draw_map d_m;
	public ChangeBackgroundToAutumn(Draw_map d_m)
	{
		this.d_m =  d_m;
	}
	public void execute()
	{
		d_m.setautumnbackground();
	}
	
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}


}

