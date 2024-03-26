/*!*********************************************************
 *  Form 
 * ======
 * @author: Randolfo A Goncalves
 * @since:  09/02/24
 * @file:   Form.java 
 *
 * Classe dedicada para padronização de recursos gui.
************************************************************/

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.LayoutManager;

public class Form{
//  Fields
// ========
    // Color:
    static Color  bg  = Color.DARK_GRAY, //< Background
                  fg  = Color.WHITE;     //< Foreground
    static String clr = "write";         //< Colour

//  Methods
// =========
    static JPanel panel()                              { return factory(new JPanel(   ),false,"");    }
    static JPanel panel(String title)                  { return factory(new JPanel(   ),true, title); }
    static JPanel panel(LayoutManager mng)             { return factory(new JPanel(mng),false,"");    }
    static JPanel panel(String title,LayoutManager mng){ return factory(new JPanel(mng),true, title); }

    //! ( patterns ) - Fabrica de JPanel: 
    private static JPanel factory(JPanel pnl,boolean bord,String title){
        pnl.setBackground(bg);
        if(bord) pnl.setBorder(BorderFactory.createTitledBorder(null, title, 0, 0, null, fg)); 
        return pnl;
    } 
}
