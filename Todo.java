import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Todo extends JFrame implements ActionListener 
{
    Connection con;
    Todo j;
    JMenu m1;
    Secondframe sf;
    JButton b1, b2, b3, b4, b5;
    Container co ;    
Todo()       
    {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JMenuBar mb  = new JMenuBar();
        co = getContentPane();
        setJMenuBar(mb);
        b1 = new JButton("red");
        b2 = new JButton("blue");
        b3 = new JButton("yellow");
        b4 = new JButton("ADD TASK");
        b5 = new JButton("Display Tasks");
        b4.setBounds(50,10,100,100);
        mb.add(b1);
        mb.add(b2);
        mb.add(b3);
        add(b4);
        add(b5);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
    }

    // Adding Task code and Color change
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()== b1)
        {
            co.setBackground(Color.red);
        }
        else if( ae.getSource()== b2) 
        {
            co.setBackground(Color.blue);
        } 
        else if(ae.getSource() == b3)
        {
            co.setBackground(Color.yellow);
		}
	if(ae.getSource() == b4)
		{
			sf = new Secondframe();
            sf.setVisible(true);
            sf.setSize(500,500);
        }
        
    // Display Button Code
        
    if (ae.getSource()== b5)
    {
        JOptionPane.showMessageDialog(j,"Your Task has been Displayed "); 
        try{
            String databaseURL = "jdbc:ucanaccess://Todo.accdb";
            con = DriverManager.getConnection(databaseURL);
            System.out.println("Connecting to Acess DB...... Done");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Tasks");
            while (rs.next())
            {
                String Task = rs.getString("Task");
                System.out.println(Task) ;
             }
        }
        catch(Exception e){
    
        }
    }
   }
    

	// 2 nd Frame 
public class Secondframe extends JFrame implements ActionListener
{
    JButton s;
    JLabel l1;
    String s1;
    JTextField t1;
    Secondframe()
    {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        l1 = new JLabel("Enter Task");
        t1 = new JTextField(100);
        s = new JButton("Submit");
        add(l1);
        add(t1);
        add(s);
        s.addActionListener(this);
	}
	
    public void actionPerformed(ActionEvent ae)
    {
        String t2 = t1.getText();
        if (ae.getSource()== s)
        {
            JOptionPane.showMessageDialog(sf,"Your Task has been Submited "); 

        try{
            String databaseURL = "jdbc:ucanaccess://Todo.accdb";
            con = DriverManager.getConnection(databaseURL);
            System.out.println("Connecting to Acess DB...... Done");
            Statement statement = con.createStatement();
            String sql = "INSERT INTO Tasks(task) VALUES ('"+ t2 +"')";
            statement.executeUpdate(sql);
            System.out.println("A new Task Has been Added");
        }
        catch(Exception e){

        }
        }
	}
}
	public static void main(String args[]) throws Exception
    {
	    {         
            Todo j = new Todo();
            j.setVisible(true);
            j.setSize(500,500);
        }
    }	 

}
