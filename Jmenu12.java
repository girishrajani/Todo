import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
public class Jmenu12 extends JFrame implements MenuListener 
{
    JMenu m1;
    String msg;
Jmenu12()
    {
        setLayout(new FlowLayout());
        JMenuBar mb  = new JMenuBar();
        setJMenuBar(mb);
         m1  = new JMenu("File");// is for adding a new frame 
        mb.add(m1);
        
        mb.add(m1);
        
    }
    
    public static void main(String a[])
    {
        Jmenu12 j = new Jmenu12();
        j.setVisible(true);
        j.setSize(500,500);
        
    }
}