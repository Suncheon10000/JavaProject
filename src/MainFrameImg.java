import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;


public class MainFrameImg extends JLabel{
    static int num=1;

    private int x;
    private int y;


    public ImageIcon YTB,LSJ,PJH;


    public MainFrameImg() {
        initObject();
        if(num==1){
            YTBSetting();
        }else if(num==2){
            LSJSetting();
        }else if(num==3){
            PJHSetting();
        }
    }

    public void initObject() {
        YTB = new ImageIcon("img/YTB.png");
        LSJ = new ImageIcon("img/LSJ.png");
        PJH = new ImageIcon("img/PJH.png");
    }

    public void YTBSetting() {

        setIcon(YTB);
        setSize(550, 550);
        setLocation(30, 110);
        System.out.println("MainFrameImg.YTBSetting");
        num++;


    }
    public void LSJSetting() {
        setIcon(LSJ);
        setSize(550, 550);
        setLocation(470, 80);
        System.out.println("MainFrameImg.LSJSetting");
        num++;

    }
    private void PJHSetting() {
        setIcon(PJH);
        setSize(550, 550);
        setLocation(970, 130);
        System.out.println("MainFrameImg.PJHSetting");
        num++;


    }


}