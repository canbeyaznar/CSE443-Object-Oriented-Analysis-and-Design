/**
 * It is the class the user uses to implement the operation.
 * This class uses the methods of the Command interface.
 * Thus, it has common features with other processes.
 */
public class Update_Command implements Command{

    private UpdateClass update; // user select class
    private String old_values; // old operation result
    private String old_UserCode; // old user command
    private String Database; // current Database

    /**
     *
     * @param updateClass user update class
     * @param Database database the user wants to use
     */
    public Update_Command(UpdateClass updateClass, String Database){
        this.update = updateClass;
        old_values="EMPTY_VALUES";
        old_UserCode = "EMPTY_USERCODE";
        this.Database = Database;
    }

    /**
     * execute method
     */
    @Override
    public void execute() {
        // backup old parameters
        old_values = update.getValues();
        old_UserCode = update.getUserCode();
        update.update_operation(Database,update.getUserCode());
    }

    /**
     * undo method
     */
    @Override
    public void undo() {
        System.out.println("Making undo in Update_Command class");
        System.out.println("Your values before undo (Update_Command) : " + update.getValues());
        update.setValues(old_values);
        update.setUserCode(old_UserCode);
        System.out.println("Your current values after undo (Update_Command) : " + update.getValues());
    }
    public void setDatabase(String database) {
        Database = database;
    }

    public String getDatabase() {
        return Database;
    }
}
