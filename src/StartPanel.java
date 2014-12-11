
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class StartPanel extends JPanel implements ActionListener, KeyListener {

    JButton start, theme1, theme2, theme3, restart, close;
    GamePanel gameBoard;
    Theme chosenTheme;
    JProgressBar life;
    GameFrame gf;
    Timer characterLoop, characterLoopLeft, gameTimer;

    public StartPanel() {
        start = new JButton("Start");
        theme1 = new JButton("Halloween Theme");
        theme2 = new JButton("Thanksgiving Theme");
        theme3 = new JButton("Christmas Theme");
        restart = new JButton("Restart");
        close = new JButton("Close");
        chosenTheme = new Theme(new ImageIcon("images/mario/mario1.png"), new ImageIcon("images/bowser/bowser.png"), new ImageIcon("images/backgrounds/halloween.png"));
        gameBoard = new GamePanel(chosenTheme);
        chosenTheme.backgroundPic = chosenTheme.backgroundIcon.getImage();
        life = new JProgressBar(0, 100);
        life.setStringPainted(true);
        life.setString("Health");
        life.setForeground(Color.GREEN);
        characterLoop = new Timer(100, this);
        characterLoopLeft = new Timer(100, this);
        gameTimer = new Timer(100, this);

        gameBoard.player.character.addKeyListener(this);
        gameBoard.player.character.setFocusable(true);
        theme1.addActionListener(this);
        theme2.addActionListener(this);
        theme3.addActionListener(this);
        start.addActionListener(this);
        close.addActionListener(this);
        restart.addActionListener(this);

        add(start);
        add(theme1);
        add(theme2);
        add(theme3);
        add(life);
        add(restart);
        add(close);
        add(gameBoard.keysRemaining);
        gameBoard.keysRemaining.setVisible(false);
        life.setVisible(false);
        start.setVisible(false);
        close.setVisible(false);
        restart.setVisible(false);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            gameTimer.start();
            characterLoop.start();
            if (gameBoard.player.location.y > 5) {
                gameBoard.player.location.y -= gameBoard.player.getSpeed();
            }
            gameBoard.player.character.setLocation(gameBoard.player.location.x, gameBoard.player.location.y);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            gameTimer.start();
            characterLoop.start();
            if (gameBoard.player.location.y > gameBoard.getHeight() - 80) {
                gameBoard.player.location.y -= gameBoard.player.getSpeed();
            }
            gameBoard.player.location.y += gameBoard.player.getSpeed();
            gameBoard.player.character.setLocation(gameBoard.player.location.x, gameBoard.player.location.y);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            gameTimer.start();
            characterLoopLeft.start();
            gameBoard.player.location.x -= gameBoard.player.getSpeed();
            gameBoard.player.character.setLocation(gameBoard.player.location.x, gameBoard.player.location.y);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gameTimer.start();
            characterLoop.start();
            gameBoard.player.location.x += gameBoard.player.getSpeed();
            gameBoard.player.character.setLocation(gameBoard.player.location.x, gameBoard.player.location.y);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            characterLoop.stop();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            characterLoop.stop();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            characterLoopLeft.stop();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            characterLoop.stop();
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == gameTimer) {
            if (life.getValue() >= 66) {
                life.setForeground(Color.GREEN);
            } else if (life.getValue() < 66 && life.getValue() > 33) {
                life.setForeground(Color.YELLOW);
            } else if (life.getValue() < 33 && life.getValue() > 0) {
                life.setForeground(Color.RED);
            } else if (life.getValue() == 0) {
                life.setVisible(false);
                restart.setVisible(true);
                close.setVisible(true);
                gameBoard.keysRemaining.setVisible(false);
                gameBoard.gameTheme.backgroundIcon = new ImageIcon("images/backgrounds/gameOver.png");
                gameBoard.gameTheme.backgroundPic = gameBoard.gameTheme.backgroundIcon.getImage();
                gameBoard.gameLose();

            }

            gameBoard.enemy.move(gameBoard.player.location.x, gameBoard.player.location.y, chosenTheme);
            gameBoard.enemy.character.setLocation(gameBoard.enemy.location.x, gameBoard.enemy.location.y);
            gameBoard.enemy.character.setIcon(gameBoard.enemy.graphic);

            if (gameBoard.player.location.x < 0) {
                gameBoard.player.location.x = gameBoard.getWidth();
            }
            if (gameBoard.player.location.x > gameBoard.getWidth()) {
                gameBoard.player.location.x = 0;
            }

            gameBoard.player.checkCollision(gameBoard.key);
            if (gameBoard.player.collisionOccurred) {
                gameBoard.currentLevel.numberOfKeys--;
                gameBoard.keysRemaining.setText("Keys Remaining: " + gameBoard.currentLevel.numberOfKeys);
                gameBoard.removeKey();
                if (gameBoard.currentLevel.numberOfKeys > 0) {
                    gameBoard.addKey();
                }
                gameBoard.player.collisionOccurred = false;
                if (gameBoard.currentLevel.numberOfKeys == 0) {
                    gameBoard.goal.openDoor();
                } else {
                    gameBoard.goal.closeDoor();
                }
                life.setValue(life.getValue() + 5);
            }

            gameBoard.player.checkCollision(gameBoard.enemy);
            if (gameBoard.player.collisionOccurred) {
                life.setValue(life.getValue() - 8);
                gameBoard.player.collisionOccurred = false;
            }

            gameBoard.player.checkCollision(gameBoard.goal);
            if (gameBoard.player.collisionOccurred) {
                if (gameBoard.currentLevel.numberOfKeys == 0) {
                    gameBoard.levelCompleted();
                    if (gameBoard.currentLevel.name == 4) {

                        life.setVisible(false);
                        restart.setVisible(true);
                        close.setVisible(true);
                        gameBoard.keysRemaining.setVisible(false);
                        gameBoard.gameTheme.backgroundIcon = new ImageIcon("images/backgrounds/gameWin.png");
                        gameBoard.gameTheme.backgroundPic = gameBoard.gameTheme.backgroundIcon.getImage();
                        gameBoard.gameWin();
                    }
                }
                gameBoard.player.collisionOccurred = false;
            }

        }
        if (obj == start) {
            gameBoard.currentLevel.numberOfKeys = 3;
            gameBoard.keysRemaining.setText("Keys Remaining: " + gameBoard.currentLevel.numberOfKeys);
            gameBoard.add(gameBoard.player.character);
            gameBoard.add(gameBoard.enemy.character);
            gameBoard.add(gameBoard.goal.character);
            gameBoard.addKey();
            start.setVisible(false);
            theme1.setVisible(false);
            theme2.setVisible(false);
            theme3.setVisible(false);
            life.setVisible(true);
            life.setValue(100);
            gameBoard.goal.character.setVisible(true);
            gameBoard.player.character.setVisible(true);
            gameBoard.enemy.character.setVisible(false);
            gameBoard.key.character.setVisible(true);
            gameBoard.keysRemaining.setVisible(true);
            gameBoard.player.character.requestFocus();
            gameBoard.repaint();
        }
        if (obj == characterLoop) {
            gameBoard.changeCharacter();
        }
        if (obj == characterLoopLeft) {
            gameBoard.changeCharacterLeft();
        }
        if (obj == restart) {
            Main.main(null);
        }
        if (obj == close) {
            System.exit(0);
        }

        if (obj == theme1) {
            gameBoard.mario1 = new ImageIcon("images/mario/mario1.png");
            chosenTheme.playerPic = new ImageIcon("images/mario/mario1.png");
            chosenTheme.enemyPicLeft = new ImageIcon("images/bowser/bowserLeft.png");
            chosenTheme.enemyPicRight = new ImageIcon("images/bowser/bowserRight.png");
            gameBoard.mario1 = new ImageIcon("images/mario/Mario1.png");
            gameBoard.mario2 = new ImageIcon("images/mario/Mario2.png");
            gameBoard.mario3 = new ImageIcon("images/mario/Mario3.png");
            gameBoard.mario1left = new ImageIcon("images/mario/Mario1left.png");
            gameBoard.mario2left = new ImageIcon("images/mario/Mario2left.png");
            gameBoard.mario3left = new ImageIcon("images/mario/Mario3left.png");
            gameBoard.player.graphic = chosenTheme.playerPic;
            gameBoard.player.character.setIcon(gameBoard.player.graphic);
            gameBoard.player.character.setSize(40, 75);
            gameBoard.enemy.graphic = chosenTheme.enemyPicLeft;
            gameBoard.enemy.character.setIcon(gameBoard.enemy.graphic);
            gameBoard.enemy.character.setSize(70, 56);
            chosenTheme.backgroundIcon = new ImageIcon("images/backgrounds/halloween.png");
            gameBoard.gameTheme.backgroundIcon = new ImageIcon("images/backgrounds/halloween.png");
            gameBoard.gameTheme.backgroundPic = gameBoard.gameTheme.backgroundIcon.getImage();
            gameBoard.keysRemaining.setText("Keys Remaining: " + gameBoard.currentLevel.numberOfKeys);
            start.setVisible(true);
            gameBoard.repaint();
        }
        if (obj == theme2) {
            chosenTheme.playerPic = new ImageIcon("images/mario/mario1.png");
            chosenTheme.enemyPicLeft = new ImageIcon("images/goomba/goomba_LF.png");
            chosenTheme.enemyPicRight = new ImageIcon("images/goomba/goomba_RF.png");
            gameBoard.mario1 = new ImageIcon("images/mario/Mario1.png");
            gameBoard.mario2 = new ImageIcon("images/mario/Mario2.png");
            gameBoard.mario3 = new ImageIcon("images/mario/Mario3.png");
            gameBoard.mario1left = new ImageIcon("images/mario/Mario1left.png");
            gameBoard.mario2left = new ImageIcon("images/mario/Mario2left.png");
            gameBoard.mario3left = new ImageIcon("images/mario/Mario3left.png");
            gameBoard.player.graphic = chosenTheme.playerPic;
            gameBoard.player.character.setIcon(gameBoard.player.graphic);
            gameBoard.player.character.setSize(40, 75);
            gameBoard.enemy.graphic = chosenTheme.enemyPicLeft;
            gameBoard.enemy.graphic = chosenTheme.enemyPicRight;
            gameBoard.enemy.character.setIcon(gameBoard.enemy.graphic);
            gameBoard.enemy.character.setSize(40, 40);
            chosenTheme.backgroundIcon = new ImageIcon("images/backgrounds/bg-thanksgiving.png");
            gameBoard.gameTheme.backgroundIcon = new ImageIcon("images/backgrounds/bg-thanksgiving.png");
            gameBoard.gameTheme.backgroundPic = gameBoard.gameTheme.backgroundIcon.getImage();
            gameBoard.keysRemaining.setText("Keys Remaining: " + gameBoard.currentLevel.numberOfKeys);
            start.setVisible(true);
            gameBoard.repaint();
        }
        if (obj == theme3) {

            chosenTheme.playerPic = new ImageIcon("images/mario/santa_mario/santaMario1right.png");
            chosenTheme.enemyPicLeft = new ImageIcon("images/bowser/santa_bowser/bowserSantaLeft.png");
            chosenTheme.enemyPicRight = new ImageIcon("images/bowser/santa_bowser/bowserSantaRight.png");
            gameBoard.mario1 = new ImageIcon("images/mario/santa_mario/santaMario1right.png");
            gameBoard.mario2 = new ImageIcon("images/mario/santa_mario/santaMario2right.png");
            gameBoard.mario3 = new ImageIcon("images/mario/santa_mario/santaMario3right.png");
            gameBoard.mario1left = new ImageIcon("images/mario/santa_mario/santaMario1left.png");
            gameBoard.mario2left = new ImageIcon("images/mario/santa_mario/santaMario2left.png");
            gameBoard.mario3left = new ImageIcon("images/mario/santa_mario/santaMario3left.png");
            gameBoard.player.graphic = chosenTheme.playerPic;
            gameBoard.player.character.setIcon(gameBoard.player.graphic);
            gameBoard.player.character.setSize(40, 90);
            gameBoard.enemy.graphic = chosenTheme.enemyPicLeft;
            gameBoard.enemy.graphic = chosenTheme.enemyPicRight;
            gameBoard.enemy.character.setIcon(gameBoard.enemy.graphic);
            gameBoard.enemy.character.setSize(70, 80);
            chosenTheme.backgroundIcon = new ImageIcon("images/backgrounds/bg-christmas.png");
            gameBoard.gameTheme.backgroundIcon = new ImageIcon("images/backgrounds/bg-christmas.png");
            gameBoard.gameTheme.backgroundPic = gameBoard.gameTheme.backgroundIcon.getImage();
            gameBoard.keysRemaining.setText("Keys Remaining: " + gameBoard.currentLevel.numberOfKeys);
            start.setVisible(true);
            gameBoard.repaint();
        }
    }
}
