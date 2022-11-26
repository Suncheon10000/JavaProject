import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StopWatchEx extends JFrame{

    JButton start;
    Thread p_display;
    JLabel w1, w2, w3;
    int mm, ss, ms, t=0;

    public StopWatchEx() {
        super("금쪽이 피하기");

        buildGUI();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.pack();
        setSize(1600,900);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        p_display = new Thread(new Runnable() {

            @Override
            public void run() {
                mm = Integer.parseInt(w1.getText());
                ss = Integer.parseInt(w2.getText());
                ms = Integer.parseInt(w3.getText());

                while (p_display == Thread.currentThread()) {
                    mm =  t % (1000*60) / 100 / 60 ;
                    ss = t % (1000*60) / 100 % 60 ;
                    ms = t %100;

                    try {
                        Thread.sleep(10);

                        w1.setText(String.format("%02d", mm));
                        w2.setText(String.format("%02d", ss));
                        w3.setText(String.format("%02d", ms));

                        t++;

                    }catch (InterruptedException e1) {}
                }
            }
        });
        p_display.start();

    }


    private void buildGUI() {
        JPanel p = new JPanel(new BorderLayout());
        JPanel bp = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel wp = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel c1 = new JLabel(" : ");
        JLabel c2 = new JLabel(" : ");
        w1 = new JLabel("00");
        w2 = new JLabel("00");
        w3 = new JLabel("00");


        wp.add(w1);
        wp.add(c1);
        wp.add(w2);
        wp.add(c2);
        wp.add(w3);

        p.add(wp, BorderLayout.CENTER);
        p.add(bp, BorderLayout.SOUTH);
        add(p);



        w1.setFont(new Font("courier",Font.BOLD,30));
        w2.setFont(new Font("courier",Font.BOLD,30));
        w3.setFont(new Font("courier",Font.BOLD,30));

        c1.setFont(new Font("courier",Font.BOLD,30));
        c2.setFont(new Font("courier",Font.BOLD,30));



    }
}
