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

public class Manager extends JFrame{
//  Fields
// ========
    private static Container panels = null;                 //< Buffer de paineis.
    private static String root      = "";                   //< Path absolute.
    private static CardLayout   cards = new CardLayout();

// Build 
// =====
    Manager(String path){ init(path); }

    //Init class
    private void init(String path){
        Manager.root=path;
        panels=getContentPane();
        init_panels();
    }

    // Paineis()
    private void init_panels(){
       panels.add("MAIN",new Gui_main(root)); 
       panels.add("INFO",new Gui_info(root));
       panels.add("DELT",new Gui_Delt(root));
    }

// Methods
// =======
    //! Inicialização
    void start(){ setVisible(true); }
    
    //! Return main menu 
    static void exit(){ cards.show(panels,"MAIN"); }

    //! Move panels
    static void next(String local){ cards.show(panels, local); }
}

