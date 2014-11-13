
import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GameFrame extends JFrame {
    StartPanel sp;
    
    public GameFrame()   {
        super("Escape");
        
        sp = new StartPanel();
        getContentPane().setLayout(new BorderLayout());
	getContentPane().add(sp,"Center");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize (640, 480);
        setVisible(true);
        
    }
    
}
