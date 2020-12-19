import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color.*;

import java.sql.*;

class DatabaseConnection{
    DatabaseConnection(){
        String databaseURL = "jdbc:ucanaccess://Todo.accdb";
        try {
            Connection con = DriverManager.getConnection(databaseURL);
            System.out.println("Connecting to Acess DB...... Done");
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
}
class EventHandling extends DatabaseConnection implements ActionListener {
    EventHandling(){
        super();
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Add Task"){
            new AddTask();
        }

    }
}
