import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
public class todoApp extends JFrame {    
    JMenuBar mainBar;
    JMenu file,theme;
    JMenuItem addTask,displayTask,exit,dark,light;
    JLabel welcome;
    todoApp(){
        /*
        This constructor holds the code for the Main Window Which
        will open when the user runs the program.
        */
        setVisible(true);
        setSize(500,350);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.darkGray);
        
        //Menu Bar Code Starts
        mainBar = new JMenuBar();
        setJMenuBar(mainBar); 
        file = new JMenu("File");
        theme = new JMenu("Theme");
        mainBar.add(file);
        mainBar.add(theme);
        addTask = new JMenuItem("Add Task");
        displayTask = new JMenuItem("Display Tasks");
        exit = new JMenuItem("Exit");
        dark = new JMenuItem("Dark");
        light = new JMenuItem("Light");
        file.add(addTask);
        file.add(displayTask);
        file.add(exit);
        theme.add(light);
        theme.add(dark);
        //MenuBar Code Ends

        //Main Window Code
    }
    
    public static void main(String[] args) {
        new todoApp();
    }
}
