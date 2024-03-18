/*!*****************************************************************
 *   Btn 
 *  =====
 * @author: Randolfo A Gonçalves
 * @since:  06/02/24
 * @file:   Category.java 
 *
 * Classe dedicada para Simular um botão
*******************************************************************/

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;


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
    static Btn create(String name,String image){
        Btn btn =new Btn(name,image);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        return btn;
    }

    static JButton template(String name,String image,Color clr){
        JButton btn = new JButton(name,new ImageIcon(image));
        btn.setPreferredSize(new DimensionUIResource(150, 40));
        btn.setBorder(BorderFactory.createLineBorder(clr,1));
        return btn;     
    }
}
