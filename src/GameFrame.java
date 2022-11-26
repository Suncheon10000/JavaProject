import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame {
    private JLabel backgroundMap;
    private Player player;

    static Thread p_display;
    static int mm,ss,ms,t=0;

    JPanel p = new JPanel(new BorderLayout());
    JPanel bp = new JPanel();
    JPanel wp = new JPanel();

    JLabel c1 = new JLabel(" : ");
    JLabel c2 = new JLabel(" : ");
    static JButton start = new JButton("START");
    static JLabel w1 = new JLabel("00");
    static JLabel w2 = new JLabel("00");
    static JLabel w3 = new JLabel("00");

    // 생성자
    GameFrame(){
        super("금쪽이 피하기"); // 게임 페이지 타이틀

        // 시간 GUI

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 함수 호출
        setVisible(true);
        initObject();
        initSetting();
        initListener();
    }
     //배경화면
    private void initObject() {
        backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
        setContentPane(backgroundMap);
        player = new Player();
        add(player);
        setVisible(true);
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








}
