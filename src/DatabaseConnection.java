import java.io.*;
import java.sql.*;
import org.apache.ibatis.jdbc.ScriptRunner;

public class DatabaseConnection {
    
    public static Connection connectDatabase(){
        Connection connect = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connect = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "root");                        
            
            System.out.println("Database Connected");  
            
            ScriptRunner scriptRunner = new ScriptRunner(connect);            
            Reader reader = new BufferedReader(new FileReader("src/Database.sql"));
            
            scriptRunner.runScript(reader);
            
        } catch (Exception e){            
        }
        return connect;  
    }
}
