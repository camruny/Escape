
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cameron
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    Character character;   
    int characterNum = 1;
    ImageIcon mario1 = new ImageIcon("images/mario/mario1.png");
    ImageIcon mario2 = new ImageIcon("images/mario/mario2.png");
    ImageIcon mario3 = new ImageIcon("images/mario/mario3.png");
    
    int characterx = 100;
    int charactery = 100;
    
    Timer characterLoop;
    Timer moveCharacter;
        
    public GamePanel()  {
        
        setLayout(null);
        
        characterLoop = new Timer(100, this);
        moveCharacter = new Timer(100, this);
        
        character = new Character();
        character.character.setIcon(mario1);
        character.character.setBorderPainted(false);
        add(character.character);
        character.character.setSize(40, 75);
        character.character.setLocation(characterx, charactery);
        
        character.character.addKeyListener(this);
        character.character.setFocusable(true);
         
    }
    
    public void changeCharacter()    {
        //changes the image icon of the character to make it appear as if it is walking
        switch(characterNum)    {
            case 1:
                character.character.setIcon(mario1);
                characterNum = 2;
                break;
            case 2:
                character.character.setIcon(mario2);
                characterNum = 3;
                break;
            case 3:
                character.character.setIcon(mario3);
                characterNum = 1;
                break;
        }
    }

    public void actionPerformed(ActionEvent e) {
        changeCharacter();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
         if(e.getKeyCode() == KeyEvent.VK_UP)    {
            characterLoop.start();
            charactery = charactery - 5;
            character.character.setLocation(characterx, charactery);
         }
         if(e.getKeyCode() == KeyEvent.VK_DOWN)    {
            characterLoop.start();
            charactery = charactery + 5;
            character.character.setLocation(characterx, charactery);
         }
         if(e.getKeyCode() == KeyEvent.VK_LEFT)    {
            characterLoop.start();
            characterx = characterx - 5;
            character.character.setLocation(characterx, charactery);
         }
         if(e.getKeyCode() == KeyEvent.VK_RIGHT)    {
            characterLoop.start();
            characterx = characterx + 5;
            character.character.setLocation(characterx, charactery);
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP)    {
            characterLoop.stop();
         }
        if(e.getKeyCode() == KeyEvent.VK_DOWN)    {
            characterLoop.stop();
         }
        if(e.getKeyCode() == KeyEvent.VK_LEFT)    {
            characterLoop.stop();
         }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)    {
            characterLoop.stop();
         }
    }
    
}
