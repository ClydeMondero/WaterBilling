import java.sql.Connection;
import java.sql.DriverManager;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.ibatis.jdbc.ScriptRunner;

public class DatabaseConnection {
    
    static Connection connect = null;
    
    public static Connection connectDatabase(){                
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connect = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "root");                        
            
            System.out.println("Database Connected");                                      
        } catch (Exception e){            
        }
        return connect;  
    }
    
    public static Connection runDatabase(){                
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connect = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "root");                                                
            
            ScriptRunner scriptRunner = new ScriptRunner(connect);            
            Reader reader = new BufferedReader(new FileReader("src/Database.sql"));
            
            scriptRunner.runScript(reader);
            
            System.out.println("Database Executed");  
            
        } catch (Exception e){            
        }
        return connect;  
    }
}
