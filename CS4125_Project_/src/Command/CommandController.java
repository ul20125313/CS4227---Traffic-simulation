package Command;

public class CommandController {
	protected Command command;
	
	protected Command[] accelerationCommands;
	protected Command[] decelerationCommands;
	protected Command undoCommand;
	
	public CommandController(Command command) // for changing Morning/Night/Autumn/Winter background
	{
		this.command = command;		
	}
	
	public void changeBackground() // for changing Morning/Night/Autumn/Winter background
	{
		command.execute();
	}
	
	public CommandController() {
		accelerationCommands = new Command[10];
		decelerationCommands = new Command[10];
		
		Command noCommand = new NoCommand();
		for(int i = 0; i < 10; i++) {
			accelerationCommands[i] = noCommand;
			decelerationCommands[i] = noCommand;
		}
		undoCommand = noCommand;
	}
	
	public void setCommand(int slot, Command accelerationCommand, Command decelerationCommand) {
		accelerationCommands[slot] = accelerationCommand;
		decelerationCommands[slot] = decelerationCommand;
	}
	
	public void accelerationKeyPressed(int slot) {
		accelerationCommands[slot].execute();
		undoCommand = accelerationCommands[slot];
	}
	
	public void decelerationKeyPressed(int slot) {
		decelerationCommands[slot].execute();
		undoCommand = decelerationCommands[slot];
	}
	
	public void undoKeyPressed() {
		undoCommand.undo();
	}
	
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control ------\n");
		for(int i = 0; i < accelerationCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + accelerationCommands[i].getClass().getName()
					+ "      " + decelerationCommands[i].getClass().getName() + "\n");
		}
		return stringBuff.toString();
	}
}
