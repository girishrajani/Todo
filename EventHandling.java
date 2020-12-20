import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.FlowLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane; 
import javax.swing.JTable; 

import java.awt.Color;
import java.awt.Font;

class EventHandling extends JFrame implements ActionListener {
    String databaseURL;
    Connection con;
    JButton submit;
    JLabel enter;
    JTextField task;
    JFrame addTaskFrame,displaytaskFrame;
        EventHandling(){
        super();
        databaseURL = "jdbc:ucanaccess://Todo.accdb";
        try {
            con = DriverManager.getConnection(databaseURL);
            System.out.println("Connecting to Acess DB...... Done");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Add Task"){
            // Creating a new JFrame for Add Task Window
            addTaskFrame = new JFrame();
            addTaskFrame.setVisible(true);
            addTaskFrame.setSize(250,350);
            addTaskFrame.setTitle("Add Task");
            addTaskFrame.getContentPane().setBackground(Color.darkGray);
            addTaskFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
            enter = new JLabel("Enter Task");
            enter.setForeground(Color.WHITE);
            task = new JTextField(100);
            submit = new JButton("Submit");
            enter.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
            task.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
            addTaskFrame.add(enter);
            addTaskFrame.add(task);
            addTaskFrame.add(submit);
            submit.addActionListener(this);
        }
        if(e.getActionCommand()=="Display Tasks"){
            
            // Making a new JFrame for displaying Tasks
            displaytaskFrame = new JFrame();
            displaytaskFrame.setTitle("Your Tasks");
            displaytaskFrame.setVisible(true);
            displaytaskFrame.setSize(500,350);
            

            // displaytaskFrame.getContentPane().setBackground(Color.darkGray);

            // Fetching DATA from the database to display

            String[][] tableData= new String[100][2];
            String[] tableColNames = {"Number","Task"};
            try{
                ; 
                // String[] allTasks = {};
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM Tasks");
                int count = 0;
                while (rs.next())
                {   
                    String Task = rs.getString("Task");
                    tableData[count][1]=Task;
                    tableData[count][0]=String.valueOf(count+1);
                    System.out.println(Task) ;
                    count += 1;
                 }
                // Displaying the fetched data in the JFrame Output Screen

                JTable dataTable = new JTable(tableData, tableColNames);
                dataTable.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
                JScrollPane sp = new JScrollPane(dataTable);
                displaytaskFrame.add(sp);
            }catch(Exception ex){
                System.out.println(ex);
            }

             
            
        }
        if(e.getActionCommand()=="Delete All Tasks"){
            try {
                Statement stmt = con.createStatement();
                stmt.execute("DELETE FROM Tasks");
                JOptionPane.showMessageDialog(addTaskFrame,"All Your Tasks are now Deleted.");
                
            } catch (Exception ecx) {
                //TODO: handle exception
            }
            


        }
        if(e.getSource()==submit){
            try {
                // Statement statement = con.createStatement();
                // String sql = "INSERT INTO Tasks(Task) VALUES ('"+ task +"')";
                PreparedStatement pstmt = con.prepareStatement("INSERT INTO Tasks(Task) VALUES (?)");
                pstmt.setString(1, task.getText());
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(addTaskFrame,"Your Task has been Submited "); 
                addTaskFrame.dispose();

            } catch (Exception exc) {
                System.out.println(exc);
            }
            

        }
    }
}
