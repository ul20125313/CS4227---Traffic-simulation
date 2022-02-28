package Command;

public abstract class RemoteControl {
	protected Command command;
	
	public RemoteControl(Command command)
	{
		this.command = command;		
	}
	
	public abstract void UseRemote();
	
//	public void ButtonPressed()
//	{
//		command.execute();
//	}

}
