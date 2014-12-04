import java.awt.Point;
import javax.swing.ImageIcon;

public class Enemy extends Character{
    int speed;
    
    public Enemy(int s, ImageIcon g, Point i){
        super(g, i);
        speed = s;
        this.character.setIcon(g);
    }
    
    public void move(){
        
    }
    
    public void increaseSpeed(){
        speed = speed * 2;
    }
}
