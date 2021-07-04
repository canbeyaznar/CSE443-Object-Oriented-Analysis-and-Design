/**
 * It is the class the user uses to implement the operation.
 * This class uses the methods of the Command interface.
 * Thus, it has common features with other processes.
 */
public class Select_Command implements Command{

    private SelectClass select; // user select class
    private String old_values; // old operation result
    private String old_UserCode; // old user command
    private String Database; // current Database

    /**
     *
     * @param selectClass user select class
     * @param Database database the user wants to use
     */
    public Select_Command(SelectClass selectClass, String Database){
        old_values="EMPTY_VALUES";
        old_UserCode = "EMPTY_USERCODE";
        this.Database = Database;
        this.select = selectClass;
    }

    /**
     * execute method
     */
    @Override
    public void execute() {
        // backup old parameters
        old_values = select.getValues();
        old_UserCode = select.getUserCode();
        select.select_operation(Database, select.getUserCode());
    }

    /**
     * undo method
     */
    @Override
    public void undo() {
        System.out.println("Making undo in Select_Command class");
        System.out.println("Your values before undo (Select_Command) : " + select.getValues());
        select.setValues(old_values);
        select.setUserCode(old_UserCode);
        System.out.println("Your current values after undo (Select_Command) : " + select.getValues());
    }
    public void setDatabase(String database) {
        Database = database;
    }

    public String getDatabase() {
        return Database;
    }
}
