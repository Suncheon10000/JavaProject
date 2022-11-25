import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame{
    Image YTB;
    Image LSJ;
    Image PJH;
    MainFrame(){
        JFrame frame = new JFrame();
        JPanel imgPanel = new JPanel();
        JPanel StartPanel = new JPanel();
        JLabel title = new JLabel();

        // 선택하기 Button 생성
        JButton StartBtn = new JButton("GameStart");
        add(StartBtn);

        // Button 좌표
        StartBtn.setBounds(1030, 700, 480, 90);
        StartBtn.setFont(new Font("Arial", Font.ITALIC, 80));



        // 이미지 생성
        Toolkit toolkit = frame.getToolkit();
        this.YTB = toolkit.getImage("img/YTB.png");
        this.LSJ = toolkit.getImage("img/LSJ.png");
        this.PJH = toolkit.getImage("img/PJH.png");


        StartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameFrame();
                setVisible(false); // 창 안보이게 하기
            }
        });

        setTitle("똥 피하기");
        setSize(1600,900);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    public void paint(Graphics g){
        g.drawImage(YTB,30,110,this);
        g.drawImage(LSJ,470,80,this);
        g.drawImage(PJH,970,130,this);
    }

}


