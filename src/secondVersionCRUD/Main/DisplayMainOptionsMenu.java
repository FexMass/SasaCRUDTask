package secondVersionCRUD.Main;

import secondVersionCRUD.DAOimpl.EntityDAOimpl;
import secondVersionCRUD.ENUM.Choices;
import secondVersionCRUD.JDBC.ConnectionFactory;
import secondVersionCRUD.Model.Entity;

import java.sql.Connection;
import java.util.Scanner;

public class DisplayMainOptionsMenu {

    private static Boolean isValid = true;
    private static Scanner userInput = new Scanner(System.in);
    private static String readUserInputString;
    private static Connection connection;
    private static EntityDAOimpl entityDAOimpl;

    public static void displayOptionsMenu() {
        System.out.println();
        System.out.println("****************************************");
        System.out.println("|          CRUD SASA ZADATAK           |");
        System.out.println("****************************************");
        System.out.println("| Connection:                          |");
        System.out.println("|        1. Connect to database        |");
        System.out.println("|        Any other key: Exit           |");
        System.out.println("****************************************");
        System.out.println();

        System.out.print("Select option: ");
        readUserInputString = userInput.next();

        if (readUserInputString.equals(Choices.option1.toString())) {
            connection = ConnectionFactory.getInstance().getConnection();
            System.out.println("Connection successful!");
            entityDAOimpl = new EntityDAOimpl(connection);
            displayOptionsMenuSecond();
        } else {
            System.exit(0);
        }
    }

    public static void displayOptionsMenuSecond() {

        System.out.println();
        System.out.println("*****************************************");
        System.out.println("|           CRUD SASA ZADATAK           |");
        System.out.println("*****************************************");
        System.out.println("| Options:                              |");
        System.out.println("|        1. Create Database Records     |");
        System.out.println("|        2. Read Database Records       |");
        System.out.println("|        3. Update Database Records     |");
        System.out.println("|        4. Delete Database Records     |");
        System.out.println("|        Any other key: Exit            |");
        System.out.println("*****************************************");
        System.out.println();

        while (isValid) {

            System.out.print("Select option: ");
            readUserInputString = userInput.next();

            if (readUserInputString.equals(Choices.option1.toString())) {
                Entity entity = new Entity();
                System.out.print("Enter ime: ");
                entity.setIme(userInput.next());
                System.out.print("Enter prezime: ");
                entity.setPrezime(userInput.next());
                System.out.print("Enter email: ");
                entity.setEmail(userInput.next());
                System.out.print("Enter broj telefona: ");
                entity.setBrojTelefona(userInput.next());
                System.out.print("Enter grad: ");
                entity.setGrad(userInput.next());
                System.out.print("Enter drzavu: ");
                entity.setDrzava(userInput.next());
                entityDAOimpl.insertEntity(entity);

                System.out.println("Insert successful!");
                displayOptionsMenuSecond();
            } else if (readUserInputString.equals(Choices.option2.toString())) {
                for (Entity entity : entityDAOimpl.getAllEntities()) {
                    System.out.println(entity.toString());
                }
                displayOptionsMenuSecond();
            } else if (readUserInputString.equals(Choices.option3.toString())) {
                System.out.print("Enter id of record u wish to update: ");
                readUserInputString = userInput.next();

                for (Entity entity : entityDAOimpl.getAllEntities()) {
                    if (readUserInputString.equals(String.valueOf(entity.getId()))) {
                        System.out.println("Record id found!");
                        System.out.print("Enter ime: ");
                        entity.setIme(userInput.next());
                        System.out.print("Enter prezime: ");
                        entity.setPrezime(userInput.next());
                        System.out.print("Enter email: ");
                        entity.setEmail(userInput.next());
                        System.out.print("Enter broj telefona: ");
                        entity.setBrojTelefona(userInput.next());
                        System.out.print("Enter grad: ");
                        entity.setGrad(userInput.next());
                        System.out.print("Enter drzavu: ");
                        entity.setDrzava(userInput.next());
                        if (entityDAOimpl.updateEntity(entity)) {
                            System.out.println("Update successful!");
                        }
                        break;
                    }
                }
                displayOptionsMenuSecond();
            } else if (readUserInputString.equals(Choices.option4.toString())) {
                System.out.print("Enter id to delete that record: ");
                if (entityDAOimpl.deleteEntity(userInput.next())) {
                    System.out.println("Id deleted!");
                }
                displayOptionsMenuSecond();
            } else {
                ConnectionFactory.getInstance().disconnectDB();
                System.out.println("Disconnected from DB! Closing application");
                isValid = false;
                System.exit(0);
            }
        }
    }
}
