/*!*********************************************************
 *  Form 
 * ======
 * @author: Randolfo A Goncalves
 * @since:  09/02/24
 * @file:   Form.java 
 *
 * Classe dedicada para padronização de recursos gui.
************************************************************/
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Component;
import javax.swing.Box;

public class Form extends JPanel{
//  Fields
// ========
    // Colour:
    protected static Color  
        bg  = Color.DARK_GRAY, //< Background
        fg  = Color.WHITE;     //< Foreground
    
    //! Buffer de Components
    private BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS); 

    //! Positions
    final boolean 
        VERTICAL    = true,
        HORITZONTAL = false; 

//  Build
// =======
   Form()                  { init(layout); } //< Default layout
   Form(LayoutManager mng) { init(mng);    } //< Custmized layout
   
   //! Initialization
   private void init(LayoutManager mng){
       setBorder(BorderFactory.createLineBorder(fg,1,true));
       setLayout(mng);
       setBackground(bg);
   }

//  Methods
// =========
    // Position -> ( Posicinar elementos em tela )
    // --------
    void plug(Component cpm){ add(cpm); }

    //  Panel
    // -------
    JPanel panel()                               { return factory(new JPanel(   ),false,"");    }
    JPanel panel(String title)                   { return factory(new JPanel(   ),true, title); }
    JPanel panel(LayoutManager mng)              { return factory(new JPanel(mng),false,"");    }
    JPanel panel(String title,LayoutManager mng) { return factory(new JPanel(mng),true, title); }
    JPanel panel(String title,String image)      { return factory(new Graph(image),true, title);}
    JPanel panel(String image,boolean border)    { return factory(new Graph(image),border,"");  }

    //! ( patterns ) - Fabrica de JPanel: 
    private JPanel factory(JPanel pnl,boolean bord,String title){
        pnl.setBackground(bg);
        if(bord) pnl.setBorder(BorderFactory.createTitledBorder(null, title, 0, 0,new Fonts(), fg)); 
        return pnl;
    } 
    
    //  Label
    // -------
    JLabel label(String text,int size)         { return factory(new JLabel(text),size);       }
    JLabel label(ImageIcon image)              { return factory(new JLabel(image),0);         }
    JLabel label(Icon img,String text,int size){ return factory(new JLabel(text,img,0),size); }

    //! ( patterns ) - Fabrica de JLabel:
    private JLabel factory(JLabel label,int size){
        label.setForeground(fg);
        label.setFont(new Font("Serif",Font.BOLD,size));
        return label;
    } 

    //  Separador
    // -----------
    Component space(boolean position,int n){
        return (position)?Box.createVerticalStrut(n):Box.createHorizontalStrut(n); 
    }

    //  Blocks
    // --------
    JPanel box(Component[] list){
        JPanel block = panel(new BoxLayout(null,BoxLayout.Y_AXIS)),
               pnl   = panel("");
        // Fill panel:
        for(var cmt: list) pnl.add(cmt);
        
        // Plug components
        block.add(space(HORITZONTAL,20));
        block.add(pnl);
        block.add(space(HORITZONTAL,20));
        
        return block;
    }
}
