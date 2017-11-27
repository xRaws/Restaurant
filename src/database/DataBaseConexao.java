package database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConexao {
    
    public static Connection getConexao()
    {
        try{
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/restaurante","root","root");
            
            return conexao;
        } catch(SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return null;
    }
}
