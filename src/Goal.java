
import java.awt.Point;
import javax.swing.ImageIcon;

public class Goal extends Character{
    Key door;
    public Goal(ImageIcon g, Point i) {
        super(g, i);
        this.graphic = g;
        door = new Key(this.graphic, new Point(300,0));
    }
    
    public void addDoor()   {
        door = new Key(this.graphic, new Point(50,50));
        door.character.setIcon(this.graphic);
        door.character.setSize(50,99);
        door.character.setLocation(300,0);
        door.character.setBorderPainted(false);
        door.character.setContentAreaFilled(false);
        door.character.setVisible(true);
    }

    public void openDoor()  {
        door.character.setIcon(new ImageIcon("images/doors/door_opened.png"));
    }

    public void closeDoor() {
        door.character.setIcon(new ImageIcon("images/doors/door_closed.png"));
    }
}
