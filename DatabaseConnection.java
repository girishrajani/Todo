import java.sql.Connection;
import java.sql.DriverManager;

class DatabaseConnection{
    DatabaseConnection(){
        String databaseURL = "jdbc:ucanaccess://Todo.accdb";
        try {
            Connection con = DriverManager.getConnection(databaseURL);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}