package firstVersionCRUD.CRUD;

import firstVersionCRUD.JDBC.DBUtilities;
import firstVersionCRUD.Main.DisplayMenuConsole;

import java.util.Scanner;

public class CreateInformation {

    private String ime,prezime,email,brojTelefona,grad,drzava;
    public CreateInformation() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("You selected option 1: Create database record: ");

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

        String sql_stmt = "insert into kontakti.contacts (ime,prezime,email,broj_telefona,grad,drzava) VALUES ('" + ime + "','" + prezime + "','" + email + "','" + brojTelefona + "','" + grad + "','" + drzava + "')";
        DBUtilities.getInstance().executeSQLStatement(sql_stmt);

        DisplayMenuConsole.displaySecondMenu();

    }
}
