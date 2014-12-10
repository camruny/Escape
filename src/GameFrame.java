
import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.UIManager;

public class GameFrame extends JFrame {
    StartPanel sp;
    
    public GameFrame()   {
        super("Escape");
        
        //Fixes issues with mac displaying background colors.
        try 
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        }catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        sp = new StartPanel();
        getContentPane().setLayout(new BorderLayout());
	getContentPane().add(sp,"South");
        getContentPane().add(sp.gameBoard, "Center");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize (640, 480);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
}
