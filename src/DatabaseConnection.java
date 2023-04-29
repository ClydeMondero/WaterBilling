
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.jdbc.ScriptRunner;

public class DatabaseConnection {

    static Connection connect = null;

    public static Connection connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connect = DriverManager.getConnection("jdbc:mysql://localhost/waterbilling", "root", "root");

        } catch (Exception e) {
        }
        return connect;
    }

    public static Connection runDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connect = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "root");

            ScriptRunner scriptRunner = new ScriptRunner(connect);
            Reader reader = new BufferedReader(new FileReader("src/Database.sql"));

            scriptRunner.runScript(reader);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connect;
    }
}
