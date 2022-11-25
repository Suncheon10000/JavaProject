import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame{
    Image YTB;
    Image LSJ;
    Image PJH;
    
    // 생성자
    MainFrame(){
        JFrame frame = new JFrame();
        JPanel imgPanel = new JPanel();
        JPanel StartPanel = new JPanel();
        JLabel title = new JLabel("금쪽이 피하기");
        
        // 게임타이틀 좌표
        title.setSize(80,30);
        title.setLocation(0,0);
        add(title);


        // 선택하기 Button 생성
        JButton StartBtn = new JButton("GameStart");

        // Button 좌표
        StartBtn.setBounds(1030, 700, 480, 90);
        StartBtn.setFont(new Font("Arial", Font.ITALIC, 80));

        add(StartBtn);

        // 이미지 생성
        Toolkit toolkit = frame.getToolkit();
        this.YTB = toolkit.getImage("img/YTB.png");
        this.LSJ = toolkit.getImage("img/LSJ.png");
        this.PJH = toolkit.getImage("img/PJH.png");


        StartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameFrame();
            }
        });

        setTitle("똥 피하기");
        setSize(1600,900);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    
    
    // 이미지 좌표
    public void paint(Graphics g){
        g.drawImage(YTB,30,110,this);
        g.drawImage(LSJ,470,80,this);
        g.drawImage(PJH,970,130,this);
    }
}


