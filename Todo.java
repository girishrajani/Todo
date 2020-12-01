import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class Todo extends JFrame implements ActionListener 
{
    JMenu m1;
    JButton b1, b2, b3, b4;
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
        b4.setBounds(50,10,100,100);
        mb.add(b1);
        mb.add(b2);
        mb.add(b3);
        add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

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
			Secondframe sf = new Secondframe();
            sf.setVisible(true);
            sf.setSize(500,500);
		}
	}
	// 2 nd Frame 
public class Secondframe extends JFrame implements ActionListener
{

    JButton s;
    JTextField t1,t2 ,t3 ;
    Secondframe()
    {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        t1 = new JTextField(30);
        t2 = new JTextField(30);
        t3 = new JTextField(30);
        s = new JButton("Submit");
        add(t1);
        add(t2);
        add(t3);
        add(s);
        s.addActionListener(this);
	}
	
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()== s)
        {
			System.out.println("Task has been added");
        }
	}
}
	public static void main(String a[]) 
    {
		{         
    {

        Todo j = new Todo();
        j.setVisible(true);
        j.setSize(500,500);

    }
		} 
    }
}
