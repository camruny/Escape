
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StartPanel extends JPanel implements ActionListener, KeyListener{
    GamePanel gp;
    JButton start, theme1, theme2, theme3;
    GamePanel gameBoard;
    Theme chosenTheme;
    
    public StartPanel(){
        
    }
    
    //Needs to be in StartPanel
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj== gameBoard.characterLoop) {
            changeCharacter();
        }
        if(obj == characterLoopLeft)    {
            changeCharacterLeft();
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
}
