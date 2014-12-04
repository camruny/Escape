import java.awt.Image;
import javax.swing.ImageIcon;

public class Theme {
    ImageIcon playerPic, enemyPic, keyPic;
    ImageIcon backgroundIcon;
    Image backgroundPic;
    GamePanel gameBoard;
    
    public Theme(ImageIcon p, ImageIcon e, ImageIcon bg){
        playerPic = new ImageIcon("images/mario/mario1.png");
        enemyPic = new ImageIcon("images/goomba/goomba_LF.png");
        keyPic = new ImageIcon("images/key1.png");
        backgroundIcon = new ImageIcon("images/backgrounds/halloween.png");
        gameBoard = new GamePanel(this);
    }
    
}
