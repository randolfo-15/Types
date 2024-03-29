/*!*********************************************************
 *  Gui_Delete 
 * ==============
 * @author: Randolfo A Goncalves
 * @since:  24/03/24
 * @file:   Gui_Delete.java 
 *
 * Classe dedicada para remoção por meio gráfico de types.
************************************************************/

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Gui_Delt extends Form{
// Fields
// ======
    private JTextField txf =  new JTextField(20);                 //< Campo de escrita
    private JLabel trash = new JLabel();                          //< Icone da lixeira
    
// Build
// =====
    Gui_Delt(String images){ init(images); }

    //! Inicialização:
    private void init(String images){
        plug(space(VERTICAL,30)); 
        plug(box("Search by name",new Component[]{
            init_field(images),
            init_button(new JButton("Delete"), images)
        }));
        plug(space(VERTICAL,68)); 
        plug(init_trash(images+"trash_fill.png"));
        plug(space(VERTICAL,40)); 
    }


// Define components(Events)
// =========================

    // Button:
    private JButton init_button(JButton btn,String path){ 
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(Gui_main.delete_item(txf.getText()))
                    trash.setIcon(new ImageIcon(path+"trash_empty.png"));
                txf.setText("");                       
            }
        });
        return btn; 
    }

    // Text field:
    private JTextField init_field(String path){ 
        txf.addKeyListener(new KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(trash.getIcon().toString().equals(path+"trash_empty.png")) 
                    trash.setIcon(new ImageIcon(path+"trash_fill.png"));
            }
        });  
        return txf; 
    }
    
    // Trash :
    private JLabel init_trash(String image){
        trash.setIcon(new ImageIcon(image));
        return trash;
    }
};
