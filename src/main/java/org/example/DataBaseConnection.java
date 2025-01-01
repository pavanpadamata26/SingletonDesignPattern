package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class DataBaseConnection {
    private static volatile DataBaseConnection instance;
    private static  final int MAX_POOL_SIZE=5;
    private Queue<Connection> conectionPool=new LinkedList<>();

    private DataBaseConnection() throws SQLException {
        try {
            // Initialize the connection pool with MAX_POOL_SIZE
            for (int i = 0; i < MAX_POOL_SIZE; i++) {
                conectionPool.offer(DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing the connection pool", e);
        }
    }


    public static DataBaseConnection getInstance() throws SQLException {
        if(instance==null){
            synchronized (DataBaseConnection.class){
                if(instance==null){
                    instance=new DataBaseConnection();
                }
            }
        }
        return instance;
    }

    public synchronized Connection getConnection(){
        if(conectionPool.isEmpty()){
            throw new RuntimeException("No connections available in the pool");
        }
        return conectionPool.poll();
    }
    public synchronized void releaseConnection(Connection connection){
        if(connection!=null){
            conectionPool.offer(connection);
        }
    }
}
