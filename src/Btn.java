/*!*****************************************************************
 *   Btn 
 *  =====
 * @author: Randolfo A Gonçalves
 * @since:  06/02/24
 * @file:   Category.java 
 *
 * Classe dedicada para Simular um botão
*******************************************************************/

import javax.swing.ImageIcon;
import javax.swing.JButton;

class Btn extends JButton{
    // Fields
    // ======
    private String name;

    // Build
    // =====
    Btn(){}
    Btn(String name){ this.name=name; }
    Btn(String name,String image){ this.name=name; setIcon(new ImageIcon(image)); }
     
    // Methods
    // ======= 
    String my_name(){ return name; }
    static Btn create_btn(String name,String image){
        Btn btn =new Btn(name,image);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        return btn;
    }
}
