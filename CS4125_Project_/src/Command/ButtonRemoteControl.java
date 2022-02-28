package Command;

public class ButtonRemoteControl extends RemoteControl{

	public ButtonRemoteControl(Command command) {
		super(command);
		// TODO Auto-generated constructor stub
	}
	
	public void UseRemote() {
		command.execute();
	}

}
