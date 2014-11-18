
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player extends Character{
    int characterNum;
    public Player(ImageIcon g, Point i) {
        super(g, i);
        
    }
    
    public void move(KeyEvent e){
        
    }
    
    public void changeCharNum(){
        characterNum += 1;
        if(characterNum >= 3){
            characterNum = 1;
        }
    }
    
    public void keyPressed(KeyEvent e){
        
    }
}
