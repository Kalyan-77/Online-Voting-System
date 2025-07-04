package org.example.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/voting_system";
    private static final String USER = "postgres";
    private static final String PASSWORD = "kalyan@123";

    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            System.err.println("PostgreSQl JDBC Driver Not Found!");
            e.printStackTrace();
            throw new SQLException("JDBC Driver not Found",e);
        }
        return DriverManager.getConnection(URL,USER,PASSWORD);
    };

    public static void closeConnection(Connection connection){
        if(connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }

}
