import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;

class AddTask extends JFrame{
    JButton submit;
    JLabel enter;
    JTextField task;
    AddTask(){
        setVisible(true);
        setSize(250,350);
        setTitle("Add Task");
        getContentPane().setBackground(Color.darkGray);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        enter = new JLabel("Enter Task");
        enter.setForeground(Color.WHITE);
        task = new JTextField(100);
        submit = new JButton("Submit");
        enter.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        task.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
        submit.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
        add(enter);
        add(task);
        add(submit);
        // s.addActionListener(this)
    }
}
