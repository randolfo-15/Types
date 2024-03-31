/*!*********************************************************
 *  Gui 
 * =====
 * @author: Randolfo A Goncalves
 * @since:  09/02/24
 * @file:   Main.java 
 *
 * Classe dedicada para exibiçaão do programa.
************************************************************/
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.CardLayout;
import java.awt.Container;

public class Gui_main extends Form {
//  Fields
// ========
    private String path_btn=""; //< Path buttons
     
    //! Class suport
    class Btn extends JButton{
        Types  type = null;
        String icon = ""; 
        
        Btn(Types type){ 
            this.type = type;
            this.icon = path_btn+type.get_icon();
            setIcon(new ImageIcon(icon)); 
            setContentAreaFilled(false);
            setBorderPainted(false);
        }
    }

//  Build
// =======
    Gui_main(String root){ 
        super(new FlowLayout());
        path_btn=root+"rec/types/";
        init_buttons(); 
    }

    //! Startup buttons
    void init_buttons(){
        for(var type: Manager.types()) plug(init_buttons(type)); 
    }
    
    //! Startup Buttons
    Btn init_buttons(Types type){
        Btn btn = new Btn(type);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ Gui_info.get_data(btn.type,btn.icon);}}); 
        return btn;
    }
}

