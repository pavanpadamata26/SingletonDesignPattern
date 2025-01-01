package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws SQLException {
        SingletonDesign instance1 = SingletonDesign.getInstance();
        SingletonDesign instance2 = SingletonDesign.getInstance();
        if(instance1==instance2){
            System.out.println("Both the instances are same ");
        }
        instance1.showMessage("hello");
        instance2.showMessage("hai");
        ThreadSafeSingleton instance3=ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton instance4=ThreadSafeSingleton.getInstance();
        if(instance3==instance4){
            System.out.println("Both the instances are same ");
        }
        //DataBaseConnection
        DataBaseConnection pool=DataBaseConnection.getInstance();
        Connection connection= pool.getConnection();
        try{
            String query = "SELECT * FROM users WHERE user_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, 1);  // Set parameter for user_id
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String username = rs.getString("username");
                        System.out.println("User: " + username);
                    }
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            pool.releaseConnection(connection);
            System.out.println("Connection released back to the pool");
        }








    }
}
