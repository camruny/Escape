
import java.awt.Image;
import javax.swing.ImageIcon;

public class Theme {

    ImageIcon playerPic, enemyPicLeft, enemyPicRight, keyPic, backgroundIcon, doorOpenedImage, doorClosedImage;
    Image backgroundPic;
    GamePanel gameBoard;

    public Theme(ImageIcon p, ImageIcon e, ImageIcon bg) {
        playerPic = new ImageIcon("images/mario/mario1.png");
        enemyPicLeft = new ImageIcon("images/bowser/bowserLeft.png");
        enemyPicRight = new ImageIcon("images/bowser/bowserRight.png");
        keyPic = new ImageIcon("images/key1.png");
        backgroundIcon = new ImageIcon("images/backgrounds/splashScreen.png");
        doorOpenedImage = new ImageIcon("images/doors/door_opened.png");
        doorClosedImage = new ImageIcon("images/doors/door_closed.png");
        gameBoard = new GamePanel(this);
    }

}
