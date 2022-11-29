import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.*;

import static javax.swing.text.StyleConstants.setIcon;

public class Player extends JLabel{

    private int x=720;
    private int y=740;

    // 플레이어의 위치
    private int Playerx;
    private int Playery;
    private Player player;
    private Poop poop;


    private boolean left;
    private boolean right;

    private ImageIcon character;


    public Player() {
        initObject();
        initSetting();
    }

    private void initObject() {
         character = new ImageIcon("img/main.png");
    }

    private void initSetting() {

        setIcon(character);
        setSize(130, 120);
        setLocation(x,y);
        /*
        Playerx = player.getX();
        Playery = player.getY();

         */

    }
    public void left() {
        System.out.println("left");
        left = true;
        new Thread(()-> {
            while(left) {
                setIcon(character);
                x = x - 30;
                setLocation(x, y);
                try {
                    Thread.sleep(10);
                    left=false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*
                if((Math.abs(x - poop.getX()) < 10 ) &&
                        Math.abs(y - poop.getY()) > 0 && Math.abs(y - poop.getY()) < 50 ) {
                    System.out.println("물방울이 적군과 충돌하였습니다.");
                }
                 */
            }
        }).start();
    }


    public void right() {
        System.out.println("right");
        right = true;
        new Thread(()-> {
            while(right) {
                setIcon(character);
                x = x + 30;
                setLocation(x, y);
                try {
                    Thread.sleep(10);
                    right=false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}