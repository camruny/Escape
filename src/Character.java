
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Character extends JLabel{
    JButton character;
    ImageIcon graphic;
    Point location;
    int speed;
    int DEFAULT_SPEED = 5;
    
    public Character(ImageIcon g, Point i) {
        character = new JButton();
        location = i;
        speed = DEFAULT_SPEED;
    }
    
    public void checkCollision(Character char2){
        
    }
    
    public void setSpeed(int i)
    {
        speed = i;
    }
    public int getSpeed()
    {
        return speed;
    }
}

