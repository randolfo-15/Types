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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Gui{
//  Fields
// ========
    private JFrame wd= new JFrame();                    //< Windown
    private List<JMenu> menus = new ArrayList<JMenu>(); //< Menus do JMenuBar
    private JMenuBar    mbar  = new JMenuBar();         //< Menu Bar
    private String images="",
                   root="";                           
    private JPanel pn1 = new JPanel();                  //< Primeiro panel
    private Bank_Types bank=null;
    private List<Types> types=new ArrayList<Types>();
    private List<JButton> buttons=new ArrayList<JButton>();

//  Build
// =======
    Gui(String path){ 
        root=path;
        images=path+"/images/";
        init(); 
    }

//  Inicialização
// ==============
    void init(){
       connect_bank();
       set_windown(); 
       set_menus();
       draw_buttons();
       wd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //< Close Wd
       wd.setJMenuBar(mbar);
    }

//  Exibir Janela
// ===============
    void show(){
       wd.setVisible(true);
    }

//---------------------------------> Bank <----------------------------------
    void connect_bank(){
        bank=new Bank_Types(root);
        bank.select_all(types);
    }
//---------------------------------> Look <----------------------------------

// Desenhar Botões
// ===============
    void draw_buttons(){
        for(var type:types) buttons.add(new JButton(type.get_name()));
        for(var button:buttons){
            //button.setBorderPainted(false);
            button.setBackground(Color.DARK_GRAY);
            button.setIcon(new ImageIcon(images+"icon/int.png"));
            pn1.add(button);
        }
    }

// Aparência da janela
// ===================
    void set_windown(){
       wd.setSize(800, 600);                               //< Proportion Wd
       wd.setIconImage(new ImageIcon(images+"icon/int.png").getImage());
       pn1.setBackground(Color.DARK_GRAY);
       wd.add(pn1);
    }

//      Menu
// ============== 
    void set_menus(){
       menus.add(_edit());
       menus.add(_find());
        
       for(var menu:menus) mbar.add(menu);
    }

//  Edit - Menu
// <----------->
    JMenu _edit(){
        JMenu edit=new JMenu("Edit");
        Icon icon=new ImageIcon(images+"icon/edit.png");
        edit.setIcon(icon);
        
        // Itens:
        edit.add(new JMenuItem("Create"));
        edit.add(new JMenuItem("Delete"));
        edit.add(new JMenuItem("Edit"));
        
        return edit;
    }

//  Find - Menu
// <----------->
    JMenu _find(){
        JMenu edit=new JMenu("Find");
        Icon icon=new ImageIcon(images+"icon/find.png");
        edit.setIcon(icon);
        
        //Itens:
        edit.add(new JMenuItem("Category"));
        edit.add(new JMenuItem("Name"));
        
        return edit;
    }
}
