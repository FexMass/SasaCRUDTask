package firstVersionCRUD.CRUD;

import firstVersionCRUD.JDBC.DBUtilities;
import firstVersionCRUD.Main.DisplayMenuConsole;

import java.util.Scanner;

public class DeleteInformation {

    private String personID;
    public DeleteInformation() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("You selected option 4: Delete database record: ");

        System.out.print("Enter customer id to delete: ");
        personID = userInput.next();

        String confirm_delete;
        System.out.print("Enter Y to confirm deletion: ");
        confirm_delete = userInput.next();

        if ("Y".equalsIgnoreCase(confirm_delete)) {

            String sql_stmt = "delete from contacts where id = " + personID;

            DBUtilities.getInstance().executeSQLStatement(sql_stmt);

            System.out.println("The Record has successfully being deleted");
        }
        else{
            System.out.println("Record wont be deleted");
        }

        DisplayMenuConsole.displaySecondMenu();
    }
}
