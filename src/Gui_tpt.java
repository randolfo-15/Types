/*!*********************************************************
 *  Gui_template 
 * ==============
 * @author: Randolfo
 * @since:  09/02/24
 * @file:   Gui_tpt.java 
 *
 * Classe dedicada para padronização de recursos gui.
************************************************************/

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_tpt{
//  Fields
// ========
    // Color:
    static Color  bg  = Color.DARK_GRAY, //< Background
                  fg  = Color.WHITE;     //< Foreground
    static String clr = "write";         //< Colour
    // Path:
    private static String images = ""; 

//  Build
// =======
    Gui_tpt(String path){ images=path; }

    static JPanel btn_exit(){
        JButton btn = Btn.template("",bg);
        btn.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){exit();}});
        JPanel panel =new JPanel();
        panel.add(btn);
        return panel;
    }

    static void exit(){}
}
