/*!*********************************************************
 *  Manager
 * =========
 * @author: Randolfo
 * @since:  19/02/24
 * @file:   Manager.java 
 *
 * Classe dedicada para gestão de paineis
************************************************************/
import java.awt.Container;
import javax.swing.JFrame;
import java.awt.CardLayout;

public class Manager{
//  Fields
// ========
    private static Container panels = null;                 //< Buffer de paineis.
    private static JFrame frame     = new JFrame();         //< Windown.
    private static String root      = "";                   //< Path absolute.
    private static CardLayout   cards = new CardLayout();

// Build 
// =====
    Manager(String path){ init(path); }

    void init(String path){
        Manager.root=path;
        panels=frame.getContentPane();
    }
}
