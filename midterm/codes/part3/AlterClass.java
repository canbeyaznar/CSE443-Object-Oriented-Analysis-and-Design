/**
 * It is a class where we will implement the ALTER method.
 */
public class AlterClass {

    private String UserCode; // user command
    private String values; // values after the process

    /**
     * DEFAULT VALUES
     */
    public AlterClass(){
        UserCode="EMPTY_USERCODE";
        values="EMPTY_VALUES";
    }

    /**
     *
     * @param userCode user's command
     */
    public AlterClass(String userCode){
        this.UserCode = userCode;
        this.values="EMPTY_VALUES";
    }
    /**
     * copy constructor
     * @param alterClass user select class
     */
    public AlterClass(AlterClass alterClass) {
        this.UserCode = alterClass.getUserCode();
        this.values = alterClass.getValues();
    }

    /**
     *
     * @param Database The database provided by the user. determines the database to apply the process.
     * @param userCode User's command
     * @return returns new database obtained after the process
     */
    public String alter_operation(String Database, String userCode){
        this.UserCode = userCode;
        System.out.println("Alter the label's values (ALTER)");
        System.out.println("Your database name is : "+ Database);
        System.out.println("Your code is : "+ this.UserCode + " in " + Database);
        /**
         *
         * Burada islemler olacak
         * databaseden veri alinacak
         * values ile islemler
         *
         *
         */
        values = this.UserCode+"( -> values after ALTER )";
        return values;
    }

    public String getUserCode() {
        return UserCode;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public void setUserCode(String userCode) {
        UserCode = userCode;
    }
}
