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
import java.awt.event.*;
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
    private static CardLayout   cards  = new CardLayout();     //< Manager panel
    private static Query        query  = null;                 //< Memory             
    private JMenuBar mbar = new JMenuBar();                    //< Menu Bar   
    
    // Paths:
    private String   root = "",                                //< Path absolute.
                     rec  = "";
// Build 
// =====
    Manager(String path){ 
        root=path;
        rec =path+"rec/windown/"; 
        init(path); 
    }

    //! Startup
    private void init(String path){
        init_bank(); 
        init_windown();
        init_menu();
        init_panels();
    }

    //! Startup bank
    private void init_bank(){ query = new Query(root+"sql/data.db"); }

    //! Startup Windown
    private void init_windown(){
       setJMenuBar(mbar);
       setSize(530, 590);                               
       setResizable(false);
       setBackground(Form.bg);
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

    //! Startup Menu
    private void init_menu(){
       mbar.add(menu());
       mbar.add(edit()); 
       mbar.add(search());
    }

//  Menus
// =======
    //! Menu edit
    private JMenu edit(){
        JMenu menu = menu("Edit");
        menu.add(item(" Insert","NEW"));
        menu.add(item(" Update","EDIT"));
        menu.add(item(" Remova","DELT"));
        return menu;
    }

    //! Menu search
    private JMenu search(){
        JMenu menu = menu("Search");
        menu.add(item("Name"     , ""));
        menu.add(item("Category" , ""));
        return menu;
    }

    //! Menu Disk
    private JMenu menu(){
        JMenu menu = menu("Menu");
        menu.add(item("Types", "MAIN"));
        menu.add(item("Exit" , "EXIT"));
        return menu;
    }

    //! Menu 
    JMenu menu(String name){
        JMenu menu = new JMenu(name); 
        menu.setIcon(new ImageIcon(rec+name+".png")); 
        menu.setFont(new Fonts(17));
        return menu;
    }

    //! Itens
    private JMenuItem item(String name,String local){ 
        if(local.equals("EXIT")) ;
        JMenuItem item = new JMenuItem(name);
        item.setFont(new Fonts(16));
        item.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){next(local);}});
        return item;
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
    static ArrayList<Types> types(){return query.select_all();}
    
    //! Remove type
    static boolean remove(String type){ return query.delete(type); }
}

