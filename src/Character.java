
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
    int DEFAULT_SPEED = 5;
    
    public Character(ImageIcon g, Point i) {
        character = new JButton();
        location = i;
        speed = DEFAULT_SPEED;
        collisionOccurred = false;
        character.setVisible(false);
    }
    
    public void checkCollision(Character char2){
         //Get minimum and maximum values for collision detection
        int minX = this.location.x - this.character.getWidth();
        int maxX = this.location.x + this.character.getWidth();
        int minY = this.location.y - this.character.getHeight();
        int maxY = this.location.y + this.character.getHeight();

        //System.out.println("Width: " + this.character.getWidth() + " Height: " + this.character.getHeight());            System.out.println("Min X: " + minX + " Max X: " + maxX + " Min Y: " + minY + " Max Y: " + maxY);
        //System.out.println("Location of Key X: " + char2.character.getLocation().x + " Location of Key Y: " +  char2.character.getLocation().y);
        //If player touches any of the other objects execute this loop
        if((char2.character.getLocation().x >= minX && 
            char2.character.getLocation().x <= maxX && 
            char2.character.getLocation().y <= maxY && 
            char2.character.getLocation().y >= minY))
        {
            //System.out.println("Collision");
            collisionOccurred = true;
        }
        else
        {
            //System.out.println("No collision!");
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

