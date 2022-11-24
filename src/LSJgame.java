import javax.swing.*;
import java.awt.*;

public class LSJgame extends JFrame {
        LSJgame(){
            super("똥 피하기"); //타이틀
            JPanel jPanel = new JPanel();

            jPanel.setBackground(Color.blue);

            setSize(1800,1100);
            add(jPanel);
            Dimension frameSize = getSize();
            Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
            setLocationRelativeTo(null);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(true);
        }
}
