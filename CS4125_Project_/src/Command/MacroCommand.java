package Command;

public class MacroCommand implements Command{
	Command[] commands;
	
	public MacroCommand(Command[] commands) {
		this.commands = commands;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for(int i = 0; i < commands.length; i++) {
			if(commands[i] != null)
				commands[i].execute();
		}
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		for(int i = commands.length - 1; i >= 0; i--) {
			if(commands[i] != null)
				commands[i].undo();
		}
	}

}
