/**
 * It is the class the user uses to implement the operation.
 * This class uses the methods of the Command interface.
 * Thus, it has common features with other processes.
 */
public class Alter_Command implements Command{
    private AlterClass alter;
    private String old_values; // old operation result
    private String old_UserCode; // old user command
    private String Database; // current Database

    /**
     *
     * @param alterClass user alter class
     * @param Database database the user wants to use
     */
    public Alter_Command(AlterClass alterClass, String Database){
        this.alter = alterClass;
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
        old_values = alter.getValues();
        old_UserCode = alter.getUserCode();
        alter.alter_operation(Database, alter.getUserCode());
    }

    /**
     * undo method
     */
    @Override
    public void undo() {
        System.out.println("Making undo in Update_Command class");
        System.out.println("Your values before undo (Update_Command) : " + alter.getValues());
        alter.setValues(old_values);
        alter.setUserCode(old_UserCode);
        System.out.println("Your current values after undo (Update_Command) : " + alter.getValues());

    }

    public void setDatabase(String database) {
        Database = database;
    }

    public String getDatabase() {
        return Database;
    }
}
