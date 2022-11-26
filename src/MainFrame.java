import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.*;

public class MainFrame{
    Image YTB,LSJ,PJH;

    // 생성자
    MainFrame(){
        JFrame frame = new JFrame();
        JLabel title = new JLabel("금쪽이 피하기");  // 게임 타이틀 생성
        JButton StartBtn = new JButton("GameStart");  // GameStart 버튼 생성

        // 게임타이틀 좌표
        title.setLocation(500,300);
        frame.add(title);

        
        // Button 좌표
        StartBtn.setBounds(1030, 700, 480, 90);
        StartBtn.setFont(new Font("Arial", Font.ITALIC, 80));
        frame.add(StartBtn);

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

        frame.setTitle("금쪽이 피하기");
        frame.setSize(1600,900);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    // 이미지 좌표
    public void paint(Graphics g){
        g.drawImage(YTB,30,110, (ImageObserver) this);
        g.drawImage(LSJ,470,80, (ImageObserver) this);
        g.drawImage(PJH,970,130, (ImageObserver) this);
    }
}