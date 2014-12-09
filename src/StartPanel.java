
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StartPanel extends JPanel implements ActionListener, KeyListener{
    JButton start, theme1, theme2, theme3;
    JLabel keysRemaining;
    GamePanel gameBoard;
    Theme chosenTheme;
    Timer characterLoop, characterLoopLeft, gameTimer;
    
    public StartPanel(){
        start = new JButton("Start");
        theme1 = new JButton("Halloween Theme");
        theme2 = new JButton("Thanksgiving Theme");
        theme3 = new JButton("Christmas Theme");
        keysRemaining = new JLabel("Keys Remaining: ");
        chosenTheme = new Theme(new ImageIcon("images/mario/mario1.png"), new ImageIcon("images/bowser/bowser.png"), new ImageIcon("images/backgrounds/halloween.png"));
        gameBoard = new GamePanel(chosenTheme);
        chosenTheme.backgroundPic = chosenTheme.backgroundIcon.getImage();

        characterLoop = new Timer(100, this);
        characterLoopLeft = new Timer(100,this);
        gameTimer = new Timer(100, this);
        
        gameBoard.player.character.addKeyListener(this);
        gameBoard.player.character.setFocusable(true);
        theme1.addActionListener(this);
        theme2.addActionListener(this);
        theme3.addActionListener(this);
        start.addActionListener(this);
        
        add(start);
        add(theme1);
        add(theme2);
        add(theme3);
        add(keysRemaining);
        keysRemaining.setVisible(false);
        
        repaint();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
         if(e.getKeyCode() == KeyEvent.VK_UP)    {
            gameTimer.start();
            characterLoop.start();
            gameBoard.player.location.y -= gameBoard.player.getSpeed();
            gameBoard.player.character.setLocation(gameBoard.player.location.x, gameBoard.player.location.y);
         }
         if(e.getKeyCode() == KeyEvent.VK_DOWN)    {
            gameTimer.start();
            characterLoop.start();
            gameBoard.player.location.y += gameBoard.player.getSpeed();
            gameBoard.player.character.setLocation(gameBoard.player.location.x, gameBoard.player.location.y);
         }
         if(e.getKeyCode() == KeyEvent.VK_LEFT)    {
            gameTimer.start();
            characterLoopLeft.start();
            gameBoard.player.location.x -= gameBoard.player.getSpeed();
            gameBoard.player.character.setLocation(gameBoard.player.location.x, gameBoard.player.location.y);
         }
         if(e.getKeyCode() == KeyEvent.VK_RIGHT)    {
            gameTimer.start();
            characterLoop.start();
            gameBoard.player.location.x += gameBoard.player.getSpeed();
            gameBoard.player.character.setLocation(gameBoard.player.location.x, gameBoard.player.location.y);
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
    
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == gameTimer)
        {
            //gameBoard.player.checkCollision(gameBoard.key);
            
            gameBoard.player.checkCollision(gameBoard.key);
            //gameBoard.player.checkCollision(gameBoard.enemy);
            if(gameBoard.player.collisionOccurred){
                gameBoard.player.keysLeft--;
                keysRemaining.setText("Keys Remaining: " + gameBoard.player.keysLeft);
                gameBoard.removeKey();
                gameBoard.player.collisionOccurred = false;
                if(gameBoard.player.keysLeft == 0){
                    gameBoard.gameWin();
                    gameBoard.openDoor();
                }
            }
            
            gameBoard.player.checkCollision(gameBoard.enemy);
            if(gameBoard.player.collisionOccurred){
                System.out.println("Ahhh bowser");
                gameBoard.player.collisionOccurred = false;
            }
            
            
        }
        if(obj == start){
            gameBoard.player.keysLeft = 5;
            keysRemaining.setText("Keys Remaining: " + gameBoard.player.keysLeft);
            gameBoard.add(gameBoard.player.character);
            gameBoard.add(gameBoard.enemy.character);
            gameBoard.addKey();
            start.setVisible(false);
            theme1.setVisible(false);
            theme2.setVisible(false);
            theme3.setVisible(false);
            gameBoard.player.character.setVisible(true);
            gameBoard.enemy.character.setVisible(true);
            gameBoard.key.character.setVisible(true);
            keysRemaining.setVisible(true);
            gameBoard.player.character.requestFocus();
            gameBoard.repaint();
        }
        if(obj == characterLoop){
            gameBoard.changeCharacter();
        }
        if(obj == characterLoopLeft){
            gameBoard.changeCharacterLeft();
        }
        if(obj == theme1){
            gameBoard.mario1 = new ImageIcon("images/mario/mario1.png");
            chosenTheme.playerPic = new ImageIcon("images/mario/mario1.png");
            chosenTheme.enemyPic = new ImageIcon("images/bowser/bowserRight.png");
            chosenTheme.backgroundIcon = new ImageIcon("images/backgrounds/halloween.png");
            gameBoard.gameTheme.backgroundIcon = new ImageIcon("images/backgrounds/halloween.png");
            gameBoard.gameTheme.backgroundPic = gameBoard.gameTheme.backgroundIcon.getImage();
            gameBoard.player.keysLeft = 5;
            keysRemaining.setText("Keys Remaining: " + gameBoard.player.keysLeft);
            gameBoard.repaint();
        }
        if(obj == theme2){
            chosenTheme.playerPic = new ImageIcon("images/mario/mario1.png");
            chosenTheme.enemyPic = new ImageIcon("images/goomba/goomba_LF.png");
            chosenTheme.backgroundIcon = new ImageIcon("images/backgrounds/bg-thanksgiving.png");
            gameBoard.gameTheme.backgroundIcon = new ImageIcon("images/backgrounds/bg-thanksgiving.png");
            gameBoard.gameTheme.backgroundPic = gameBoard.gameTheme.backgroundIcon.getImage();
            gameBoard.player.keysLeft = 5;
            keysRemaining.setText("Keys Remaining: " + gameBoard.player.keysLeft);
            gameBoard.repaint();
        }
        if(obj == theme3){
            chosenTheme.playerPic = new ImageIcon("images/mario/mario1.png");
            chosenTheme.enemyPic = new ImageIcon("images/bowser/.png");
            chosenTheme.backgroundIcon = new ImageIcon("images/backgrounds/");
            gameBoard.gameTheme.backgroundIcon = new ImageIcon("images/backgrounds/bg-christmas.png");
            gameBoard.gameTheme.backgroundPic = gameBoard.gameTheme.backgroundIcon.getImage();
            gameBoard.player.keysLeft = 5;
            keysRemaining.setText("Keys Remaining: " + gameBoard.player.keysLeft);
            gameBoard.repaint();
        }
    }
}
