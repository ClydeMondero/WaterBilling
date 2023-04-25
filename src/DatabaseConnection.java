import java.sql.Connection;
import java.sql.DriverManager;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.ibatis.jdbc.ScriptRunner;

public class DatabaseConnection {
    
    public static Connection connectDatabase(){
        Connection connect = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connect = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "root");                        
            
<<<<<<< Updated upstream
            System.out.println("Database Connected");  
=======
            System.out.println("Database Connected");                                      
        } catch (Exception e){            
        }
        return connect;  
    }
    
    public static Connection runDatabase() {
        connectDatabase();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connect = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "root");                        
>>>>>>> Stashed changes
            
            System.out.println("Database Connected");     
            
            ScriptRunner scriptRunner = new ScriptRunner(connect);
            Reader reader = new BufferedReader(new FileReader("src/Database.sql"));

            scriptRunner.runScript(reader);
<<<<<<< Updated upstream
            
        } catch (Exception e){            
=======

            System.out.println("Database Executed");

        } catch (Exception e) {
>>>>>>> Stashed changes
        }
        return connect;
    }
}
