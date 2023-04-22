import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    
    public static Connection connectDatabase(){
        Connection connect = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connect = DriverManager.getConnection("jdbc:mysql://localhost/waterbillingsystem", "root", "root");
            
            System.out.println("Database Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connect;  
    }
}
