/**
 * This class is a class created to call multiple commands simultaneously, the execute () and undo () methods.
 */
public class MultipleCommand implements Command{

    private Command[] commands;

    /**
     *
     * @param commands commands array that we will use simultaneously
     */
    public MultipleCommand(Command[] commands){
        this.commands = commands;
    }

    /**
     * execute all the commands
     */
    @Override
    public void execute() {

        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }

    /**
     * undo all the commands
     */
    @Override
    public void undo() {
        for (int i = commands.length-1; i >= 0; i--) {
            commands[i].undo();
        }
    }
}
