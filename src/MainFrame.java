
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame{
    int count = 0;

    MainFrame(){

        // TextField
        JTextField tf1 = new JTextField(" Blank");
        tf1.setBounds(250, 150, 150, 30);

        // Button b1
        JButton YTBbutton = new JButton("선택하기");
        JButton LSJbutton = new JButton("선택하기");
        JButton PJHbutton = new JButton("선택하기");
        YTBbutton.setBounds(300, 800, 100, 30);
        LSJbutton.setBounds(800, 800, 100, 30);
        PJHbutton.setBounds(1400, 800, 100, 30);


        add(YTBbutton);
        add(LSJbutton);
        add(PJHbutton);

        setTitle("똥 피하기");
        setSize(1800,1100);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
}


