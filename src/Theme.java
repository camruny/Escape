import javax.swing.ImageIcon;

public class Theme {
    ImageIcon playerPic;
    ImageIcon enemyPic;
    ImageIcon backgroundPic;
    
    public Theme(ImageIcon p, ImageIcon e, ImageIcon bg){
        playerPic = new ImageIcon("images/mario/mario1.png");
        enemyPic = new ImageIcon("images/goomba/goomba_LF.png");
        backgroundPic = new ImageIcon("images/backgrounds/");
    }
}
