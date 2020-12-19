import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.Color;
import java.awt.Font;

public class todoApp extends JFrame {    
    JMenuBar mainBar;
    JMenu file,theme;
    JMenuItem addTask,displayTask,exit,dark,light;
    JButton welcome,addTaskButton,displayTaskButton;
    JPanel buttonPanel;
    JLabel blankLable;
    todoApp(){
        /*
        This constructor holds the code for the Main Window Which
        will open when the user runs the program.
        */
        setVisible(true);
        setSize(500,350);
        setLayout(new BorderLayout());
        // Function to close the operation of JFrame. 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
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
        welcome = new JButton("Welcome To Your ToDo App");
        welcome.setEnabled(false);
        welcome.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        add(welcome,BorderLayout.NORTH);
        buttonPanel = new JPanel();
        addTaskButton = new JButton("ADD TASK");
        displayTaskButton = new JButton("Display Tasks");
        buttonPanel.add(addTaskButton);
        buttonPanel.add(displayTaskButton);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.darkGray); //Default Theme for the App
        add(buttonPanel,BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        new todoApp();
    }
}
