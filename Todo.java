import java.awt.*;
import javax.swing.*; 
import javax.swing.JTable;
import javax.swing.table.TableModel;
public class Todo extends JFrame  
{ 
	JTable jt;
	JButton jb;
	JScrollPane sp;
	
	Todo()     
	{         
		setSize(500,500);
		setVisible(true);
		setLayout(new GridLayout(2,2,6,6));         
		JMenuBar mb  = new JMenuBar();         
		setJMenuBar(mb);
		JMenu m1  = new JMenu("Add Task");// is for adding a new frame         
		mb.add(m1); 
		String column[] = {"No","Tasks","Done"};
		String data[][]={ 	
						 
					  
			
						};  
		jt = new JTable(data,column);       
		sp =new JScrollPane(jt); 
		add(sp);	


	};
     
		public static void main(String args[])     
		{         
			Todo t = new Todo();         
             
		} 
}
