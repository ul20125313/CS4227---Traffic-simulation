package Command;
import Draw_Map.Draw_map;

public class ChangeBackgroundToMorning implements Command{
	private Draw_map d_m;
	public ChangeBackgroundToMorning(Draw_map d_m)
	{
		this.d_m =  d_m;
	}
	public void execute()
	{
		d_m.setmorningbackground();
	}

}
