import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel{

    private int x=800;
    private int y=750;

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
        setSize(110, 110);
        setLocation(x,y);
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