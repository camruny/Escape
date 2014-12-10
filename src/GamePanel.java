
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel{
    Player player;
    Enemy enemy;
    Level currentLevel;
    Goal goal;
    ArrayList<Character> allChars;
    Theme gameTheme;
    JLabel keysRemaining;
    Key key;
    //ImageIcon keyPic = new ImageIcon("images/key1.png");    

    ImageIcon keyPic = new ImageIcon("images/key1.png");
    //ImageIcon doorOpenedImage = new ImageIcon("images/doors/door_opened.png");
    //ImageIcon doorClosedImage = new ImageIcon("images/doors/door_closed.png");
    
    //Not in GamePanel

    //Key doorClosed;
    //Key doorOpened;

    
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
        keysRemaining = new JLabel("Keys Remaining: ");
        player = new Player(gameTheme.playerPic, new Point(50,50));
        Random rand = new Random();
        int randomNum1 = rand.nextInt((600-10)+ 1) + 10;   
        int randomNum2 = rand.nextInt((400-10)+ 1) + 10;  
        enemy = new Enemy(7, gameTheme.enemyPic, new Point(randomNum1, randomNum2));
        currentLevel = new Level(1, 1, 1);
        goal = new Goal(gameTheme.doorClosedImage, new Point(300, 0));
        allChars = new ArrayList<>();
        player.character.setIcon(gameTheme.playerPic);
        enemy.character.setIcon(gameTheme.enemyPic);
        goal.character.setIcon(gameTheme.doorClosedImage);
        //Windows transparency here
        player.character.setOpaque(false);
        player.character.setContentAreaFilled(false);
        //end Windows transparency
        player.character.setBorderPainted(false);
        player.character.setSize(40, 75);
        player.character.setLocation(player.location.x, player.location.y);

        //enemy.character.setLocation(enemy.location.x, enemy.location.y);
        enemy.character.setOpaque(false);
        enemy.character.setContentAreaFilled(false);
        //end Windows transparency
        enemy.character.setBorderPainted(false);
        enemy.character.setSize(70, 56);
        enemy.character.setLocation(enemy.location.x, enemy.location.y);
        
        goal.character.setOpaque(false);
        goal.character.setContentAreaFilled(false);
        //end Windows transparency
        goal.character.setBorderPainted(false);
        goal.character.setSize(70, 56);
        goal.character.setLocation(goal.location.x, goal.location.y);
        //goal.addDoor();
        //goal.closeDoor();
        //add(goal.door.character);
        allChars.add(player);
        allChars.add(enemy);
        allChars.add(key);
        allChars.add(goal);
        
        //adds the doors to the game panel
        //goal.addDoor();
        //goal.closeDoor();
        //add(goal.door.character);
    }
    
    //Does Not Exist In Diagram
    public void addKey(){
        key = new Key(gameTheme.keyPic, new Point(50,50));

        //adds the first key
        addAKey();
        
    }
    
    //Does Not Exist In Diagram
    
    /*
    public void addDoorOpened()   {
        doorOpened = new Key(doorOpenedImage, new Point(50,50));
        doorOpened.character.setIcon(doorOpenedImage);
        doorOpened.character.setSize(50,99);
        doorOpened.character.setLocation(300,0);
        doorOpened.character.setBorderPainted(false);
        doorOpened.character.setVisible(false);
        add(doorOpened.character);
    }
    
    public void addDoorClosed()   {
        doorClosed = new Key(doorClosedImage, new Point(50,50));
        doorClosed.character.setIcon(doorClosedImage);
        doorClosed.character.setSize(50,99);
        doorClosed.character.setLocation(300,0);
        doorClosed.character.setBorderPainted(false);
        doorClosed.character.setVisible(true);
        add(doorClosed.character);
    }
    
    public void openDoor()  {
        doorOpened.character.setVisible(true);
        doorClosed.character.setVisible(false);
    }
    
    public void closeDoor() {
        doorOpened.character.setVisible(false);
        doorClosed.character.setVisible(true);
    }
    */
    //Does Not Exist In Diagram
    public void addAKey() {

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
        key.character.setLocation(-100, -100);
        repaint();
    }
    
    public void levelCompleted(){
        if(currentLevel.name < 3){
            currentLevel.name++;
            goal.closeDoor();
            System.out.println("LEVEL "+ currentLevel.name + "!");
            player.character.setLocation(50,50);
            enemy.character.setLocation(500,50);
            player.location.x = 50;
            player.location.y = 50;
            enemy.location.x = 500;
            enemy.location.y = 50;
            if(currentLevel.name == 2){
                keysRemaining.setText("Keys Remaining: " + currentLevel.numberOfKeys);
                currentLevel.numberOfKeys = 4;
                enemy.speed = 10;
            }else if(currentLevel.name == 3){
                keysRemaining.setText("Keys Remaining: " + currentLevel.numberOfKeys);
                currentLevel.numberOfKeys = 5;
                enemy.speed = 15;
            }
            keysRemaining.setText("Keys Remaining: " + currentLevel.numberOfKeys);
            removeKey();
            addKey();
        }else if(currentLevel.name >= 3){
            gameWin();
        }
    }
    
    public void gameWin(){
        System.out.println("You Win!");
        goal.closeDoor();
        
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
