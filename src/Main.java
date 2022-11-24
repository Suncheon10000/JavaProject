import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.io.File;

public class Main extends JFrame {
    public Main() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image YTB = tk.getImage("img/YTB.png");
        Image LSJ = tk.getImage("img/LSJ.png");
        Image PJH = tk.getImage("img/PJH.png");

        JPanel pn = new JPanel(){
            @Override
            public void paint(Graphics g){
                g.drawImage(YTB, 80, 110, this);
                g.drawImage(LSJ, 570, 95, this);
                g.drawImage(PJH, 1100, 170, this);
            }

        };

        JLabel YTBjLabel = new JLabel("난이도 : 쉬움");
        JLabel LSJjLabel = new JLabel("난이도 : 보통");
        JLabel PJHjLabel = new JLabel("난이도 : 어려움");
        JButton YTBbutton = new JButton("선택");
        JButton LSJbutton = new JButton("선택");
        JButton PJHbutton = new JButton("선택");
        add("Center", pn);
        setTitle("똥 피하기");
        setBounds(0, 0, 1800, 1100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        pn.add(YTBjLabel);
        pn.add(LSJjLabel);
        pn.add(PJHjLabel);
        pn.add(YTBbutton);
        pn.add(LSJbutton);
        pn.add(PJHbutton);

        pn.setVisible(true);

        YTBbutton.setBounds(0,0,130,75);
        LSJbutton.setBounds(600,1000,130,75);
        PJHbutton.setBounds(1100,1000,130,75);

    }
    public static void main(String[] args) {
        new Main();
    }
}

