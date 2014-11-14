
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StartPanel extends JPanel implements ActionListener, KeyListener{
    JButton start, theme1, theme2, theme3;
    GamePanel gameBoard;
    Theme chosenTheme;
    Timer characterLoop, characterLoopLeft, gameTimer;
    
    public StartPanel(){
        start = new JButton("Start");
        theme1 = new JButton("Halloween Theme");
        theme2 = new JButton("Thanksgiving Theme");
        theme3 = new JButton("Christmas Theme");
        
        characterLoop = new Timer(100, this);
        characterLoopLeft = new Timer(100,this);
        gameTimer = new Timer(100, this);
        
        gameBoard.player.character.addKeyListener(this);
        gameBoard.player.character.setFocusable(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == start){
            add(gameBoard.player.character);
            add(gameBoard.key.key);
        }
        if(obj== characterLoop) {
            gameBoard.changeCharacter();
        }
        if(obj == characterLoopLeft)    {
            gameBoard.changeCharacterLeft();
        }
        if(obj == theme1){
            chosenTheme.playerPic = new ImageIcon("images/mario/mario2.png");
            chosenTheme.enemyPic = new ImageIcon("images/goomba/goomba_LF.png");
            chosenTheme.backgroundPic = new ImageIcon("images/backgrounds/halloween.png");
        }
        if(obj == theme2){
            chosenTheme.playerPic = new ImageIcon("images/mario/mario2.png");
            chosenTheme.enemyPic = new ImageIcon("images/goomba/goomba_LF.png");
            chosenTheme.backgroundPic = new ImageIcon("images/backgrounds/halloween.png");
        }
        if(obj == theme3){
            chosenTheme.playerPic = new ImageIcon("images/mario/mario2.png");
            chosenTheme.enemyPic = new ImageIcon("images/goomba/goomba_LF.png");
            chosenTheme.backgroundPic = new ImageIcon("images/backgrounds/halloween.png");
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
            gameBoard.charactery = gameBoard.charactery - 2;
            gameBoard.player.character.setLocation(gameBoard.characterx, gameBoard.charactery);
         }
         if(e.getKeyCode() == KeyEvent.VK_DOWN)    {
            gameTimer.start();
            characterLoop.start();
            gameBoard.charactery = gameBoard.charactery + 2;
            gameBoard.player.character.setLocation(gameBoard.characterx, gameBoard.charactery);
         }
         if(e.getKeyCode() == KeyEvent.VK_LEFT)    {
            gameTimer.start();
            characterLoop.start();
            gameBoard.characterx = gameBoard.characterx - 2;
            gameBoard.player.character.setLocation(gameBoard.characterx, gameBoard.charactery);
         }
         if(e.getKeyCode() == KeyEvent.VK_RIGHT)    {
            gameTimer.start();
            characterLoop.start();
            gameBoard.characterx = gameBoard.characterx + 2;
            gameBoard.player.character.setLocation(gameBoard.characterx, gameBoard.charactery);
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
}
