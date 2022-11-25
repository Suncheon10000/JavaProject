import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame {
    private JLabel backgroundMap;
    private Player player;
    int mm,ss, ms, t=0;
    JButton start;
    JLabel w1,w2,w3;
    Thread p_display;

    // 생성자
    GameFrame(){
        super("똥 피하기"); //타이틀
        JPanel jPanel = new JPanel();

        jPanel.setBackground(Color.GREEN);

        // 시간 GUI
        buildGUI();

        add(jPanel);
        Dimension frameSize = getSize();
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 함수 호출
        setVisible(true);
        initObject();
        initSetting();
        initListener();
    }
    
    // 배경화면
    private void initObject() {
        backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
        setContentPane(backgroundMap);
        player = new Player();
        add(player);
    }
    
    // Frame 설정
    private void initSetting() {
        setSize(1600,900);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 방향키 조절
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


    // 시간 스톱워치 화면 GUI
    public void buildGUI() {
        JPanel p = new JPanel(new BorderLayout());
        JPanel bp = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel wp = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel c1 = new JLabel(" : ");
        JLabel c2 = new JLabel(" : ");
        w1 = new JLabel("00");
        w2 = new JLabel("00");
        w3 = new JLabel("00");

        JButton start = new JButton("START");
        bp.add(start);
        wp.add(w1);
        wp.add(c1);
        wp.add(w2);
        wp.add(c2);
        wp.add(w3);



        start.setFont(new Font("serif",Font.BOLD,25));

        w1.setFont(new Font("courier",Font.BOLD,30));
        w2.setFont(new Font("courier",Font.BOLD,30));
        w3.setFont(new Font("courier",Font.BOLD,30));

        c1.setFont(new Font("courier",Font.BOLD,30));
        c2.setFont(new Font("courier",Font.BOLD,30));
        p.add(wp, BorderLayout.CENTER);
        p.add(bp, BorderLayout.SOUTH);
        p.setBounds(0,0,30,30);
        add(p);
        setVisible(true);
        new ButtonListener();
        System.out.println("-------------------게임 시작-------------------");

    }

    // start를 눌렀을때 시간이 자동으로 1초,2초,3초 ...
    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            start.setEnabled(false);
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
    }





}
