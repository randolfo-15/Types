import java.awt.event.*;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui_Delete extends JPanel{
// Fields
// ======
    private BoxLayout box = new BoxLayout(this,BoxLayout.Y_AXIS); //< Layout Default
    private JTextField txf =  new JTextField(20);                 //< Campo de escrita
    private JLabel trash = new JLabel();                          //< Icone da lixeira
    
// Build
// =====
    Gui_Delete(String images){ init(images); }

    //! Inicialização:
    private void init(String images){
        setting();

        // Block:
        JPanel block = Gui_main.factory_panel();
        block.add(Gui_main.create_Label("Search by name: ", 17));
        block.add(init_field(images));
        block.add(init_button(new JButton("Delete"),images));
       
        // Plugs:
        add(Gui_main.space_Vtc(30));
        add(block);
        add(Gui_main.space_Vtc(38));
        add(init_trash(images+"trash_fill.png"));
        add(Gui_main.space_Vtc(70));
        add(Gui_main.button_exit(images+"exit.png",Gui_main.factory_panel()));
    }

// Set panel
// =========
    private void setting(){
        setLayout(box);                 //< Setting layout
        setBackground(Gui_main.bg);     //< Setting background
        Gui_main.border("Trash", this); //< Setting border
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
