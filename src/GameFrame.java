import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import static javax.swing.text.StyleConstants.setIcon;

public class GameFrame extends JFrame{

    JButton start;
    Thread p_display;
    static int count = 0;
    JLabel w1, w2, w3;
    int mm, ss, ms, t=0;

    private ImageIcon inGameYTB,inGameLSJ,inGamePJH;

    private JLabel backgroundMap;
    Boolean GameStatus = true;
    private Player player;
    private Poop poop;

    public GameFrame() {
        super("금쪽이 피하기");

        buildGUI();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.pack();
        setSize(1600,1000);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        // 함수 호출
        initObject();
        initSetting();
        initListener();

        // GameStart버튼을 누르면 자동으로 스톱워치 시작
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
    private void initObject() {
        //backgroundMap = new JLabel(new ImageIcon("img/img.png"));
        //setContentPane(backgroundMap);

        // 박주홍 머리 있는거 방향키로 이동하는 캐릭터
        player = new Player();
        add(player);

        // 똥 == 윤태빈,이승제,박주홍 얼굴들을 랜덤으로 생성
        // 반복문을 어떻게 해야할 지 몰라서 일단 노가다로 하나씩 다 만들었습니다
        new Thread(()-> {
            while(GameStatus) {
                poop = new Poop();
                poop.drop();
                add(poop);
                try {
                    Thread.sleep(400-count);
                    if(count==100){
                        count=101;
                    }else{
                    count+=1;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
        /*
        poop = new Poop();
        poop.drop();
        add(poop);
        poop = new Poop();
        poop.drop();
        add(poop);
        poop = new Poop();
        poop.drop();
        add(poop);
        poop = new Poop();
        poop.drop();
        add(poop);
        poop = new Poop();
        poop.drop();
        add(poop);
        poop = new Poop();
        poop.drop();
        add(poop);
        poop = new Poop();
        poop.drop();
        add(poop);
        poop = new Poop();
        poop.drop();
        add(poop);
        poop = new Poop();
        poop.drop();
        add(poop);
        poop = new Poop();
        poop.drop();
        add(poop);
        poop = new Poop();
        poop.drop();
        add(poop);
        poop = new Poop();
        poop.drop();
        add(poop);
        poop = new Poop();
        poop.drop();
        add(poop);

         */

        // 이건 테스트용
    }

    private void initSetting() {
        setSize(1600,900);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        player.left();
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.right();
                        break;
                }
            }
        });
    }




}