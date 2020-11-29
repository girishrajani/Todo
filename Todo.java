import java.awt.*; 
import javax.swing.*; 
public class Todo extends JFrame  
{ 
	Todo()     
	{         
		setSize(500,500);
		setVisible(true);
		setLayout(new FlowLayout());         
		JMenuBar mb  = new JMenuBar();         
		setJMenuBar(mb);         
		JMenu m1  = new JMenu("Add Task");// is for adding a new frame         
		mb.add(m1);      
	}     
		public static void main(String args[])     
		{         
			Todo t = new Todo();         
             
		} 
}
