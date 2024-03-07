/**
 *  Bank 
 * =====
 * @author: Randolfo A Gonçalves
 * @since:  06/02/24
 * @file:   Category.java 
 *
 * Classe dedicada para connect ao banco:
*/

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Bank{
// Fields
// ======
    protected Connection        cnt = null;    
    protected Statement         stt = null;
    protected PreparedStatement pstt= null;

// Build
// =====
    public Bank(String url){ connect(url); }

// Connection
// ==========
    private void connect(String url){
        try{ 
            cnt=DriverManager.getConnection(url);
            stt=cnt.createStatement();            
        } 
        catch(SQLException bug){ msg_erro(bug);   }
    }

    public void disconnet(){
        try{ if(cnt != null) cnt.close();       }
        catch(SQLException bug){ msg_erro(bug); }
    }
    
    protected void msg_erro(SQLException bug){ System.err.println(bug);}
    protected void msg_erro(IOException bug){  System.err.println(bug);}
 
}
