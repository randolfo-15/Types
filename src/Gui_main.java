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
    private class Btn extends JButton{ String name; }
    private static List<Btn> btns = new ArrayList<Btn>(); 


//  Build
// =======
    Gui_main(String root){ 
        super(new FlowLayout());
        path_btn=root+"rec/types/";
        Manager.types().forEach(type -> init_buttons(type));
    }
    
    //! Startup Buttons
    void init_buttons(Types type){
        Btn btn = new Btn();
        btn.name=type.get_name();
        btn.setIcon(new ImageIcon(path_btn+type.get_icon())); 
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ Gui_info.get_data(type);}}); 
        btns.add(btn);
        plug(btn);
    }

    //! Remove button:
    static void remove(String name){ btns.forEach(btn ->{ if(btn.name.equals(name)) btn.setVisible(false);}); }
}

