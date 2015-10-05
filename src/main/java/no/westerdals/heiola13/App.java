package no.westerdals.heiola13;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            Statement statement = connection.createStatement();
            // List all tables
            ResultSet resultSet = statement.executeQuery("SELECT * FROM nasjonaldyr");
        }
    }

    public void updateUser(){}
    public void storeUser(){}
    public void getUser(){}
    public void getAllUsers(){}
    public void deleteUser(){}
}
