
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cameron
 */
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

