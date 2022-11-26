import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.*;

public class MainFrame extends JFrame{
    Image YTB,LSJ,PJH;
    MainFrameImg mainFrameImg;

    // 생성자
    MainFrame(){
        JLabel title = new JLabel("금쪽이 피하기");  // 게임 타이틀 생성
        JButton StartBtn = new JButton("GameStart");  // GameStart 버튼 생성

        // 게임타이틀 좌표
        title.setLocation(500,300);
        add(title);

        
        // Button 좌표
        StartBtn.setBounds(1030, 700, 480, 90);
        StartBtn.setFont(new Font("Arial", Font.ITALIC, 80));
        add(StartBtn);

        mainFrameImg = new MainFrameImg();
        add(mainFrameImg);
        mainFrameImg = new MainFrameImg();
        add(mainFrameImg);
        mainFrameImg = new MainFrameImg();
        add(mainFrameImg);


        StartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameFrame();
            }
        });

        setTitle("금쪽이 피하기");
        setSize(1600,900);
        setLocationRelativeTo(null);
        setLayout(null);setVisible(true);
    }

}