import java.awt.Image;
import javax.swing.ImageIcon;

public class Theme {
    ImageIcon playerPic, enemyPic;
    ImageIcon backgroundIcon;
    Image backgroundPic;
    GamePanel gameBoard;
    //used by the characterChange loop to move through the 3 player pictures
    
    //adds the player pictures to the JButton
    //ImageIcon mario1 = new ImageIcon("images/mario/mario1.png");
    //ImageIcon mario2 = new ImageIcon("images/mario/mario2.png");
    //ImageIcon mario3 = new ImageIcon("images/mario/mario3.png");
    //ImageIcon mario1left = new ImageIcon("images/mario/mario1left.png");
    //ImageIcon mario2left = new ImageIcon("images/mario/mario2left.png");
    //ImageIcon mario3left = new ImageIcon("images/mario/mario3left.png");
    
    public Theme(ImageIcon p, ImageIcon e, ImageIcon bg){
        playerPic = new ImageIcon("images/mario/mario1-copy.png");
        enemyPic = new ImageIcon("images/goomba/goomba_LF.png");
        backgroundIcon = new ImageIcon("images/backgrounds/halloween.png");
        gameBoard = new GamePanel(this);
    }
    
    public void changeCharacter()    {
        if (gameBoard.player.characterNum == 1){
            //playerPic = new ImageIcon("images/mario/mario1.png");
            System.out.println(gameBoard.player.characterNum);
            gameBoard.player.character.setIcon(playerPic);
            gameBoard.player.characterNum = 2;
            playerPic = new ImageIcon("images/mario/mario2.png");
        }
        if (gameBoard.player.characterNum == 2){
            gameBoard.player.character.setIcon(playerPic);
            System.out.println(gameBoard.player.characterNum);
            gameBoard.player.characterNum = 3;
            playerPic = new ImageIcon("images/mario/mario3.png");
        }
        if (gameBoard.player.characterNum == 3){
            gameBoard.player.character.setIcon(playerPic);
            System.out.println(gameBoard.player.characterNum);
            gameBoard.player.characterNum = 1;
            playerPic = new ImageIcon("images/mario/mario1.png");
        }

        /*changes the image icon of the player to make it appear as if it is walking
        switch(gameBoard.player.characterNum)    {
            case 1:
                System.out.println(gameBoard.player.characterNum);
                gameBoard.player.character.setIcon(playerPic);
                gameBoard.player.changeCharNum();
                playerPic = new ImageIcon("images/mario/mario2.png");
                break;
            case 2:
                gameBoard.player.character.setIcon(playerPic);
                gameBoard.player.changeCharNum();
                playerPic = new ImageIcon("images/mario/mario3.png");
                break;
            case 3:
                gameBoard.player.character.setIcon(playerPic);
                gameBoard.player.changeCharNum();
                playerPic = new ImageIcon("images/mario/mario1.png");
                break;
        }*/
    }
    
    public void changeCharacterLeft()    {
        //changes the image icon of the player to make it appear as if it is walking
        switch(gameBoard.player.characterNum)    {
            case 1:
                gameBoard.player.character.setIcon(playerPic);
                gameBoard.player.characterNum = 2;
                break;
            case 2:
                gameBoard.player.character.setIcon(playerPic);
                gameBoard.player.characterNum = 3;
                break;
            case 3:
                gameBoard.player.character.setIcon(playerPic);
                gameBoard.player.characterNum = 1;
                break;
        }
    }
}
