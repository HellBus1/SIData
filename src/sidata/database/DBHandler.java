package sidata.database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author syubban
 */
public class DBHandler {
    // Prepare connection
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/sidata";
    final String USER = "root";
    final String PASSWORD = "";
    
    private static DBHandler instance;
    
    // Prepare connection instance
    private Connection connection;
//    private Statement statement;
//    private ResultSet resultSet;
    
    private DBHandler() throws SQLException {
        try {
            // Registering driver
            Class.forName(JDBC_DRIVER);
            // Make connection
            this.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database creation failed : " + e.getMessage());
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public static DBHandler getInstance() throws SQLException {
        if(instance == null) {
            instance = new DBHandler();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBHandler();
        }
        
        return instance;
    }
}
