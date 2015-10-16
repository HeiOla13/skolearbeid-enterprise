package no.westerdals.heiola13;

import javax.enterprise.inject.Default;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ola on 08.10.2015.
 */
@ServiceQualifier
public class UsersDatabase implements Users{
    public static Connection con;

    public UsersDatabase() throws SQLException, ClassNotFoundException{
        Class.forName("org.h2.Driver");
        con = DriverManager.getConnection("jdbc:h2:~/users", "sa", "");
    }

    public List<Bruker> getAllUsers(){

        List<Bruker> list = new ArrayList<Bruker>();
        Bruker b = null;
        try {
            Statement statement = con.createStatement();
            // List all tables
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");

            while (resultSet.next()) {
                //System.out.println(resultSet.getString(1) + ":\t" + resultSet.getString(2) + " | " + resultSet.getString(4));
                b = new Bruker(resultSet.getString("email"), resultSet.getString("password"), Type.valueOf(resultSet.getString("Type")));
                b.setId(resultSet.getInt(1));
                list.add(b);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public void updateUser(int id, String email, String password, Type type){
        Statement stmt = null;
        String sql = "UPDATE USERS SET EMAIL = '" + email + "', PASSWORD='" + password + "', TYPE='" + type
                + "' WHERE ID=" + id + ";";
        try{
            stmt = con.createStatement();
            stmt.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addUser(Bruker user){
        Statement stmt = null;
        String sql = "INSERT INTO users (EMAIL, PASSWORD, TYPE) "
                + "VALUES('" + user.getEmail() + "', '" + user.getPassord() + "', '" + user.getType() + "');";

        try{
            stmt = con.createStatement();
            stmt.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public Bruker getUser(int id){
        Bruker b = null;
        try {
            Statement statement = con.createStatement();
            // List all tables
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS WHERE ID = " + id);

            while (resultSet.next()) {
                //System.out.println(resultSet.getString(1) + ":\t" + resultSet.getString(2) + " | " + resultSet.getString(4));
                b = new Bruker(resultSet.getString("email"), resultSet.getString("password"), Type.valueOf(resultSet.getString("type")));
                b.setId(resultSet.getInt(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return b;
    }

    public void deleteUser(int id){
        String sql = "DELETE FROM users WHERE ID = " + id;
        try{
            Statement stmt = con.createStatement();
            stmt.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void exec(){
        System.out.println("Using Embedded H2-database as persistance-technology");
    }
}
