
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
    Key key;
    int characterNum = 1;
    ImageIcon mario1 = new ImageIcon("images/mario/mario1.png");
    ImageIcon mario2 = new ImageIcon("images/mario/mario2.png");
    ImageIcon mario3 = new ImageIcon("images/mario/mario3.png");
    ImageIcon mario1left = new ImageIcon("images/mario/mario1left.png");
    ImageIcon mario2left = new ImageIcon("images/mario/mario2left.png");
    ImageIcon mario3left = new ImageIcon("images/mario/mario3left.png");
    
    ImageIcon keyPic = new ImageIcon("images/key.png");
    
    int characterx = 100;
    int charactery = 100;
    
    int keyx = 100;
    int keyy = 100;
    
    
    Timer characterLoop, characterLoopLeft;
    Timer moveCharacter;
        
    public GamePanel()  {
        
        setLayout(null);
        
        characterLoop = new Timer(100, this);
        characterLoopLeft = new Timer(100,this);
        moveCharacter = new Timer(100, this);
        
        character = new Character();
        character.character.setIcon(mario1);
        character.character.setBorderPainted(false);
        add(character.character);
        character.character.setSize(40, 75);
        character.character.setLocation(characterx, charactery);
        
        character.character.addKeyListener(this);
        character.character.setFocusable(true);
        
        key = new Key();
        key.key.setIcon(keyPic);
        key.key.setSize(20, 42);
        key.key.setBorderPainted(false);
        key.key.setLocation(keyx, keyy);
        add(key.key);
        
         
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
    
    public void changeCharacterLeft()    {
        //changes the image icon of the character to make it appear as if it is walking
        switch(characterNum)    {
            case 1:
                character.character.setIcon(mario1left);
                characterNum = 2;
                break;
            case 2:
                character.character.setIcon(mario2left);
                characterNum = 3;
                break;
            case 3:
                character.character.setIcon(mario3left);
                characterNum = 1;
                break;
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj== characterLoop) {
            changeCharacter();
        }
        if(obj == characterLoopLeft)    {
            changeCharacterLeft();
        }
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
            characterLoopLeft.start();
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
            characterLoopLeft.stop();
         }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)    {
            characterLoop.stop();
         }
    }
    
}
