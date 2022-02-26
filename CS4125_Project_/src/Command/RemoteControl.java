package Command;

public class RemoteControl {
	private Command command;
	
	public RemoteControl(Command command)
	{
		this.command = command;		
	}
	
	public void ButtonPressed()
	{
		command.execute();
	}

}
