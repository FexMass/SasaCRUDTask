package firstVersionCRUD.Main;

import firstVersionCRUD.CRUD.CreateInformation;
import firstVersionCRUD.CRUD.DeleteInformation;
import firstVersionCRUD.CRUD.ReadInformation;
import firstVersionCRUD.CRUD.UpdateInformation;
import firstVersionCRUD.JDBC.DBUtilities;

import java.util.Scanner;

public class DisplayMenuConsole {

    private static Boolean isValid = true;
    private static Scanner userInput = new Scanner(System.in);
    private static String readUserInputString;

    public static void displayFirstMenu() {

        System.out.println("*****************************************");
        System.out.println("|           firstVersionCRUD.CRUD SASA ZADATAK           |");
        System.out.println("*****************************************");
        System.out.println("| Connection:                           |");
        System.out.println("|        1. Connect to database         |");
        System.out.println("|        2. Exit                        |");
        System.out.println("*****************************************");

        System.out.print("Select option: ");
        readUserInputString = userInput.next();

        switch (readUserInputString) {
            case "1":
                DBUtilities.getInstance().connectToDB();
                displaySecondMenu();
                break;
            case "2":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection, try again");
                break;
        }
    }


    public static void displaySecondMenu() {

        System.out.println();
        System.out.println("*****************************************");
        System.out.println("|           firstVersionCRUD.CRUD SASA ZADATAK           |");
        System.out.println("*****************************************");
        System.out.println("| Options:                              |");
        System.out.println("|        1. Create Database Records     |");
        System.out.println("|        2. Read Database Records       |");
        System.out.println("|        3. Update Database Records     |");
        System.out.println("|        4. Delete Database Records     |");
        System.out.println("|        5. Exit                        |");
        System.out.println("*****************************************");

        while (isValid) {

            System.out.print("Select option: ");
            readUserInputString = userInput.next();

            switch (readUserInputString) {
                case "1":
                    new CreateInformation();
                    isValid = false;
                    break;
                case "2":
                    new ReadInformation();
                    isValid = false;
                    break;
                case "3":
                    new UpdateInformation();
                    isValid = false;
                    break;
                case "4":
                    new DeleteInformation();
                    isValid = false;
                    break;
                case "5":
                    DBUtilities.getInstance().disconnectFromDB();
                    System.exit(0);
                    isValid = false;
                    break;
                default:
                    System.out.println("Invalid selection, try again");
                    break;
            }
        }
    }
}

