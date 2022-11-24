import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.io.File;

public class Main extends JFrame {
    public Main() {
        // 이미지
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image YTB = tk.getImage("img/YTB.png");
        Image LSJ = tk.getImage("img/LSJ.png");
        Image PJH = tk.getImage("img/PJH.png");

        // 이미지 출력
        JPanel pn = new JPanel(){
            @Override
            public void paint(Graphics g){
                g.drawImage(YTB, 80, 110, this);
                g.drawImage(LSJ, 570, 95, this);
                g.drawImage(PJH, 1100, 170, this);
            }

        };
        // 선택하는 버튼
        JPanel jpn = new JPanel();
        JButton YTBbutton = new JButton("선택");
        JButton LSJbutton = new JButton("선택");
        JButton PJHbutton = new JButton("선택");
        
        // Frame의 크기, 위치
        add("Center", pn);
        setTitle("똥 피하기");
        setBounds(0, 0, 1800, 1100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 버튼 추가
        jpn.add(YTBbutton);
        jpn.add(LSJbutton);
        jpn.add(PJHbutton);

        // 버튼의 좌표
        YTBbutton.setBounds(0,0,100,75);
        LSJbutton.setBounds(600,1000,130,75);
        PJHbutton.setBounds(1100,1000,130,75);
        jpn.setVisible(true);

    }
    public static void main(String[] args) {
        new Main();
    }
}

