package firstVersionCRUD.CRUD;

import firstVersionCRUD.JDBC.DBUtilities;
import firstVersionCRUD.Main.DisplayMenuConsole;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ReadInformation {

    public ReadInformation() {
        DisplayResults();
    }

    private void DisplayResults() {

        try {
            String sqlStatement = "select * from kontakti.contacts";
            ResultSet resultSet = DBUtilities.getInstance().readRecords(sqlStatement);
            ResultSetMetaData resultMetaData = resultSet.getMetaData();
            int numberOfColumns = resultMetaData.getColumnCount();

            if (resultSet.next()) {
                    for (int i = 1; i <= numberOfColumns; i++) {
                        System.out.printf("%-20s\t",resultMetaData.getColumnName(i));
                    }
                System.out.println();
                    do {
                        for (int j = 1; j <= numberOfColumns; j++) {
                            System.out.printf("%-20s\t", resultSet.getObject(j));
                        }
                        System.out.println();
                    } while (resultSet.next());
            } else {
                System.out.println("No records. In options go for option 1 to create record!");
            }
        }
        catch (SQLException ex){
            System.out.println("Error " + ex.getMessage());
            DBUtilities.getInstance().disconnectFromDB();
        }
        finally {
            DisplayMenuConsole.displaySecondMenu();
        }
    }
}
