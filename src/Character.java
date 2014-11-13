
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Character extends JLabel{
    JButton character;
    ImageIcon graphic;
    Point location;
    
    public Character(ImageIcon g, Point i) {
        character = new JButton();
        
    }
    
    public void checkCollision(Character char2){
        
    }
}

