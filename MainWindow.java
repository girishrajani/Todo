import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.Color;
import java.awt.Font;

class MainWindow extends JFrame{
    JMenuBar mainBar;
    JMenu functions;
    JMenuItem addTask,displayTask,dark,light;
    JButton welcome,addTaskButton,displayTaskButton,delButton;
    JPanel buttonPanel;
    JLabel blankLable;
    JMenuBar delTaskBar;
    JMenu delete;
    JMenuItem delItem;
    MainWindow(){
/*
        This constructor holds the code for the Main Window Which
        will open when the user runs the program.
        */
        setVisible(true);
        setSize(500,350);
        setTitle("ToDo App");
        setLayout(new BorderLayout());
        // Function to close the operation of JFrame. 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        //Menu Bar Code Starts
        mainBar = new JMenuBar();
        functions = new JMenu("Functions");
        delete = new JMenu("Delete");
        delItem = new JMenuItem("Delete All Tasks");
        delete.add(delItem);
        mainBar.add(functions);
        mainBar.add(delete);
        setJMenuBar(mainBar); 
        addTask = new JMenuItem("Add Task");
        addTask.addActionListener(new EventHandling());
        displayTask = new JMenuItem("Display Tasks");
        displayTask.addActionListener(new EventHandling());
        delItem.addActionListener(new EventHandling());
        functions.add(addTask);
        functions.add(displayTask);
        //MenuBar Code Ends

        //Main Window Code
        welcome = new JButton("Welcome To Your ToDo App");
        welcome.setEnabled(false);
        welcome.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        add(welcome,BorderLayout.NORTH);
        buttonPanel = new JPanel();
        addTaskButton = new JButton("Add Task");
        addTaskButton.addActionListener(new EventHandling());
        displayTaskButton = new JButton("Display Tasks");
        displayTaskButton.addActionListener(new EventHandling());
        delButton = new JButton("Delete All Tasks");
        delButton.addActionListener(new EventHandling());
        buttonPanel.add(addTaskButton);
        buttonPanel.add(displayTaskButton);
        buttonPanel.add(delButton);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.darkGray); //Default Theme for the App set to Dark
        add(buttonPanel,BorderLayout.CENTER);
    }

}
