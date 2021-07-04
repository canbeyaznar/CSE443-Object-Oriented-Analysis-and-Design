/**
 * @author Can BEYAZNAR
 * test class
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("Select command test with undo");
        System.out.println("Operations : ");
        String User_command = "SELECT Accounts";
        SelectClass selectClass_v1 = new SelectClass(User_command);
        Select_Command select_command = new Select_Command(selectClass_v1,"BANK-A");
        select_command.execute();
        select_command.undo();
        select_command.execute();
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");

        System.out.println("MultipleCommand Class Test");
        int command_listsize = 3;
        Command[] command_list = new Command[command_listsize];
        selectClass_v1 = new SelectClass(User_command);
        command_list[0] = new Select_Command(selectClass_v1,"BANK-A");

        User_command = "UPDATE Accounts Accounts+1";
        UpdateClass updateClass = new UpdateClass(User_command);
        command_list[1] = new Update_Command(updateClass,"BANK-B");

        User_command = "ALTER Accounts newAccounts";
        AlterClass alterClass = new AlterClass(User_command);
        command_list[2] = new Alter_Command(alterClass,"BANK-C");

        MultipleCommand multipleCommand = new MultipleCommand(command_list);
        multipleCommand.execute();
        multipleCommand.undo();

    }
}
