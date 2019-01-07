package firstVersionCRUD.CRUD;

import firstVersionCRUD.JDBC.DBUtilities;
import firstVersionCRUD.Main.DisplayMenuConsole;

import java.util.Scanner;

public class UpdateInformation {

    private String customer_id,ime,prezime,email,brojTelefona,grad,drzava;

    public UpdateInformation() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("You selected option 3: Update database record: ");

        System.out.print("Enter customer id to update: ");
        customer_id = userInput.nextLine();

        System.out.print("Enter name: ");
        ime = userInput.nextLine();

        System.out.print("Enter last name: ");
        prezime = userInput.nextLine();

        System.out.print("Enter email: ");
        email = userInput.nextLine();

        System.out.print("Enter number: ");
        brojTelefona = userInput.nextLine();

        System.out.print("Enter city: ");
        grad = userInput.nextLine();

        System.out.print("Enter state: ");
        drzava = userInput.nextLine();

        String sql_stmt = "UPDATE contacts SET ime = '" + ime + "', prezime = '" + prezime + "', email = '" + email + "', broj_telefona = '" + brojTelefona + "', grad = '" + grad + "', drzava = '" + drzava + "' " +
                "WHERE id = " + customer_id;

        DBUtilities.getInstance().executeSQLStatement(sql_stmt);

        DisplayMenuConsole.displaySecondMenu();
    }
}
