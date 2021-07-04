/**
 * It is a class where we will implement the SELECT method.
 */
public class SelectClass {

    private String UserCode; // user command
    private String values; // values after the process

    /**
     * DEFAULT VALUES
     */
    public SelectClass(){
        UserCode="EMPTY_USERCODE";
        values="EMPTY_VALUES";
    }

    /**
     *
     * @param select_code user's command
     */
    public SelectClass(String select_code){
        this.UserCode = select_code;
        this.values = "EMPTY_VALUES";
    }

    /**
     * copy constructor
     * @param selectClass user select class
     */
    public SelectClass(SelectClass selectClass) {
        this.UserCode = selectClass.getUserCode();
        this.values = selectClass.getValues();
    }

    /**
     *
     * @param Database The database provided by the user. determines the database to apply the process.
     * @param userCode User's command
     * @return returns new database obtained after the process
     */
    public String select_operation(String Database,String userCode){
        this.UserCode = userCode;
        System.out.println("Getting the label's values (SELECT)");
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
        values = this.UserCode+"( -> values after SELECT )";
        return values;
    }

    public String getValues() {
        return values;
    }

    public String getUserCode() {
        return UserCode;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public void setUserCode(String userCode) {
        UserCode = userCode;
    }
}
