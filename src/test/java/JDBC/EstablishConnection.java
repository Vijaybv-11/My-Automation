package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnection {

        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/your_database_name";
            String user = "your_username";
            String password = "your_password";


            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connected to the database!");

                // Perform database operations here

            } catch (SQLException e) {
                System.err.println("Connection failed!");
                e.printStackTrace();
            }
        }
    }


