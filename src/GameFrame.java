
import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cameron
 */
public class GameFrame extends JFrame {
    //Needs to be in StartPanel
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
