package firstVersionCRUD.JDBC;

import java.sql.*;

public class DBUtilities {

    private static final String DATABASE_URL = "jdbc:mysql://localhost/kontakti";
    private static DBUtilities instance;
    private static Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private DBUtilities() {}

    public void connectToDB(){
        try {
            connection = DriverManager.getConnection(DATABASE_URL, "Test", "root");
            System.out.println("Connection successful! Although Without ssl connection which we can ignore for this purpose!");
            instance = new DBUtilities();
        }
        catch(Exception ex){
            System.out.println("Exception in creating singleton instance" + ex.getMessage() + " | " + ex.getClass());
        }
    }

    public void disconnectFromDB() {

        try {

            if (resultSet != null ){ resultSet.close(); }
            if (statement != null){ statement.close(); }

            connection.close();
            System.out.println("Disconnect successful!");
        }
        catch (Exception ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }

    public ResultSet readRecords(String sql_stmt) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql_stmt);

            return resultSet;
        }
        catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }

        return resultSet;
    }

    public void executeSQLStatement(String sql_stmt) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql_stmt);
        }
        catch (SQLException ex) {
            System.out.println("Neuspejsna operacija: " + ex.getMessage());
        }
        System.out.println("Operacija uspjesna!");
    }

    public static DBUtilities getInstance() {
        if (instance == null)
            instance = new DBUtilities();
        return instance;

    }
}
