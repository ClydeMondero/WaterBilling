import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    
    public static Connection connectDatabase(){
        Connection connect = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connect = DriverManager.getConnection("jdbc:mysql://localhost/waterbilling", "root", "root");
            
            System.out.println("Database Connected");                                                                   
            
        } catch (ClassNotFoundException | SQLException ex) {                                
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return connect;  
    }
}
