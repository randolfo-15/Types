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
import java.awt.FlowLayout;

public class Gui_info extends Form{
//  Fields
// ========
    private static JLabel 
        inf = new JLabel(), //< Informations
        icn = new JLabel(); //< Icon

    //  Build
// =======
    Gui_info(String image){ 
        super(image,new FlowLayout()); 
        plug(icn);
        plug(inf);
    }

    static void get_data(Types type,String path){
        inf.setText(
        "<html>"
            +"<br><br>"
            +"<div style=\"color: blue\">"
                +"<table>"
                    +"<td>"
                    +"<tr><h1><u>"+type.get_name()+"</u></h1></tr>"
                    +"<tr>Category: "+type.get_category_name()+"</tr>"
                    +"<tr>Ex: "+type.get_example()+"</tr>"
                    +"<tr>Size: "+type.get_size()+"</tr>"
                    +"<tr>Extension: "+type.get_extension()+"</tr>"
                    +"</td>"
                +"</table>"
            +"</div>"
        +"</html>");
        
        inf.setFont(new Fonts(17));
        icn.setIcon(new ImageIcon(path));
        Gui_main.next("data");
    }
}
