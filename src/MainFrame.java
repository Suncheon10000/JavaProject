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

        // 선택하기 Button 생성
        JButton YTBbutton = new JButton("선택하기");
        JButton LSJbutton = new JButton("선택하기");
        JButton PJHbutton = new JButton("선택하기");
        add(YTBbutton);
        add(LSJbutton);
        add(PJHbutton);

        // Button 좌표
        YTBbutton.setBounds(180, 800, 100, 30);
        LSJbutton.setBounds(700, 800, 100, 30);
        PJHbutton.setBounds(1300, 800, 100, 30);


        // 이미지 생성
        Container c = getContentPane();
        Toolkit toolkit = frame.getToolkit();
        this.YTB = toolkit.getImage("img/YTB.png");
        this.LSJ = toolkit.getImage("img/LSJ.png");
        this.PJH = toolkit.getImage("img/PJH.png");

        YTBbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new YTBgame();
                setVisible(false); // 창 안보이게 하기
            }
        });
        LSJbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LSJgame();
                setVisible(false); // 창 안보이게 하기
            }
        });
        PJHbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PJHgame();
                setVisible(false); // 창 안보이게 하기
            }
        });


        setTitle("똥 피하기");
        setSize(1700,1000);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    public void paint(Graphics g){
        g.drawImage(YTB,65,110,this);
        g.drawImage(LSJ,530,95,this);
        g.drawImage(PJH,1080,170,this);
    }

}


