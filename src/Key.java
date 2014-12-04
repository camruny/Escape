
import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Key extends Character{
    int keysLeft;
    int keyx = 0;
    int keyy = 0;

    public Key(ImageIcon g, Point i) {
        super(g, i);
        keysLeft = 5;
        this.graphic = new ImageIcon("images/key1.png");
    }
    /*
    public void addKey() {
        //puts the key in a random position on the screen 
        Random rand = new Random();
        int randomNum1 = rand.nextInt((600-10)+ 1) + 10;   
        keyx = randomNum1; 
        
        int randomNum2 = rand.nextInt((400-10)+ 1) + 10;   
        keyy = randomNum2; 
        this.character.setIcon(graphic);
        this.character.setSize(20, 42);
        //Windows transparency
        this.character.setOpaque(false);
        this.character.setContentAreaFilled(false);
        //end Windows transparency
        this.character.setBorderPainted(false);
        this.character.setLocation(keyx, keyy);
        add(this.character);
        System.out.println("Add key called.");
    }*/
    
}
