/**
 * It is a class where we will implement the UPDATE method.
 */
public class UpdateClass {
    private String UserCode; // user command
    private String values; // values after the process

    /**
     * DEFAULT VALUES
     */
    public UpdateClass(){
        UserCode="EMPTY_USERCODE";
        values="EMPTY_VALUES";
    }

    /**
     *
     * @param userCode user's command
     */
    public UpdateClass(String userCode){
        this.UserCode = userCode;
        this.values="EMPTY_VALUES";
    }
    /**
     * copy constructor
     * @param updateClass user select class
     */
    public UpdateClass(UpdateClass updateClass) {
        this.UserCode = updateClass.getUserCode();
        this.values = updateClass.getValues();
    }

    /**
     *
     * @param Database The database provided by the user. determines the database to apply the process.
     * @param userCode User's command
     * @return returns new database obtained after the process
     */
    public String update_operation(String Database,String userCode){
        this.UserCode = userCode;
        System.out.println("Updating the label's values (UPDATE)");
        System.out.println("Your database name is : "+Database);
        System.out.println("Your code is : "+ this.UserCode + " in " + Database);
        /**
         *
         * Burada islemler olacak
         * databaseden veri alinacak
         * values ile islemler
         *
         *
         */
        values = this.UserCode+"( -> values after UPDATE )";
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
