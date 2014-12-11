
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Character extends JLabel{
    JButton character;
    ImageIcon graphic;
    Point location;
    boolean collisionOccurred;
    int speed;
    int DEFAULT_SPEED = 15;
    
    public Character(ImageIcon g, Point i) {
        character = new JButton();
        location = i;
        speed = DEFAULT_SPEED;
        collisionOccurred = false;
        character.setVisible(false);
    }
    
    public void checkCollision(Character char2){
        
        if  (this.location.x < char2.character.getLocation().x + char2.character.getWidth() &&
            (this.location.x + this.character.getWidth()) > char2.character.getLocation().x &&
            this.location.y < char2.character.getLocation().y + char2.character.getHeight() &&
            this.character.getHeight() + this.location.y > char2.character.getLocation().y)
            {
            collisionOccurred = true;
            }
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

