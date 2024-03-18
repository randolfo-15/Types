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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;

public class Gui {
//  Fields
// ========
    final int 
        main=0,     //< Index panel main
        data=1,     //< Index panel data
        info=2,     //< Index panel info
        delt=3;     //< Index panel delete

// Banco de dados:
    private Bank_Types  bank=new Bank_Types();                 //< Banco de dados
    private List<Types> types=new ArrayList<Types>();          //< Lista de tipos catalogados

// Componentes:
    private JFrame wd= new JFrame();                                 //< Janela
    private List<JMenu>   menus     = new ArrayList<JMenu>();        //< Menus do JMenuBar
    private JMenuBar      mbar      = new JMenuBar();                //< Menu Bar   
    private List<Btn>     btns_main = new ArrayList<Btn>();

    JPanel[] panels={
        new JPanel(new FlowLayout()),      //< Main panel
        new JPanel(new BorderLayout()),    //< Data panel
        new JPanel(new FlowLayout()),      //< Info panel
        new JPanel(new BorderLayout())     //< Delete panel
    };

    JPanel opts_delt = new JPanel();       // Opções da tela delete

    private CardLayout   cards = new CardLayout();
    private Container    buff  = null;
    private JLabel       label = new JLabel(),
                         icon  = new JLabel("    ");

// Menus:
    private String[] edit={"Edit","Create","Delete"},          //< Edição
                     find={"Category","Name"};                //< Busca

// BackGround:
    private Color bg = Color.DARK_GRAY;

// Graph panel:
    Graph  graphs= null;
// Font 
    Font font=null;
//  Build
// =======
    Gui(String path){ init(path); }

//  Inicialização
// ==============
    void init(String path){
       connect_bank(path);
       create_container();
       draw_windown(path+"/rec/");
       font=Fonts.create(path+"/rec/font/font.ttf", 18);
       plug_components(path+"/rec/windown/");
    }

//  Exibir Janela
// ===============
    void show(){ wd.setVisible(true); }

//---------------------------------> Plug <----------------------------------
    void plug_components(String path){
       // Buffer
       buff.add("main",panels[main]);
       buff.add("data",panels[data]);
       buff.add("delt",panels[delt]);

       // Panel -> Delete: 
       panels[delt].add(button_exit(path+"exit.png",factory_panel(new FlowLayout(),bg)),BorderLayout.SOUTH);

       // Panel -> Info:
       panels[info].add(icon);
       panels[info].add(label);
       
       // Panel -> Data:
       panels[data].add(panels[info],BorderLayout.CENTER); 
       panels[data].add(button_exit(path+"exit.png",factory_panel(new FlowLayout(),bg)),BorderLayout.SOUTH);
       
       // Panel -> Main:
       for(var button:btns_main)panels[main].add(button);
    }
//---------------------------------> Bank <----------------------------------
    void connect_bank(String data){ bank.connect(data).select_all(types); }

//---------------------------------> Draw <----------------------------------
// Definir diretorios:

    void draw_windown(String images){
       define_panels(images+"windown/");
       define_frame(images+"windown/"); 
       define_menus(images+"windown/");
       define_buttons(images);
    }
   
    void create_container(){
       // Main:
       buff = wd.getContentPane();    
       buff.setLayout(cards);
    }
    
    void define_panels(String path){ 
        for(var panel: panels) panel.setBackground(Color.DARK_GRAY);  
        panels[info] = factory_panel(path+"note.jpg");
    }
    
    void define_frame(String path){
       wd.setJMenuBar(mbar);
       wd.setSize(650, 600);                               
       wd.setIconImage(new ImageIcon(path+"int.png").getImage());
       wd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }
    

    void define_menus(String path){
       menus.add(jmenu(path,new JMenu("Edit"),"edit.png",edit));
       menus.add(jmenu(path,new JMenu("Find"),"find.png",find));
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

    void define_buttons(String path){for(var type:types)btns_main.add(create_btn_main(path+"types/",type));}

    Btn create_btn_main(String path,Types type){
        Btn btn = Btn.create(type.get_name(), path+type.get_icon());
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){data(type,path+type.get_icon());}}); 
        return btn;
    }
    
    JPanel button_exit( String image,JPanel panel){
        JButton btn = Btn.template("Exit",image,Color.GREEN);
        btn.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){exit();}});
        panel.add(btn);
        return panel;
    }
   
    JPanel factory_panel(LayoutManager manager,Color clr){ 
        JPanel panel=new JPanel(manager);
        panel.setBackground(clr);
        return panel;
    }
    
    Graph factory_panel(String image){ return new Graph(image); }

//---------------------------------> Events <----------------------------------
    void data(Types type,String path){
        label.setText(
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
        //label.setFont(font);
        label.setFont(new Font("Serif", Font.BOLD, 17));
        icon.setIcon(new ImageIcon(path));
        cards.show(buff,"data");
    }
     
    void exit(){ cards.show(buff,"main");}
    
    void item_action(String tag){
        switch (tag){
            case "Delete": delete_item(panel_delt());   break;
            case "Create":{}break;
            case "Edit":{}break;
            case "Name":{};break;
            case "Category":{} break;
        }
    }
    
    void delete_item(String name){
        bank.delete(name);
        for(var btn: btns_main) if(btn.my_name().equals(name)){btn.setVisible(false);break;}
    }

    String panel_delt(){
        cards.show(buff,"delt");
        return ""; 
    }
}













