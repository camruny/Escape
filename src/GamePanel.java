
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
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

public class GamePanel extends JPanel{
    Player player;
    Level currentLevel;
    ArrayList allChars;
    Theme gameTheme;
    Key key;
    //ImageIcon keyPic = new ImageIcon("images/key1.png");
    
    //Not in GamePanel
    
    
    //adds the key image to the JButton
    //ImageIcon keyPic = new ImageIcon("images/key.png");
    
    //default starting position of the player
    int characterx = 100;
    int charactery = 100;
    
    //initializes the key position
    
    
    //counts the keys the user has collected
    int keysCollected = 0;
    
    //adds the player pictures to the JButton
    ImageIcon mario1 = new ImageIcon("images/mario/mario1.png");
    ImageIcon mario2 = new ImageIcon("images/mario/mario2.png");
    ImageIcon mario3 = new ImageIcon("images/mario/mario3.png");
    ImageIcon mario1left = new ImageIcon("images/mario/mario1left.png");
    ImageIcon mario2left = new ImageIcon("images/mario/mario2left.png");
    ImageIcon mario3left = new ImageIcon("images/mario/mario3left.png");
        
    public GamePanel(Theme t)  {
        
        setLayout(null);
        //characterLoop = new Timer(100, this);
        //characterLoopLeft = new Timer(100,this);
        //gameTimer = new Timer(100, this);
        
        gameTheme = t;
        
        player = new Player(gameTheme.playerPic, new Point(50,50));
        //key = new Key(gameTheme.keyPic, new Point(50,50));
        player.character.setIcon(gameTheme.playerPic);
        //Windows transparency here
        player.character.setOpaque(false);
        player.character.setContentAreaFilled(false);
        //end Windows transparency
        player.character.setBorderPainted(false);
        add(player.character);
        player.character.setSize(40, 75);
        player.character.setLocation(player.location.x, player.location.y);
        
    }
    
    //Does Not Exist In Diagram
    public void addKey(){
        key = new Key(gameTheme.keyPic, new Point(50,50));
        //puts the key in a random position on the screen 
        Random rand = new Random();
        int randomNum1 = rand.nextInt((600-10)+ 1) + 10;   
        key.keyx = randomNum1; 
        
        int randomNum2 = rand.nextInt((400-10)+ 1) + 10;   
        key.keyy = randomNum2; 
        key.character.setIcon(key.graphic);
        key.character.setSize(20, 42);
        //Windows transparency
        key.character.setOpaque(false);
        key.character.setContentAreaFilled(false);
        //end Windows transparency
        key.character.setBorderPainted(false);
        key.character.setLocation(key.keyx, key.keyy);
        add(key.character);
        key.character.setVisible(true);
        System.out.println("Add key called.");
    }
    
    public void removeKey(){
        this.remove(key.character);
        addKey();
        repaint();
    }
    
    public void levelCompleted(){
        
    }
    
    public void gameWin(){
        System.out.println("You Win!");
    }
    
    public void gameLose(){
        
    }
    
    public void checkAllCollisions(){
        
    }
    
    public void keyPressed(KeyEvent e){
        
    }
    
    public void changeCharacter()    {
        if (player.characterNum == 1){
            player.character.setIcon(mario1);
            player.characterNum = 2;
        }
        else if (player.characterNum == 2){
            player.character.setIcon(mario2);
            player.characterNum = 3;
        }
        else if (player.characterNum == 3){
            player.character.setIcon(mario3);
            player.characterNum = 1;
        }
    }
    
    public void changeCharacterLeft()    {
        //changes the image icon of the player to make it appear as if it is walking
        if (player.characterNum == 1){
            player.character.setIcon(mario1left);
            player.characterNum = 2;
        }
        else if (player.characterNum == 2){
            player.character.setIcon(mario2left);
            player.characterNum = 3;
        }
        else if (player.characterNum == 3){
            player.character.setIcon(mario3left);
            player.characterNum = 1;
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(gameTheme.backgroundPic, 0, 0, this);
    }
}
