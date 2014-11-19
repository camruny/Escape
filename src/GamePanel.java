
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
    ImageIcon keyPic = new ImageIcon("images/key.png");
    
    //Not in GamePanel
    Key key;
    
    //adds the key image to the JButton
    //ImageIcon keyPic = new ImageIcon("images/key.png");
    
    //default starting position of the player
    int characterx = 100;
    int charactery = 100;
    
    //initializes the key position
    int keyx = 0;
    int keyy = 0;
    
    //counts the keys the user has collected
    int keysCollected = 0;
        
    public GamePanel(Theme t)  {
        
        setLayout(null);
        //characterLoop = new Timer(100, this);
        //characterLoopLeft = new Timer(100,this);
        //gameTimer = new Timer(100, this);
        
        gameTheme = t;
        
        player = new Player(gameTheme.playerPic, new Point(50,50));
        player.character.setIcon(gameTheme.playerPic);
        //Windows transparency here
        player.character.setOpaque(false);
        player.character.setContentAreaFilled(false);
        //end Windows transparency
        player.character.setBorderPainted(false);
        add(player.character);
        player.character.setSize(40, 75);
        player.character.setLocation(player.location.x, player.location.y);
        
        //adds the first key
        addKey();
        
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(gameTheme.backgroundPic, 0, 0, this);
    }
    
    //Does Not Exist In Diagram
    
    //Does Not Exist In Diagram
    public void addKey() {
        //puts the key in a random position on the screen 
        Random rand = new Random();
        int randomNum1 = rand.nextInt((600-10)+ 1) + 10;   
        keyx = randomNum1; 
        
        int randomNum2 = rand.nextInt((400-10)+ 1) + 10;   
        keyy = randomNum2; 
        key = new Key(keyPic, new Point(50,50));
        key.key.setIcon(keyPic);
        key.key.setSize(20, 42);
        //Windows transparency
        key.key.setOpaque(false);
        key.key.setContentAreaFilled(false);
        //end Windows transparency
        key.key.setBorderPainted(false);
        key.key.setLocation(keyx, keyy);
        add(key.key);
    }
    
    public void levelCompleted(){
        
    }
    
    public void gameWin(){
        
    }
    
    public void gameLose(){
        
    }
    
    public void checkAllCollisions(){
        
    }
    
    public void keyPressed(KeyEvent e){
        
    }
}
