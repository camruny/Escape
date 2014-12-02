
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cameron
 */
public class Key extends Character{
    int keysLeft;

    public Key(ImageIcon g, Point i) {
        super(g, i);
        keysLeft = 5;
    }
    
}
