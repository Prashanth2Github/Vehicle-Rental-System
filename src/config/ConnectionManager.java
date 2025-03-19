package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static Connection connection;

    static {
        try {
            // Load database properties from config file
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("C:/PROJECTS/VehicleRentalSystem/resources/config.properties");
            props.load(fis);

            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Establish Connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Database connected successfully!");

        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to connect to database!", e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
