import javax.swing.ImageIcon;
import javax.swing.JLabel;

import static javax.swing.text.StyleConstants.setIcon;

public class Poop extends JLabel{

    //private int x=720;
    //private int y=720;

    private boolean left;
    private boolean right;

    private ImageIcon inGameYTB,inGameLSJ,inGamePJH;
    static int count = 1;
    static int plus = 20;
    int rand  = (int)((Math.random()*10000%3))+1;



    public Poop() {
        initObject();
        initSetting();
        plus+=20;
        System.out.println(rand);
    }

    private void initObject() {
        inGameYTB = new ImageIcon("img/inGameYTB.png");
        inGameLSJ= new ImageIcon("img/inGameLSJ.png");
        inGamePJH = new ImageIcon("img/inGamePJH.png");
    }

    private void initSetting() {

        if(rand==1){
            //if(count==1){
            setIcon(inGameYTB);
            setSize(140, 150);
            setLocation(200,50+plus);
            System.out.println("YTB");
            //count++;
            //}
        }
        else if(rand==2){

            //else if(count==2){
            setIcon(inGameLSJ);
            setSize(300, 150);
            setLocation(700,50+plus);
            System.out.println("LSJ");
            //count++;
            //
            // }
        }
        else if(rand == 3){
            //else if(count==3){
            setIcon(inGamePJH);
            setSize(140, 150);
            setLocation(1200,50+plus);
            System.out.println("PJH");
            //count=1;
            //}
        }
    }
}