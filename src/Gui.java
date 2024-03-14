/*!*********************************************************
 *  Gui 
 * =====
 * @author: Randolfo
 * @since:  09/02/24
 * @file:   Main.java 
 *
 * Classe dedicada para exibiçaão do programa.
************************************************************/
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.event.*;

public class Gui {
//  Fields
// ========
// Banco de dados:
    private Bank_Types bank=null;                              //< Banco de dados
    private List<Types> types=new ArrayList<Types>();          //< Lista de tipos catalogados

// Componentes:
    private JFrame wd= new JFrame();                           //< Janela
    private List<JMenu> menus = new ArrayList<JMenu>();        //< Menus do JMenuBar
    private JMenuBar    mbar  = new JMenuBar();                //< Menu Bar   
    
    // Panal
    private JPanel main_panel = new JPanel(),                  //< Painel principal
                   data_panel = new JPanel();                  //< Painel de dados 
// Menus:
    private String[] edit={"Edit","Create","Delete"},          //< Edição
                     find={"Categoria","Nome"};                //< Busca

//  Build
// =======
    Gui(String path){ init(path); }

//  Inicialização
// ==============
    void init(String path){
       connect_bank(path);
       draw_windown(path);
       plug_components();
    }

//  Exibir Janela
// ===============
    void show(){ wd.setVisible(true); }

//---------------------------------> Plug <----------------------------------
    void plug_components(){
       wd.add(data_panel);
       wd.add(main_panel);
       wd.setJMenuBar(mbar);
    }
//---------------------------------> Bank <----------------------------------
    void connect_bank(String path){
        bank=new Bank_Types(path);
        bank.select_all(types);
    }
//---------------------------------> Draw <----------------------------------
// Definir diretorios:

    void draw_windown(String path){
       draw_frame(path+"/images/frame/"); 
       draw_menus(path+"/images/frame/");
       draw_buttons(path+"/images/button/");
    }

// Draw buttons:

    void draw_buttons(String path){
        for(var type:types){
            JButton button =new JButton(new ImageIcon(path+type.get_icon()));  
            button.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e) { data(type);}
            }); 
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);            
            main_panel.add(button);   
        }
    }

// Draw windown:

    void draw_frame(String path){
       wd.setSize(650, 600);                               
       wd.setIconImage(new ImageIcon(path+"int.png").getImage());
       wd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
       
       // Panel:
       data_panel.setBackground(Color.YELLOW);
       main_panel.setBackground(Color.GRAY);
    }

// Define menus: 
 
    void draw_menus(String path){
       menus.add(jmenu(path,new JMenu("Edit"),"edit.png",edit));
       menus.add(jmenu(path,new JMenu("Find"),"find.png",find));
       for(var menu:menus) mbar.add(menu);
    }

//  Draw menu:

    JMenu jmenu(String path, JMenu menu,String png,String[] tags){
        menu.setIcon(new ImageIcon(path+png));
        for(var tag:tags) menu.add(new JMenuItem(tag));
        return menu;
    }

//---------------------------------> Events <----------------------------------
    void data(Types type){
        bank.select(type);
        main_panel.setVisible(false); 
        data_panel.setVisible(true);
        
    }
      
}

