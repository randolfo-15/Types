/*!*********************************************************
 *  Manager
 * =========
 * @author: Randolfo
 * @since:  19/02/24
 * @file:   Manager.java 
 *
 * Classe dedicada para gestão de paineis e memoria.
************************************************************/
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Manager extends JFrame{
//  Fields
// ========
    private static Container    panels = null;                 //< Buffer de paineis.
    private static String       root   = "";                   //< Path absolute.
    private static CardLayout   cards  = new CardLayout();     //< Manager panel
    private static JMenuBar     mbar   = new JMenuBar();       //< Menu Bar   
                                                                           
// Build 
// =====
    Manager(String path){ 
        Manager.root=path;
        init(path); 
    }

    //! Startup
    private void init(String path){
        init_windown();
        init_panels();
    }

    //! Startup Windown
    private void init_windown(){
       setJMenuBar(mbar);
       setSize(530, 590);                               
       setResizable(false);
       setIconImage(new ImageIcon(root+"/rec/windown/int.png").getImage());
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //! Startup Panels
    private void init_panels(){
       panels=getContentPane();
       panels.setLayout(cards);      
       panels.add("MAIN",new Gui_main(root)); 
       panels.add("INFO",new Gui_info(root));
       panels.add("DELT",new Gui_Delt(root));
    }

//  Methods Move
// ==============
    
    //! Return main menu 
    static void exit(){ cards.show(panels,"MAIN"); }

    //! Move panels
    static void next(String local){ cards.show(panels, local); }

//  Memory 
// ========
    
    //! Get types
    static ArrayList<Types> get_types(String path){return new Bank_Types(path).select_all();}
}

/*
     void define_menus(String path){
       menus.add(jmenu(path,new JMenu("Edit"),"edit.png",edit));
       menus.add(jmenu(path,new JMenu("Find"),"find.png",find));
       JMenu disk = new JMenu();
       disk.setIcon(new ImageIcon(path+"disk.png"));
       // Add action  
       menus.add(disk);
       for(var menu:menus) mbar.add(menu);
    }

    JMenu jmenu(String path, JMenu menu,String png,String[] tags){
        menu.setIcon(new ImageIcon(path+png));
        for(var tag:tags){ 
            JMenuItem item =new JMenuItem(tag);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){item_action(tag);} 
            });
            menu.add(item);
        }
        return menu;
    }

// ----------------------------------------------------------------------------
    void item_action(String tag){
        switch (tag){
            case "Delete": { cards.show(buff,"delt"); } break;
            case "Create":{}break;
            case "Edit":{}break;
            case "Name":{};break;
            case "Category":{} break;
        }
    }
    
    static boolean delete_item(String name){
        bank.delete(name);
        for(var btn: btns_main) 
            if(btn.my_name().equals(name)){
                btn.setVisible(false);
                return true;
            }
        return false;
    }


    void connect_bank(String data){ bank.connect(data).select_all(types); }

*/
