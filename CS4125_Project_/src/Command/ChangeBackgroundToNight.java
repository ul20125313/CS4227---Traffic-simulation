package Command;
import Draw_Map.Draw_map;

public class ChangeBackgroundToNight implements Command{
	private Draw_map d_m;
	public ChangeBackgroundToNight(Draw_map d_m)
	{
		this.d_m =  d_m;
	}
	public void execute()
	{
		d_m.setmorningbackground();
	}


}
