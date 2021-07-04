/**
 * Command interface for SELECT, UPDATE and ALTER commands
 */
public interface Command {

    void execute();
    void undo();
}
