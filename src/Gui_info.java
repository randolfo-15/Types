/*!*********************************************************
 *  Gui_Data 
 * ==============
 * @author: Randolfo A Goncalves
 * @since:  28/03/24
 * @file:   Gui_Data.java 
 *
 * Classe dedicada para exibição de dados.
************************************************************/
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Container;

public class Gui_info extends Form{
//  Fields
// ========
    private static final int n =8;
    private static JLabel[]  inf  = new JLabel[n];      //< Information 
    private static JLabel  icn  = new JLabel("                              ");    
    private static Font    font = null;                 //< Font 
                                                        //
//  Build
// =======
    Gui_info(String image){ 
        super(image+"windown/note.jpg"); 
        init(image);
    }
    
    private void init(String path){ 
        icn.setHorizontalTextPosition(SwingConstants.LEFT); 
        font = Fonts.create(path+"font/font.ttf",35);
        for(int i=0;i<n;i++) inf[i]=write("");
        plug(icn);
        for(var data:inf) plug(data);
    }


//! Write
    private static JLabel write(String text){
        JLabel inf =new JLabel();
        inf.setFont(font);
        inf.setForeground(Color.BLUE);
        inf.setText(text);
        return inf;
    }

// Getting data 
// ============
    static void get_data(Types type,String path){
        inf[0].setText("     _______________________ Dados ____");
        inf[1].setText("      # Name: "+type.get_name()+" ");
        inf[2].setText("      # Category: "+type.get_category_name()+" ");
        inf[3].setText("      # Ex: "+type.get_example()+" ");
        inf[4].setText("      # Size: "+type.get_size()+" ");
        inf[5].setText("      # Extension: ");
        inf[6].setText("          Min: "+type.get_min()+" ");
        inf[7].setText("          MAx: "+type.get_max()+" ");
        icn.setIcon(new ImageIcon(path));
        Gui_main.next("data");
    }
}
