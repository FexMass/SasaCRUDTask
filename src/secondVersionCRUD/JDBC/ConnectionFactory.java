package secondVersionCRUD.JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//Mogao sam i direktno slat parametre preko fieldova zahardkodirane, ali smatram ovo boljim nacinom
public class ConnectionFactory {

    private static ConnectionFactory INSTANCE;
    private Properties properties = new Properties();
    private static Connection connection;

    private ConnectionFactory() {}

    public Connection getConnection() {
        try {
        FileInputStream in = new FileInputStream("src/db.properties");
        properties.load(in);
        in.close();

        String driver = properties.getProperty("jdbc.driver");
        if (driver != null) {
            Class.forName(driver);
        }

        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        connection = DriverManager.getConnection(url, username, password);

        return connection;
        }
        catch (IOException | ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Error connecting to database!", ex);
        }
    }

    public void disconnectDB() {
        if (connection != null) {
            try {
                connection.close();

            } catch (SQLException e) {
                System.out.println("Connection cant be closed!");
            }
        }
    }

    public static ConnectionFactory getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new ConnectionFactory();
        }
        return INSTANCE;
    }
}
