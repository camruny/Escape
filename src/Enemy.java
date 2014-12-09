import java.awt.Point;
import javax.swing.ImageIcon;

public class Enemy extends Character{
    int speed;
    
    public Enemy(int s, ImageIcon g, Point i){
        super(g, i);
        speed = s;
        this.character.setIcon(g);
    }
    
    public void move(int playerx, int playery){
        if(this.location.x >= playerx)
        {
            this.location.x -= speed;
            this.graphic = new ImageIcon("images/bowser/bowserLeft.png");
        }
        else
        {
            this.location.x += speed;
            this.graphic = new ImageIcon("images/bowser/bowserRight.png");
        }
        if(this.location.y > playery)
        {
            this.location.y -= speed;
        }
        else
        {
            this.location.y += speed;
        }
    }
    
    public void increaseSpeed(){
        speed = speed * 2;
    }
}
