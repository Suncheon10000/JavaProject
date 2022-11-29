import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Poop extends JLabel{

    private static int SPEED = 1;
    // 윤태빈,박주홍,이승제 얼굴 이미지
    private ImageIcon inGameYTB,inGameLSJ,inGamePJH;

    // 박주홍,이승제,윤태빈에 대한 랜덤
    // if rand == 1  -> 윤태빈
    // if rand == 2  -> 이승제
    // if rand == 3  -> 박주홍
    int rand  = (int)((Math.random()*3))+1;
    Boolean GameStatus = true;
    Poop poop;
    private int y;

    private boolean down;
    private Player player;

    // 똥들의 x좌표에 대한 랜드함수
    int xRand = (int)((Math.random()*1600))+1;



    // 생성자
    public Poop() {
        // 이미지 생성을 위한 함수 호출
        initObject();
        SPEED +=0.5;

        // 이미지를 랜덤으로 세팅하는 함수 호출
        initSetting();


        // 테스틍용
        System.out.println(rand);
        System.out.println(xRand);
    }


    // 이미지를 생성
    private void initObject() {
        inGameYTB = new ImageIcon("img/inGameYTB.png");
        inGameLSJ= new ImageIcon("img/inGameLSJ.png");
        inGamePJH = new ImageIcon("img/inGamePJH.png");
    }


    // 이미지를 랜덤위치에 세팅
    private void initSetting() {

        if(rand==1){
            //if(count==1){
            setIcon(inGameYTB);
            setSize(140, 150);
            setLocation(xRand,0);
            System.out.println("YTB");
            //count++;
            //}
        }
        else if(rand==2){

            //else if(count==2){
            setIcon(inGameLSJ);
            setSize(140, 150);
            setLocation(xRand,0);
            System.out.println("LSJ");
            //count++;
            //
            // }
        }
        else if(rand == 3){
            //else if(count==3){
            setIcon(inGamePJH);
            setSize(140, 150);
            setLocation(xRand,0);
            System.out.println("PJH");
            //count=1;
            //}
        }
    }
    // 만들어야 할것
    // 1. 떨어지는거
    // 2. 바닥에 닿으면 사라지는거
    // 3. 캐릭터에 닿으면 게임 종료
    // 솔직히 1만 해결하면 2,3은 가볍게 가능
    // 채종인 화이팅
    public void drop() {
        //System.out.println("down");
        new Thread(()->{
            while(GameStatus) {
                y = y + SPEED;

                setLocation(xRand, y);
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();
    }
    public void hit(){
        if(xRand == player.Playerx && y == player.Playerx){

        }
    }
}