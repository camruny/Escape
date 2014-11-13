
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
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
    Player player;  
    Level currentLevel;
    ArrayList allChars;
    
    //Not in GamePanel
    Key key;
    
    //used by the characterChange loop to move through the 3 player pictures
    int characterNum = 1;
    //adds the player pictures to the JButton
    ImageIcon mario1 = new ImageIcon("images/mario/mario1.png");
    ImageIcon mario2 = new ImageIcon("images/mario/mario2.png");
    ImageIcon mario3 = new ImageIcon("images/mario/mario3.png");
    ImageIcon mario1left = new ImageIcon("images/mario/mario1left.png");
    ImageIcon mario2left = new ImageIcon("images/mario/mario2left.png");
    ImageIcon mario3left = new ImageIcon("images/mario/mario3left.png");
    
    //adds the key image to the JButton
    ImageIcon keyPic = new ImageIcon("images/key.png");
    
    //default starting position of the player
    int characterx = 100;
    int charactery = 100;
    
    //initializes the key position
    int keyx = 0;
    int keyy = 0;
    
    //counts the keys the user has collected
    int keysCollected = 0;
    
    //timers that loop through 3 player pictures to make them appear they are moving
    Timer characterLoop, characterLoopLeft;
    Timer gameTimer;
        
    public GamePanel(Theme t)  {
        
        setLayout(null);
        
        characterLoop = new Timer(100, this);
        characterLoopLeft = new Timer(100,this);
        gameTimer = new Timer(100, this);
        
        player = new Player();
        player.character.setIcon(mario1);
        player.character.setBorderPainted(false);
        add(player.character);
        player.character.setSize(40, 75);
        player.character.setLocation(characterx, charactery);
        
        player.character.addKeyListener(this);
        player.character.setFocusable(true);
        
        //adds the first key
        addKey();
        
    }
    
    //Does Not Exist In Diagram
    public void changeCharacter()    {
        //changes the image icon of the player to make it appear as if it is walking
        switch(characterNum)    {
            case 1:
                player.character.setIcon(mario1);
                characterNum = 2;
                break;
            case 2:
                player.character.setIcon(mario2);
                characterNum = 3;
                break;
            case 3:
                player.character.setIcon(mario3);
                characterNum = 1;
                break;
        }
    }
    
    public void changeCharacterLeft()    {
        //changes the image icon of the player to make it appear as if it is walking
        switch(characterNum)    {
            case 1:
                player.character.setIcon(mario1left);
                characterNum = 2;
                break;
            case 2:
                player.character.setIcon(mario2left);
                characterNum = 3;
                break;
            case 3:
                player.character.setIcon(mario3left);
                characterNum = 1;
                break;
        }
    }
    
    //Does Not Exist In Diagram
    public void addKey() {
        //puts the key in a random position on the screen 
        Random rand = new Random();
        int randomNum1 = rand.nextInt((600-10)+ 1) + 10;   
        keyx = randomNum1; 
        
        int randomNum2 = rand.nextInt((400-10)+ 1) + 10;   
        keyy = randomNum2; 
        key = new Key();
        key.key.setIcon(keyPic);
        key.key.setSize(20, 42);
        key.key.setBorderPainted(false);
        key.key.setLocation(keyx, keyy);
        add(key.key);
    }

    //Needs to be in StartPanel
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj== characterLoop) {
            changeCharacter();
        }
        if(obj == characterLoopLeft)    {
            changeCharacterLeft();
        }
        if(obj == gameTimer)    {
            if((characterx==keyx)&&(charactery==keyy))   {
                key.key.setVisible(false);
                addKey();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
         if(e.getKeyCode() == KeyEvent.VK_UP)    {
            gameTimer.start();
            characterLoop.start();
            charactery = charactery - 2;
            player.character.setLocation(characterx, charactery);
         }
         if(e.getKeyCode() == KeyEvent.VK_DOWN)    {
            gameTimer.start();
            characterLoop.start();
            charactery = charactery + 2;
            player.character.setLocation(characterx, charactery);
         }
         if(e.getKeyCode() == KeyEvent.VK_LEFT)    {
             gameTimer.start();
            characterLoopLeft.start();
            characterx = characterx - 2;
            player.character.setLocation(characterx, charactery);
         }
         if(e.getKeyCode() == KeyEvent.VK_RIGHT)    {
            gameTimer.start();
            characterLoop.start();
            characterx = characterx + 2;
            player.character.setLocation(characterx, charactery);
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP)    {
            characterLoop.stop();
            gameTimer.stop();
         }
        if(e.getKeyCode() == KeyEvent.VK_DOWN)    {
            characterLoop.stop();
            gameTimer.stop();
         }
        if(e.getKeyCode() == KeyEvent.VK_LEFT)    {
            characterLoopLeft.stop();
            gameTimer.stop();
         }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)    {
            characterLoop.stop();
            gameTimer.stop();
         }
    }
    
    public void levelCompleted(){
        
    }
    
    public void gameWin(){
        
    }
    
    public void gameLose(){
        
    }
    
    public void checkAllCollisions(){
        
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        
    }
}
